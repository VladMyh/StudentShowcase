'use strict';

angular.module('app.login', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/login', {
            templateUrl: 'login/login.html',
            controller: 'LoginController'
        });
    }])

    .controller('LoginController', [function($scope) {
        $scope.testMessage = "Test message";
    }]);