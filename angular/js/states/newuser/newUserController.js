angular.module('flightBookingApp').controller('newUserController', ['utilService','newUserService','$state',
    function (utilService, newUserService, $state) {

        this.createUser = () => {
                const user = utilService.buildUser(
                    this.submission.username,
                    this.submission.password,
                    this.submission.firstName,
                    this.submission.lastName,
                    this.submission.email,
                    this.submission.phone)

                newUserService.createNewUser(user).then((succeedResponse) => {                    
                    $state.go('userAccount')
                })
            }
    }
])