define([
    "app/sysacad",
    "app/endpoint/sysacad-endpoint",
    "angular"
],
function (sysacad) {
    return sysacad.controller("CursosController", 
        ["$scope", "SysacadEndpoint",
        function ($scope, SysacadEndpoint) {
            $scope.requesting = SysacadEndpoint.requesting;
            $scope.cursos = [];
            
            $scope.init = function () {
                SysacadEndpoint.buscarCursos().then(function (cursos) {
                    $scope.cursos = cursos;
                });
            };
            
            $scope.init();
        }]);
});