'use strict';

app.factory('FacultyService', FacultyService);

FacultyService.$inject = ['$http', 'User'];
function FacultyService($http, User) {
    var service = {};

    service.getAll = function() {
        return $http({
            method: 'GET',
            url: '/api/faculties',
            headers: {authorization: User.token}
        });
    };

    return service;
}