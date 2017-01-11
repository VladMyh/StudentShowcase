'use strict';

app.controller('AllStudentsController', AllStudentsController);
AllStudentsController.$inject = ['$scope', 'StudentService'];

function AllStudentsController($scope, StudentService) {
    $scope.page = null;

    var init = function () {
        StudentService.GetPage(1, 10).then(function (res) {
            $scope.page = res.data;
        });
    };

    init();
}