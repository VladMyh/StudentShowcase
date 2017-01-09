'use strict';

app.factory('StudentService', StudentService);

StudentService.$inject = ['$http', 'User'];
function StudentService($http, User) {
    var service = {};

    service.Create = Create;
    service.GetById = GetById;

    return service;

    function GetById(id) {
        return $http.get('/api/students/' + id).then(handleSuccess, handleError('Error getting student by id'));
    }

    function Create(data) {
        return $http({
            method: 'POST',
            url: '/api/students',
            headers: {authorization: User.token},
            data: data
        });
    }

    function handleSuccess(res) {
        return res.data;
    }

    function handleError(error) {
        return function () {
            return { success: false, message: error };
        };
    }
}