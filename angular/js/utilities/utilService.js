angular.module('flightBookingApp').service('utilService', ['$state', function ($state) {

   
    this.paths = []


    class flight {
        constructor(origin, destination, flightTime, offset, layover, totalTime) {
            this.origin = origin
            this.destination = destination
            this.flightTime = flightTime
            this.offset = offset
            this.layover = layover
            this.totalTime = totalTime
        }
    
        getOrigin() {
            this.origin
        }
        getDestination() {
            this.destination
        }
        
    }
}])