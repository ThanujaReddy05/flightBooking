angular.module('flightBookingApp', ['ui.router', 'xeditable']).run(function (editableOptions) {
    editableOptions.theme = 'bs3';
}).config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {

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

        // const newUserState = {
        //     name: 'title.newuser',
        //     url: '/newuser',
        //     component: 'newUserComponent'
        // }

        // const sessionState = {
        //     abstract: true,
        //     name: 'session',
        //     url: '/session',
        //     component: 'sessionComponent'
        // }

        // const accountState = {
        //     name: 'session.account',
        //     url: '/account',
        //     component: 'accountComponent'
        // }

        // const feedState = {
        //     name: 'session.feed',
        //     url: '/feed',
        //     component: 'feedComponent'
        // }

        // const tweetState = {
        //     name: 'session.tweet',
        //     url: '/tweet',
        //     component: 'tweetComponent'
        // }

        // const userListState = {
        //     name: 'session.userlist',
        //     url: '/userlist',
        //     component: 'userListComponent'
        // }

        $stateProvider.state(titleState)
                .state(searchState)
                .state(loginState)
            // .state(newUserState)
            // .state(sessionState)
            // .state(accountState)
            // .state(feedState)
            // .state(tweetState)
            // .state(userListState)

        $urlRouterProvider.otherwise('/title')
    }
])