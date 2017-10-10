angular.module('flightBookingApp').controller('searchController', ['$state',
    function ($state) {

        this.bookFlight = () => {
            $state.go('login')
        }
    }])