angular.module('flightBookingApp').component('titleComponent', {

    templateUrl: './js/states/title/titleTemplate.html',
    controller : 'titleController',
    bindings: {
        origin : '=',
        destination : '='
    }
    

})