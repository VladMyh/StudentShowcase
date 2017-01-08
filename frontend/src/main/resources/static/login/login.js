'use strict';

app.controller('LoginController', LoginController);
LoginController.$inject = ['AuthService', '$scope', '$rootScope'];

function LoginController(AuthService, $scope, $rootScope) {
    $scope.credentials = {
        email : '',
        password : ''
    };

    $scope.login = function (credentials) {
        AuthService
            .login(credentials)
            .then(function (user) {
                //$scope.setCurrentUser(user);
                console.log("login page success");
                });
    };


}