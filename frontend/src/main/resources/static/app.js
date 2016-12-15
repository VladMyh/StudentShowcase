'use strict';

var app = angular.module('app', ['ngRoute']);

app.config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
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
}]);