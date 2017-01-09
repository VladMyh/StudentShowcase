'use strict';

app.controller('RegisterStudentController', RegisterStudentController);
RegisterStudentController.$inject = ['StudentService', '$location', '$scope'];

function RegisterStudentController(StudentService, $location, $scope) {
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
    }


}