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
        .when('/admin/students', {
            templateUrl: 'admin/allstudents/allstudents.html',
            controller: 'AllStudentsController'
        })
        .when('/account', {
            templateUrl: 'account/myaccount.html',
            controller: 'MyAccountController'
        })

        .otherwise({redirectTo: '/main'});

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}

app.service('User', function() {
    this.token = null;
    this.role = null;
    this.authenticated = false;

    this.create = function (token, role, auth) {
        this.token = token;
        this.role = role;
        this.authenticated = auth;
    };

    this.delete = function () {
        this.role = null;
        this.token = null;
        this.authenticated = false;
    };
});

app.constant('USER_ROLES', {
    admin : 'ADMIN',
    student : 'STUDENT',
    teacher : 'TEACHER',
    employer : 'EMPLOYER'
});

app.controller('ApplicationController', ApplicationController);
ApplicationController.$inject = ['$scope', '$rootScope', '$location', 'User'];

function ApplicationController($scope, $rootScope, $location, User) {
    $rootScope.authenticated = false;

    $scope.signOut = function () {
        $rootScope.authenticated = false;
        User.delete();

        $location.path('/main');
    }
}