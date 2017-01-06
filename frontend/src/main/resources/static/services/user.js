'use strict';

app.factory('User', User);

function User() {
    this.create = function (name, role, token) {
        this.name = name;
        this.role = role;
        this.token = token;
    };
    this.delete = function () {
        this.name = null;
        this.role = null;
        this.token = null;
    };
}