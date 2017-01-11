'use strict';

app.controller('MyAccountController', MyAccountController);
MyAccountController.$inject = ['$scope', '$location', 'AuthService', 'User'];

function MyAccountController($scope, $location, AuthService, User) {
    $scope.userInfo = null;

    var init = function () {

        if(!User.authenticated) {
            $location.path("/main");
        }
        else {
            AuthService.myAccountInfo().then(function (res) {
                $scope.userInfo = res.data;
            });
        }
    };

    init();
}