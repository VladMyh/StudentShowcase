'use strict';

app.controller('AddTeacherController', AddTeacherController);
AddTeacherController.$inject = ['$scope', '$location', 'FacultyService', 'TeacherService'];

function AddTeacherController($scope, $location, FacultyService, TeacherService) {
    $scope.faculties = {};

    FacultyService.getAll().then(function (res) {
        $scope.faculties = res.data;
    });

    $scope.teacher = {};
    $scope.teacher.firstName = "";
    $scope.teacher.lastName = "";
    $scope.teacher.email = "";
    $scope.teacher.password = "";
    $scope.teacher.teacherInfo = {};

    $scope.register = function () {
        $scope.teacher.teacherInfo.faculty = $scope.teacher.teacherInfo.faculty.title;

        TeacherService.Register($scope.teacher)
            .then(function (response) {
                $scope.student = {};

                $scope.teacher.firstName = "";
                $scope.teacher.lastName = "";
                $scope.teacher.email = "";
                $scope.teacher.password = "";
                $scope.teacher.teacherInfo = {};
            });
    };
}