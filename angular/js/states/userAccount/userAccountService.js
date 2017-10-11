angular.module('flightBookingApp').service('userAccountService', ['loginService','$http', function (loginService, $http) {

    this.createItinerary = () => {
        return $http.post('http://localhost:8888/api/itinerary/', loginService.submission.username)
    }

}])