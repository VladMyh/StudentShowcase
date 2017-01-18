'use strict';

var app = angular.module('app', ['ngRoute']);

app.config(config);
config.$inject = ['$locationProvider', '$routeProvider', '$httpProvider', 'USER_ROLES'];

function config($locationProvider, $routeProvider, $httpProvider, USER_ROLES) {
    $locationProvider.hashPrefix('!');

    $routeProvider
        .when('/login', {
            templateUrl: 'login/login.html',
            controller: 'LoginController',
            data : {
                authorizedRoles: []
            }
        })
        .when('/main', {
            templateUrl: 'main/main.html',
            controller: 'MainController',
            data : {
                authorizedRoles: []
            }
        })
        .when('/registerStudent', {
            templateUrl: 'register/register_student.html',
            controller: 'RegisterStudentController',
            data : {
                authorizedRoles: [USER_ROLES.anonymous]
            }
        })
        .when('/admin/students', {
            templateUrl: 'admin/student/all/allstudents.html',
            controller: 'AllStudentsController',
            data : {
                authorizedRoles: [USER_ROLES.admin]
            }
        })
        .when('/admin/student/:id', {
            templateUrl: 'admin/student/view/viewstudent.html',
            controller: 'ViewStudentController',
            data : {
                authorizedRoles: [USER_ROLES.admin]
            }
        })
        .when('/admin/addtrack', {
            templateUrl: 'admin/track/add/addtrack.html',
            controller: 'AddTrackController',
            data : {
                authorizedRoles: [USER_ROLES.admin]
            }
        })
        .when('/admin/tracks', {
            templateUrl: 'admin/track/all/alltracks.html',
            controller: 'AllTracksController',
            data : {
                authorizedRoles: [USER_ROLES.admin]
            }
        })
        .when('/account', {
            templateUrl: 'account/myaccount.html',
            controller: 'MyAccountController',
            data : {
                authorizedRoles: [USER_ROLES.admin, 
                                  USER_ROLES.student, 
                                  USER_ROLES.teacher, 
                                  USER_ROLES.employer]
            }
        })

        .otherwise({redirectTo: '/main'});

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}

app.run(run);
run.$inject = ['$rootScope', '$location', 'User', 'USER_ROLES'];

function run($rootScope, $location, User, USER_ROLES) {
    $rootScope.$on('$routeChangeStart', function (event, next) {
        if(next.data != null) {
            if (!User.isAuthorized(next.data.authorizedRoles)) {
                event.preventDefault();

                if (User.authenticated) {
                    console.log("not authorizes");
                    $location.path("/main");
                }
                else {
                    console.log("not authenticated");
                    $location.path("/login");
                }
            }
        }
    });
}

app.service('User', UserService);

UserService.$inject = ['USER_ROLES'];
function UserService(USER_ROLES) {
    this.token = null;
    this.role = USER_ROLES.anonymous;
    this.authenticated = false;

    this.create = function (token, role, auth) {
        this.token = token;
        this.role = role;
        this.authenticated = auth;
    };

    this.delete = function () {
        this.token = null;
        this.role = USER_ROLES.anonymous;
        this.authenticated = false;
    };
    
    this.isAuthorized = function (roles) {
        if (!angular.isArray(roles)) {
            roles = [roles];
        }
        if(roles.length === 0) {
            return true;
        }
        return (this.authenticated && roles.indexOf(this.role) !== -1);
    };
}

app.constant('USER_ROLES', {
    admin : 'ADMIN',
    student : 'STUDENT',
    teacher : 'TEACHER',
    employer : 'EMPLOYER',
    anonymous : 'ANONYMOUS'
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