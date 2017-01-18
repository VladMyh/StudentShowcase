'use strict';

app.controller('ViewStudentController', ViewStudentController);
ViewStudentController.$inject = ['$scope', '$routeParams', 'StudentService'];

function ViewStudentController($scope, $routeParams, StudentService) {
    $scope.student = {};

    var init = function () {
        StudentService.GetById($routeParams.id).then(function (res) {
            $scope.student = res.data;
        });
    };

    init();

}