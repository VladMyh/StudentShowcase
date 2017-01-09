'use strict';

app.factory('AuthService', AuthService);

AuthService.$inject = ['$http', 'User'];
function AuthService($http, User) {
    var authService = {};

    authService.login = function (credentials) {
        return $http({
            method: 'POST',
            url: '/api/user',
            data: { email: credentials.email, password: credentials.password}
        })
            .then(function (res) {
                User.create(res.data.token, res.data.role, true);
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