'use strict';

app.controller('ViewStudentController', ViewStudentController);
ViewStudentController.$inject = ['$scope', '$routeParams', '$location', 'StudentService'];

function ViewStudentController($scope, $routeParams, $location, StudentService) {
    $scope.student = {};

    $scope.addTrack = function () {
        $location.path("/admin/student/" + $routeParams.id + "/addtrack")
    };

    var init = function () {
        StudentService.GetById($routeParams.id).then(function (res) {
            $scope.student = res.data;
        });
    };

    init();

}