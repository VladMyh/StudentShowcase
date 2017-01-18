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

    return service;
}