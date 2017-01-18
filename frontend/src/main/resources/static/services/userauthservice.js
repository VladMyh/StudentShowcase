'use strict';

app.factory('AuthService', AuthService);

AuthService.$inject = ['$http', 'User', 'USER_ROLES'];
function AuthService($http, User, USER_ROLES) {
    var authService = {};

    authService.login = function (credentials) {
        return $http({
            method: 'POST',
            url: '/api/user',
            data: { email: credentials.email, password: credentials.password}
        })
            .then(function (res) {
                var role = null;

                switch (res.data.role) {
                    case "STUDENT":
                        role = USER_ROLES.student;
                        break;
                    case "ADMIN":
                        role = USER_ROLES.admin;
                        break;
                    case "TEACHER":
                        role = USER_ROLES.teacher;
                        break;
                    case "EMPLOYER":
                        role = USER_ROLES.employer;
                        break;
                    default:
                        role = USER_ROLES.anonymous;
                }

                User.create(res.data.token, role, true);
            });
    };

    authService.myAccountInfo = function () {
        if(User.token === null)
            return;

        return $http({
            method: 'GET',
            url: '/api/user/me',
            headers: {authorization: User.token}
        });
    };

    return authService;
}