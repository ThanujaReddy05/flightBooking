angular.module('flightBookingApp').controller('userAccountController', ['utilService','userAccountService','$state',
    function (utilService, userAccountService, $state) {

        this.utilService = utilService
        // this.reitinerary = {}
        this.user = utilService.user

        // this.flight = " "

        this.history = () => {
            $state.go('history')
        }

        this.account = () => {
            $state.go('history')
        }
        
        this.createItinerary = (flight) => {
           
            this.itinerary = utilService.buildItinerary(this.user, flight)
            console.dir(this.itinerary )
            userAccountService.createItinerary(this.itinerary).then((succeedResponse) => {
            this.reitinerary = succeedResponse.data
            })
             console.dir(this.reitinerary )
        //    $state.go('map')
        }
    }
])