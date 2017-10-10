angular.module('flightBookingApp').controller('loginController', ['$state',
    function ($state) {
        this.login = () => {
            $state.go('userAccount')
        }

        this.guest = () => {
            $state.go('newUser')
        }
        
    }
])