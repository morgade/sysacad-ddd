define([
    "app/sysacad",
    "app/controller/alunos-controller",
    "app/controller/cursos-controller",
    "app/controller/inscricoes-controller",
    "app/controller/navbar-controller",
    "app/directive/carregando",
    "toaster"
], 
function(sysacad) {
    'use strict';

    // Configura rotas e interceptadores
    sysacad.config(['$routeProvider', '$logProvider', function($routeProvider, $logProvider) {
            $logProvider.debugEnabled(false);
            
            $routeProvider.when('/alunos', {
                templateUrl: 'partials/alunos.html',
                controller: 'AlunosController'
            });
            $routeProvider.when('/cursos', {
                templateUrl: 'partials/cursos.html',
                controller: 'CursosController'
            });
            $routeProvider.when('/inscricoes', {
                templateUrl: 'partials/inscricoes.html',
                controller: 'InscricoesController'
            });
            
            $routeProvider.otherwise({redirectTo: '/alunos'});
        }]);

});
