angular.module('flightBookingApp').controller('searchController', ['$state','utilService',
    function ($state,utilService) {

        this.utilService = utilService

        this.bookFlight = () => {
            $state.go('login')
        }

    }])