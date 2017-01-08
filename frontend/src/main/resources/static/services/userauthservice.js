'use strict';

app.factory('AuthService', AuthService);

AuthService.$inject = ['$http'];
function AuthService($http, Session) {
    var authService = {};

    authService.login = function (credentials) {

        var headers = credentials ? {authorization : "Basic "
        + btoa(credentials.email + ":" + credentials.password)
        } : {};

        return $http
            .get('/api/user', {headers : headers})
            .then(function (res) {
                Session.create(res.data.id, res.data.user.id, res.data.user.role);
                return res.data.user;
                console.log("Creating session: " + res.data.key);
            });
    };

    authService.isAuthenticated = function () {
        //return !!Session.userId;
        console.log("isAuthenticated");
    };

    authService.isAuthorized = function (authorizedRoles) {
        // if (!angular.isArray(authorizedRoles)) {
        //     authorizedRoles = [authorizedRoles];
        // }
        // return (authService.isAuthenticated() &&
        // authorizedRoles.indexOf(Session.userRole) !== -1);

        console.log("isAuthorized");
    };

    return authService;
}