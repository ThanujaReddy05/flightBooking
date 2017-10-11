angular.module('flightBookingApp').controller('newUserController', ['utilService','newUserService','$state',
    function (utilService, newUserService, $state) {

        this.createUser = () => {
            // if (this.submission.username !== '' &&
            //     this.submission.password !== '' &&
            //     this.submission.email !== '') {

                const user = utilService.buildUser(
                    this.submission.username,
                    this.submission.password,
                    this.submission.firstName,
                    this.submission.lastName,
                    this.submission.email,
                    this.submission.phone)

                newUserService.createNewUser(user).then((succeedResponse) => {
                    // User created, data will contain dto of user without its password
                    $state.go('userAccount')
                })
            }
    }
])