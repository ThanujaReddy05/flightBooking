angular.module('flightBookingApp').service('loginService', ['$http', function ($http) {

    this.login = (submission) => {
        return $http.get('http://localhost:8888/api/users/', submission.username, submission.password)
    }

    this.getUser = (username) => {
        return $http.get('http://localhost:8888/api/users/' + username)
    }

}])