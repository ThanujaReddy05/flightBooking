angular.module('flightBookingApp', ['ui.router', 'ngMap']).config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        
       
        const titleState = {           
            name: 'title',
            url: '/title',
            component: 'titleComponent'
        }

        const searchState = {
                name: 'searchForFlights',
                url: '/search',
                component: 'searchComponent'
            }

        const loginState = {
            name: 'login',
            url: '/login',
            component: 'loginComponent'
        }

        const newUserState = {
            name: 'newuser',
            url: '/newuser',
            component: 'newUserComponent'
        }

        const mapState = {            
            name: 'map',
            url: '/map',
            component: 'mapComponent'
        }

        const accountState = {
            name: 'userAccount',
            url: '/account',
            component: 'userAccountComponent'
        }

        const historyState = {
            name: 'history',
            url: '/history',
            component: 'historyComponent'
        }

        const profileState = {
            name: 'profile',
            url: '/profile',
            component: 'profileComponent'
        }
        

        $stateProvider.state(titleState)
                .state(searchState)
                .state(loginState)
                .state(newUserState)
                .state(historyState)
                .state(accountState)               
                .state(mapState)
                .state(profileState)

        $urlRouterProvider.otherwise('/title')
    }
])