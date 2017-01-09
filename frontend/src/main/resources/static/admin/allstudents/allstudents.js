'use strict';

app.controller('AllStudentsController', AllStudentsController);
AllStudentsController.$inject = ['$scope', 'StudentService'];

function AllStudentsController($scope, StudentService) {
    var students = null;

    StudentService.GetPage(1, 10, "asc").then(function (res) {
        students = res.data;
    })
}