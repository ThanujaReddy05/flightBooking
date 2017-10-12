angular.module('flightBookingApp').service('utilService', ['$state', function ($state) {

    this.paths = []
    this.flights = []
    this.username = " "
    this.user = {}
    this.flight = {}
    this.itinerary = {}

    this.buildUser = (username, password, firstName, lastName, email, phone) => {
        return new User(username, password, firstName, lastName, email, phone)
    }

    this.buildItinerary = (user, flight) => {
        return new Itinerary(user, flight)
    }

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

        getFlightTime() {
            this.flightTime
        }

        getOffset() {
            this.offset
        }

        getLayover() {
            this.layover
        }

        getTotaltime() {
            this.totalTime
        }

    }

    class User {
        constructor(username, password, firstName, lastName, email, phone) {
            this.username = username
            this.password = password
            this.firstName = firstName
            this.lastName = lastName
            this.email = email
            this.phone = phone
        }

        getUsername() {
            this.username
        }
        getPassword() {
            this.password
        }
        
        getFirstName() {
            this.firstName
        }
        getLastName() {
            this.lastName
        }
        getEmail() {
            this.email
        }
        getPhone() {
            this.phone
        }
    }


    class Itinerary {
        constructor(user, flight) {
            this.user = user
            this.flight = flight
        }

        getUser() {
            this.user
        }
        getFlight() {
            this.flight
        }
    }
}])