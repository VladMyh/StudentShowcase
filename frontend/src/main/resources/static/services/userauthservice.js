'use strict';

app.factory('AuthService', AuthService);

AuthService.$inject = ['$http'];
function AuthService($http, Session) {
    var authService = {};

    authService.login = function (credentials) {
        return $http
            .post('/api/auth', credentials)
            .then(function (res) {
                //Session.create(res.data.id, res.data.user.id, res.data.user.role);
                //return res.data.user;

            });
    };

    authService.isAuthenticated = function () {
        //return !!Session.userId;
    };

    authService.isAuthorized = function (authorizedRoles) {
        if (!angular.isArray(authorizedRoles)) {
            authorizedRoles = [authorizedRoles];
        }
        return (authService.isAuthenticated() &&
        authorizedRoles.indexOf(Session.userRole) !== -1);
    };

    return authService;
}