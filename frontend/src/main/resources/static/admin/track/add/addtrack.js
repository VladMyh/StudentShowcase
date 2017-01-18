'use strict';

app.controller('AddTrackController', AddTrackController);
AddTrackController.$inject = ['$scope', '$location', 'TrackService'];

function AddTrackController($scope, $location, TrackService) {
    $scope.track = {};
    $scope.track.title = null;
    $scope.track.description = null;

    $scope.addTrack = function (track) {
        TrackService
            .create(track)
            .then(function (res) {
                $location.path("/main");
            });
    };

}