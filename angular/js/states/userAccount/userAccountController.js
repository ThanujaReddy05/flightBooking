angular.module('flightBookingApp').controller('userAccountController', ['utilService', 'userAccountService', '$state',
    function (utilService, userAccountService, $state) {

        this.utilService = utilService
        this.reitinerary = {}
        this.user = utilService.user

        this.history = () => {
            $state.go('profile')
        }

        this.account = () => {
            $state.go('profile')
        }

        this.createItinerary = (flight) => {
            utilService.flight = flight
            this.itinerary = utilService.buildItinerary(this.user, flight)
            userAccountService.createItinerary(this.itinerary).then((succeedResponse) => {
                this.reitinerary = succeedResponse.data
            })
            $state.go('map')
        }
    }
])