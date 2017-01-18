'use strict';

app.controller('ViewStudentController', ViewStudentController);
ViewStudentController.$inject = ['$scope', '$routeParams', '$location', 'StudentService', 'TrackService'];

function ViewStudentController($scope, $routeParams, $location, StudentService, TrackService) {
    $scope.student = {};
    $scope.tracks = {};

    $scope.addTrack = function () {
        $location.path("/admin/student/" + $routeParams.id + "/addtrack")
    };

    var init = function () {
        StudentService.GetById($routeParams.id).then(function (res) {
            $scope.student = res.data;

            var tracks = res.data.studentInfo.tracks;
            

            TrackService.GetAllByIds().then(function (res) {
                $scope.tracks = res.data;
            })
        });
    };

    init();

}