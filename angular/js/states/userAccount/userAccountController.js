angular.module('flightBookingApp').controller('userAccountController', ['utilService','userAccountService','$state',
    function (utilService, userAccountService, $state) {

        this.utilService = utilService
        this.itinerary = []

        this.history = () => {
            $state.go('history')
        }

        this.account = () => {
            $state.go('history')
        }
        
        this.createItinerary = () => {
            userAccountService.createItinerary().then((succeedResponse) => {
            this.itinerary = succeedResponse.data
            })
        }
    }
])