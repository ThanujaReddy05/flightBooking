angular.module('flightBookingApp').controller('loginController', ['loginService', 'utilService', '$state',
    function (loginService, utilService, $state) {


        this.utilService = utilService

        this.submission = {}

        this.guest = () => {
            this.submission.username = 'guest'
            this.submission.password = 'guest'
            this.login()
        }


        this.login = () => {
            loginService.login(this.submission).then((succeedResponse) => {
                $state.go('userAccount')
            })
            utilService.username = this.submission.username
            loginService.getUser(utilService.username).then((succeedResponse) => {
                utilService.user = succeedResponse.data
            })
        }

        this.createNewuser = () => {
            $state.go('newuser')
        }

    }
])