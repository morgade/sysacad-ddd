requirejs.config({
    waitSeconds: 0,
    baseUrl: "js/",
    paths: {
        'angular': 'lib/angular/1.4.4/angular.min',
        'angularAnimate': 'lib/angular/1.4.4/angular-animate.min',
        'angularRoute': 'lib/angular/1.4.4/angular-route.min',
        'angularResource': 'lib/angular/1.4.4/angular-resource.min',
        'angularSanitize': 'lib/angular/1.4.4/angular-sanitize.min',
        'angularMocks': 'lib/angular/1.4.4/angular-mocks',
        'angularLocalePtBr': 'lib/angular/1.4.4/i18n/angular-locale_pt-br',
        'angularLocalStorage': 'lib/angular-local-storage/0.2.2/angular-local-storage.min',
        'uiBootstrap': 'lib/angular-ui/0.13.3/ui-bootstrap-tpls-0.13.3.min',
        'jquery': 'lib/jquery/1.11.0/jquery.min',
        'moment': 'lib/moment/2.10.6/moment.min',
        'moment-pt-br': 'lib/moment/2.10.6/locale/pt-br',
        'datetimepicker': 'lib/datetimepicker/0.3.13/datetimepicker',
        'bootstrap': 'lib/bootstrap/3.2.0/bootstrap.min',
        'toaster': 'lib/angularjs-toaster/0.4.7/toaster'
    },
    shim: {
        'angular':           {exports: 'angular'},
        'angularAnimate':    {deps: ['angular']},
        'angularRoute':      {deps: ['angular']},
        'angularResource':   {deps: ['angular']},
        'angularSanitize':   {deps: ['angular']},
        'angularLocalePtBr': {deps: ['angular']},
        'angularLocalStorage': {deps: ['angular']},
        'uiBootstrap':       {deps: ['angular']},
        'bootstrap':         {deps: ['jquery'], exports: 'bootstrap'},
        'toaster':           {deps: ['angular','angularAnimate']}
    }
});

requirejs([
    "angular",
    "jquery",
    "bootstrap",
    "app/sysacad",
    "app/routes"
],
function(angular) {
    angular.bootstrap(window.document, ['sysacad']);
});