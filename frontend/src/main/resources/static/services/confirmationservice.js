'use strict';

app.factory('ConfirmationService', ConfirmationService);

ConfirmationService.$inject = ['$http'];
function ConfirmationService($http) {
    var service = {};

    service.confirmRegistration = function (token) {
        return $http.get('/api/confirmRegistration?token=' + token);
    };

    return service;
}