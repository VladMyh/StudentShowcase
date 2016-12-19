'use strict';

var app = angular.module('app', ['ngRoute']);

app.config(config);

config.$inject = ['$locationProvider', '$routeProvider'];
function config($locationProvider, $routeProvider) {
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
}