angular.module('flightBookingApp').controller('profileController', ['utilService', '$state',
    function (utilService, $state) {

        this.visibility = true

        this.firstName = utilService.user.firstName
        this.lastName = utilService.user.lastName
        this.email = utilService.user.email
        this.phone = utilService.user.phone

        this.deactivateUser = () => {
            profileService.deactivateUser().then((succeedResponse) => {
               
                $state.go('title')
            })
        }

        this.toggle = () => {
            if (this.visibility) {
                this.visibility = false
            } else {
               this.visibility = true
            }
        }
    }
])