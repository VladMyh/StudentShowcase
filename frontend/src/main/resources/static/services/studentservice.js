'use strict';

app.factory('StudentService', StudentService);

StudentService.$inject = ['$http', 'User'];
function StudentService($http, User) {
    var service = {};

    service.GetById = function (id) {
        return $http.get('/api/students/' + id).then(handleSuccess, handleError('Error getting student by id'));
    };

    service.Create = function (data) {
        return $http({
            method: 'POST',
            url: '/api/students',
            headers: {authorization: User.token},
            data: data
        });
    };

    service.GetPage = function(page, size, sort) {
        return $http({
            method: 'GET',
            url: '/api/students/pages',
            params: {
                page: page,
                size: size,
                sort: sort
            },
            headers: {authorization: User.token}
        });
    };

    function handleSuccess(res) {
        return res.data;
    }

    function handleError(error) {
        return function () {
            return { success: false, message: error };
        };
    }

    return service;
}