'use strict';

app.factory('StudentService', StudentService);

StudentService.$inject = ['$http'];
function StudentService($http) {
    var service = {};

    service.Create = Create;
    service.GetById = GetById;

    return service;

    function GetById(id) {
        return $http.get('/api/students/' + id).then(handleSuccess, handleError('Error getting student by id'));
    }

    function Create(data) {
        return $http.post('/api/students', data).then(handleSuccess, handleError('Error creating student'));
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