define([
    "app/sysacad",
    "app/endpoint/sysacad-endpoint",
    "angular"
],
function (sysacad) {
    return sysacad.controller("AlunosController", 
        ["$scope", "SysacadEndpoint",
        function ($scope, SysacadEndpoint) {
            $scope.requesting = SysacadEndpoint.requesting;
            $scope.alunos = [];
            
            $scope.init = function () {
                SysacadEndpoint.buscarAlunos().then(function (alunos) {
                    $scope.alunos = alunos;
                });
            };
            
            $scope.init();
        }]);
});