angular.module('flightBookingApp').controller('userAccountController', ['$state',
    function ($state) {

        this.history = () => {
            $state.go('history')
        }

        this.account = () => {
            $state.go('history')
        }
        
    }
])