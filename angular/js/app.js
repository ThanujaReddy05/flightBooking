angular.module('flightBookingApp', ['ui.router', 'xeditable']).run(function (editableOptions) {
    editableOptions.theme = 'bs3';
}).config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        
        // const flightlistState = {
           
        //     name: 'flightlist',
        //     url: '/flightlist',
        //     component: 'flightlistComponent'
        // }


        const titleState = {
            // abstract: true,
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

        // const mapState = {
            
        //     name: 'map',
        //     url: '/map',
        //     component: 'mapComponent'
        // }

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

        

        $stateProvider.state(titleState)
                .state(searchState)
                .state(loginState)
                .state(newUserState)
                .state(historyState)
                .state(accountState)
                // .state(flightlistState)
                // .state(mapState)
            // .state(userListState)

        $urlRouterProvider.otherwise('/title')
    }
])