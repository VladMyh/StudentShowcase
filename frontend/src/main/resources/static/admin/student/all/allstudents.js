'use strict';

app.controller('AllStudentsController', AllStudentsController);
AllStudentsController.$inject = ['$scope', '$location', 'StudentService'];

function AllStudentsController($scope, $location, StudentService) {
    $scope.page = null;

    $scope.editStudent = function (id) {
        $location.path("/admin/student/" + id);
    };

    var init = function () {
        StudentService.GetPage(1, 100).then(function (res) {
            $scope.page = res.data;
        });
    };

    init();
}