'use strict';

app.controller('LoginController', LoginController);
LoginController.$inject = ['AuthService', '$scope', '$location', '$rootScope', 'User'];

function LoginController(AuthService, $scope, $location, $rootScope, User) {
    $scope.credentials = {
        email : '',
        password : ''
    };

    $scope.login = function (credentials) {
        AuthService
            .login(credentials)
            .then(function (res) {
                $rootScope.authenticated = true;
                $location.path("/main");
                });
    };

    var init = function () {
        if(User.authenticated) {
            $location.path("/main");
        }
    };

    init();
}