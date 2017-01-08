'use strict';

var app = angular.module('app', ['ngRoute']);

app.config(config);

config.$inject = ['$locationProvider', '$routeProvider', '$httpProvider'];
function config($locationProvider, $routeProvider, $httpProvider) {
    $locationProvider.hashPrefix('!');

    $routeProvider
        .when('/login', {
            templateUrl: 'login/login.html',
            controller: 'LoginController'
        })
        .when('/main', {
            templateUrl: 'main/main.html',
            controller: 'MainController'
        })
        .when('/registerStudent', {
            templateUrl: 'register/register_student.html',
            controller: 'RegisterStudentController'
        })
        .otherwise({redirectTo: '/main'});

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}

app.constant('USER_ROLES', {
    admin : 'ADMIN',
    student : 'STUDENT',
    teacher : 'TEACHER',
    employer : 'EMPLOYER'
});

app.controller('ApplicationController', ApplicationController);
ApplicationController.$inject = ['AuthService', '$scope'];

function ApplicationController(AuthService, $scope) {
    $scope.user = null;

    $scope.setCurrentUser = function (user) {
        $scope.currentUser = user;
    };
}