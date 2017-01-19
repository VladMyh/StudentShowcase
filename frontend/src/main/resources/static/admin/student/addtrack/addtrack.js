'use strict';

app.controller('AddTrackToStudentController', AddTrackToStudentController);
AddTrackToStudentController.$inject = ['$scope', '$location', '$routeParams', 'TrackService', 'StudentService'];

function AddTrackToStudentController($scope, $location, $routeParams, TrackService, StudentService) {
    $scope.page = null;
    $scope.studentId = $routeParams.id;

    $scope.addTrack = function (trackId, studentId) {
        TrackService.AddStudentToTrack(studentId, trackId);
        StudentService.AddTrackToStudent(trackId, studentId);

        $location.path("/admin/student/" + $scope.studentId);
    };

    var init = function () {
        TrackService.GetPage(1, 100).then(function (res) {
            $scope.page = res.data;
        });
    };

    init();
}