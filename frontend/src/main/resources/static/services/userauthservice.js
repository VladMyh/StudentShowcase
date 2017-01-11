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

    authService.myAccountInfo = function () {
        if(User.token === null)
            return;

        return $http({
            method: 'GET',
            url: '/api/user/me',
            headers: {authorization: User.token}
        });
    };

    return authService;
}