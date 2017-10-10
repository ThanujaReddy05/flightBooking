angular.module('flightBookingApp').service('titleService', ['$http', function ($http) {
    
        this.findPaths = (origin, destination) => {
            return $http.get('http://localhost:8888/api/flights/', origin, destination )
        }
    
    }])