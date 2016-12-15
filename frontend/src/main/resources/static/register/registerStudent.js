'use strict';

app.controller('RegisterStudentController', function($scope) {
    $scope.student = {};
    $scope.student.email = "";
    $scope.student.password = "";
    $scope.student.name = "";

    $scope.update = function(student) {
        $scope.student = angular.copy(student);
    }
});