'use strict';

app.factory('AuthService', AuthService);

AuthService.$inject = ['$http'];
function AuthService($http) {
    var authService = {};

    authService.login = function (credentials) {
        return $http({
            method: 'POST',
            url: '/api/user',
            data: { email: credentials.email, password: credentials.password}
            //headers: {authorization: headers}
        })
            .then(function (res) {
                console.log("Creating session: " + res.data.token);
                return res.data.token;
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