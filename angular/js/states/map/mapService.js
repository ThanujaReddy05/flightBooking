angular.module('flightBookingApp').service('mapService', ['$http', function ($http) {

  this.getMarkerByCityName = (name) => {  

      return $http.get('http://localhost:8888/api/location/' + name)
  }

  
}]) 