/**
 * Diretiva adiciona ao dom um elemento de bloqueio de tela baseado numa expressão boleana
 * @param {type} sysacad
 * @returns {undefined}
 */
define(['app/sysacad'],
function(sysacad) {
    sysacad.directive('carregando', [function() {
        return {
            restrict: 'AE',
            scope: {
                carregando: '=carregando'
            },
            template: '<div class="modal-backdrop fade" data-ng-class="{in:carregando, out:!carregando}" style="z-index: 2000" data-ng-show="carregando"></div>\
                        <div class="carregando-container" data-ng-show="carregando" style="z-index: 2050">\
                            <p class="carregando-conteudo">\
                                <img src="imgs/loading.gif"><br>Carregando...\
                            </p>\
                        </div>'
        };
    }]);
});
