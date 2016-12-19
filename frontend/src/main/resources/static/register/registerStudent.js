'use strict';

app.controller('RegisterStudentController', RegisterStudentController);
RegisterStudentController.$inject = ['StudentService', '$location', '$scope'];

function RegisterStudentController(StudentService, $location, $scope) {
    $scope.student = {};
    $scope.student.firstName = "";
    $scope.student.lastName = "";
    $scope.student.email = "";
    $scope.student.password = "";

    $scope.register = function () {
        StudentService.Create($scope.student)
            .then(function (response) {
                if (response.success) {
                    console.log('Registration successful');
                    $location.path('/main');
                } else {
                    console.log(response.message);
                }
            });
    }


}