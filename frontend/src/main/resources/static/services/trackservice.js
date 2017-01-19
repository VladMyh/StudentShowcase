'use strict';

app.factory('TrackService', TrackService);

TrackService.$inject = ['$http', 'User'];
function TrackService($http, User) {
    var service = {};

    service.create = function(data) {
        return $http({
            method: 'POST',
            url: '/api/tracks',
            headers: {authorization: User.token},
            data: data
        });
    };

    service.GetPage = function(page, size) {
        return $http({
            method: 'GET',
            url: '/api/tracks/page/' + page + '/size/' + size,
            headers: {authorization: User.token}
        });
    };

    service.AddStudentToTrack = function (studentId, trackId) {
        return $http({
            method: 'POST',
            url: '/api/tracks/' + trackId + '/students',
            headers: {authorization: User.token},
            data : studentId
        });
    };

    service.GetAllByIds = function (ids) {
        return $http({
            method: 'GET',
            url: '/api/tracks/getAll/' + ids,
            headers: {authorization: User.token}
        });
    };

    return service;
}