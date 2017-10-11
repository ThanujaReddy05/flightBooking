angular.module('flightBookingApp').service('userAccountService', ['loginService','$http', function (loginService, $http) {

    this.createItinerary = (itinerary) => {
        return $http.post('http://localhost:8888/api/itinerary/' , itinerary)
    }

}])