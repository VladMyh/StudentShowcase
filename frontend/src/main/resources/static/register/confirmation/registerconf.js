'use strict';

app.controller('RegistrationConformationController', RegistrationConformationController);
RegistrationConformationController.$inject = ['$scope', '$routeParams', '$location', 'ConfirmationService'];

function RegistrationConformationController($scope, $routeParams, $location, ConfirmationService) {

    var init = function () {
        console.log("test");
        ConfirmationService.confirmRegistration($routeParams.token)
            .then(function (res) {
                console.log($routeParams.token);
                console.log(res.status);
            },
            function (res) {
                console.log(res.status);
                $location.path("/main");
            })
    };

    init();
}