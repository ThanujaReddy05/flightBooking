angular.module('flightBookingApp').service('profileService', ['utilService', '$http', function (utilService, $http) {

    this.deactivateUser = () => {
        return $http.post('http://localhost:8888/api/users/delete/@' + utilService.username)
    }   

    this.getItinerary = (username) => {
        return $http.get('http://localhost:8888/api/users/' , utilService.username)
    }

}])