define(["app/sysacad",
        "angular"],
    
function(sysacad, angular) {
    'use strict';

    sysacad.factory("JsonRpc", [ '$http', '$q', '$log', '$window', 'toaster',  function ($http, $q, $log, $window, toaster) {
            /**
             * Processa argumentos do método para formato de dados esperados no json-rpc
             * @param {type} argument
             */
            var parseArgument = function (argument) {
                if (angular.isArray(argument)) {
                    var parsedArray = angular.copy(argument);
                    for (var i=0; i<argument.length; i++) {
                        parsedArray[i] = parseArgument(argument[i]);
                    }
                    return parsedArray;
                } else if (angular.isDate(argument)) {
                    return argument.getTime();
                } else if (angular.isObject(argument)) {
                    var parsedObject = angular.copy(argument);
                    for (var prop in argument) {
                        if (argument.hasOwnProperty(prop)) {
                            parsedObject[prop] = parseArgument(argument[prop]);
                        }
                    }
                    return parsedObject;
                }
                return argument;
            };
            
            var JsonRpc = {
                requesting: {
                    active: 0
                },
                request: function () {
                            var argumentArray = [];
                            for (var i = 0; i < arguments.length; i++) {
                                argumentArray[i] = parseArgument(arguments[i]);
                            }

                            var data = {
                                method: this.method,
                                params: argumentArray,
                                jsonrpc: '2.0',
                                id: 0
                            };

                            $log.debug("Mandando requisição para '" + data.method + "'");

                            JsonRpc.requesting[data.method] = true;
                            JsonRpc.requesting.active++;

                            return $http.post(this.url, data, {'Content-Type': 'application/json'}).then(function (response) {
                                delete JsonRpc.requesting[data.method];
                                JsonRpc.requesting.active--;

                                if (response.data.error) {
                                    if (response.data.error.message.indexOf('fcorp.exception.notauthenticated') === 0) {
                                        $window.alert('A sua sessão no sistema expirou.\nVocê será redirecionado à tela inicial');
                                        $window.location.reload();
                                    } else {
                                        toaster.pop('error', 'Erro', response.data.error.message);
                                        // Dump da stack-trace
                                        if (angular.isArray(response.data.error.data)) {
                                            $log.warn("---------------------------   Dump de exceção no servidor   ----------------------------");
                                            for (var i = 0; i < response.data.error.data.length; i++) {
                                                var s = response.data.error.data[i];
                                                $log.warn(s.className + "." + s.methodName + " na linha " + s.lineNumber);
                                            }
                                        }
                                    }
                                    return $q.reject(response.data.error.message);
                                } else {
                                    return response.data.result;
                                }

                            }, function (error) {
                                delete JsonRpc.requesting[data.method];
                                JsonRpc.requesting.active--;
                                if (error.status === 0) {
                                    alert("Não foi possível contactar o servidor\nO sistema parece estar indisponível no momento");
                                } else {
                                    alert("Erro na requisição: " + error);
                                }
                                $log.error("Erro na requisição para '" + data.method + "'");
                                $log.error(error);
                            });
                        }
            };
            
            return JsonRpc;
    }]);

});
