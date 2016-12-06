var app = angular.module('app', ['ngRoute']);

app.controller('studentInfo', function($scope, $http) {
    $http.get('http://localhost:8080/   ')
})