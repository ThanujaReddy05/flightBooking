angular.module('flightBookingApp').controller('loginController', ['$state',
    function ($state) {
        // this.submission = {}

        // this.usernameErrorCss = "black"
        // this.passwordErrorCss = "black"

        // this.guest = () => {
        //     this.submission.username = 'guest'
        //     this.submission.password = 'guest'
        //     this.login()
        // }

        // this.login = () => {
        //     loginService.login(this.submission).then((succeedResponse) => {
        //         userDataService.setUserCredentials(this.submission.username, this.submission.password)
        //         this.usernameErrorCss = "black"
        //         this.passwordErrorCss = "black"

        //         userDataService.activeFeed = userDataService.feedTypeEnum.MAIN
        //         userDataService.feedDependency = undefined
        //         userDataService.reloadIfNecessary('session.feed', "My ")
        //     }, (errorResponse) => {
        //         console.dir(errorResponse.status)
        //         if (errorResponse.status === 404) {
        //             // Username not found, shows error on username field
        //             this.submission.username = ''
        //             this.submission.password = ''
        //             this.usernameErrorCss = "red"
        //             this.passwordErrorCss = "black"
        //         }

        //         if (errorResponse.status === 401) {
        //             // Password not found, shows error on password field
        //             this.submission.password = ''
        //             this.passwordErrorCss = "red"
        //             this.usernameErrorCss = "black"
        //         }

        //     })
        // }

    }
])