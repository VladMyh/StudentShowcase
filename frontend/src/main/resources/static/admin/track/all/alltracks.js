'use strict';

app.controller('AllTracksController', AllTracksController);
AllTracksController.$inject = ['$scope', 'TrackService'];

function AllTracksController($scope, TrackService) {
    $scope.page = null;

    var init = function () {
        TrackService.GetPage(1, 100).then(function (res) {
            $scope.page = res.data;
        });
    };

    init();
}