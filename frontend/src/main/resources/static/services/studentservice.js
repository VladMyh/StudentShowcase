'use strict';

app.factory('StudentService', StudentService);

StudentService.$inject = ['$http', 'User'];
function StudentService($http, User) {
    var service = {};

    service.GetById = function (id) {
        return $http({
            method: 'GET',
            url: '/api/students/' + id,
            headers: {authorization: User.token}
        })
    };

    service.Create = function (data) {
        return $http({
            method: 'POST',
            url: '/api/students',
            headers: {authorization: User.token},
            data: data
        });
    };

    service.GetPage = function(page, size) {
        return $http({
            method: 'GET',
            url: '/api/students/page/' + page + '/size/' + size,
            headers: {authorization: User.token}
        });
    };

    return service;
}