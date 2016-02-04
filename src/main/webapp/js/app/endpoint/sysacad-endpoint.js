define([
    "app/sysacad",
    "angular",
    "app/endpoint/json-rpc"],
function(sysacad, angular) {
    'use strict';

    sysacad.provider('SysacadEndpoint', function() {

        this.$get = [ 'JsonRpc',  function(JsonRpc) {
            var url = '/sysacad/json.do';

            var SysacadEndpoint = {
                requesting: JsonRpc.requesting,
                inscrever : angular.bind({ url: url, method: 'inscrever'}, JsonRpc.request),
                buscarAlunos : angular.bind({ url: url, method: 'buscarAlunos'}, JsonRpc.request),
                buscarCursos : angular.bind({ url: url, method: 'buscarCursos'}, JsonRpc.request),
                buscarDisciplinas : angular.bind({ url: url, method: 'buscarDisciplinas'}, JsonRpc.request),
                buscarTurmas : angular.bind({ url: url, method: 'buscarTurmas'}, JsonRpc.request),
                buscarTurma : angular.bind({ url: url, method: 'buscarTurma'}, JsonRpc.request),
                aprovarInscricao : angular.bind({ url: url, method: 'aprovarInscricao'}, JsonRpc.request),
                reprovarInscricao : angular.bind({ url: url, method: 'reprovarInscricao'}, JsonRpc.request)
            };
            
            return SysacadEndpoint;
        } ];

    });

});
