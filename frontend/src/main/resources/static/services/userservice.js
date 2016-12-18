'use strict';

app.factory('UserService',UserService);

UserService.$inject = ['$http'];
function UserService($http) {
    var service = {};

    service.Create = Create;
    service.GetById = GetById;
    service.GetByUsername = GetByUsername;

    return service;

    function GetById(id) {
        return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
    }

    function GetByUsername(username) {
        return $http.get('/api/users/' + username).then(handleSuccess, handleError('Error getting user by username'));
    }

    function Create(user) {
        return $http.post('/api/users', user).then(handleSuccess, handleError('Error creating user'));
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