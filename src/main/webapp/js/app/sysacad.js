define([
    "angular",
    "angularRoute",
    "angularSanitize",
    "angularAnimate",
    "angularLocalePtBr",
    "uiBootstrap",
    "datetimepicker",
    "toaster"
],
function(angular) {
    var sysacad =  angular.module('sysacad', ['ngRoute', 
                                            'ngSanitize', 
                                            'ngLocale', 
                                            'ngAnimate', 
                                            'ui.bootstrap', 
                                            'ui.bootstrap.datetimepicker',
                                            'ui.bootstrap.pagination',
                                            'ui.bootstrap.buttons',
                                            'toaster'
                                      ]);
    
    return sysacad;
});