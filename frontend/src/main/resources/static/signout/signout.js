'use strict';

app.controller('LoginController', LoginController);
LoginController.$inject = ['$scope', '$location', '$rootScope', 'User'];

function LoginController(AuthService, $scope, $location, $rootScope, User) {
    $rootScope.authenticated = false;
    User.delete();

    $location.path('/main');
}