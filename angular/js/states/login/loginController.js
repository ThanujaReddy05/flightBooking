angular.module('flightBookingApp').controller('loginController', ['loginService','$state',
    function (loginService,$state) {
        
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
        }

        this.createNewuser = () =>
        {
            $state.go('newuser')
        }
        
    }
])