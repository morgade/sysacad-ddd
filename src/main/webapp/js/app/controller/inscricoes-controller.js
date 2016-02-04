define([
    "app/sysacad",
    "app/endpoint/sysacad-endpoint",
    "angular"
],
function (sysacad) {
    return sysacad.controller("InscricoesController", 
        ["$scope", "toaster", "SysacadEndpoint",
        function ($scope, toaster, SysacadEndpoint) {
            $scope.requesting = SysacadEndpoint.requesting;
            $scope.disciplinas = [];
            $scope.disciplina = null;
            $scope.turmas = [];
            $scope.turma = null;
            $scope.turmaCompleta = null;
            $scope.alunos = [];
            $scope.aluno = null;
            
            $scope.inscrever = function () {
                SysacadEndpoint.inscrever($scope.aluno.matricula, $scope.turma.id).then(function () {
                    toaster.pop('success', 'SYSACAD', 'Matrícula realizada com sucesso');
                    $scope.carregarTurmaCompleta();
                });
            };
            
            $scope.aprovar = function (aluno) {
                SysacadEndpoint.aprovarInscricao(aluno.matricula, $scope.turma.id).then(function () {
                    toaster.pop('success', 'SYSACAD', 'Matrícula aprovada com sucesso');
                    $scope.carregarTurmaCompleta();
                });
            };
            
            $scope.reprovar = function (aluno) {
                SysacadEndpoint.reprovarInscricao(aluno.matricula, $scope.turma.id).then(function () {
                    toaster.pop('success', 'SYSACAD', 'Matrícula reprovada com sucesso');
                    $scope.carregarTurmaCompleta();
                });
            };
            
            $scope.carregarTurmas = function () {
                $scope.turmas = [];
                $scope.turmaCompleta = null;
                if ($scope.disciplina) {
                    SysacadEndpoint.buscarTurmas($scope.disciplina.codigo).then(function (turmas) {
                        $scope.turmas = turmas;
                    });
                }
            };
            
            $scope.carregarTurmaCompleta = function () {
                $scope.turmaCompleta = null;
                if ($scope.turma) {
                    SysacadEndpoint.buscarTurma($scope.turma.id).then(function (turma) {
                        $scope.turmaCompleta = turma;
                    });
                }
            }
                
            
            $scope.init = function () {
                SysacadEndpoint.buscarDisciplinas().then(function (disciplinas) {
                    $scope.disciplinas = disciplinas;
                    return SysacadEndpoint.buscarAlunos();
                }).then(function (alunos) {
                    $scope.alunos = alunos;
                });
                
                $scope.$watch('disciplina', $scope.carregarTurmas);
                
                $scope.$watch('turma', $scope.carregarTurmaCompleta);
            };
            
            $scope.init();
        }]);
});