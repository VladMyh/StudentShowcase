'use strict';

app.factory('TeacherService', TeacherService);

TeacherService.$inject = ['$http', 'User'];
function TeacherService($http, User) {
    var service = {};

    service.Register = function (data) {
        return $http({
            method: 'POST',
            url: '/api/teachers/register',
            headers: {authorization: User.token},
            data: data
        });
    };

    return service;
}