'use strict';

app.controller('RegisterStudentController', RegisterStudentController);
RegisterStudentController.$inject = ['StudentService', '$location', '$scope', 'FacultyService'];

function RegisterStudentController(StudentService, $location, $scope, FacultyService) {

    $scope.faculties = {};

    FacultyService.getAll().then(function (res) {
        $scope.faculties = res.data;
    });

    $scope.student = {};
    $scope.student.firstName = "";
    $scope.student.lastName = "";
    $scope.student.email = "";
    $scope.student.password = "";
    $scope.student.studentInfo = {};

    $scope.register = function () {
        StudentService.Create($scope.student)
            .then(function (response) {
                console.log('Registration successful');
                $scope.student = {};
                $location.path('/main');
            });
    };
}