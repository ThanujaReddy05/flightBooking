angular.module('flightBookingApp').controller('titleController', ['$state',
function ($state) {

    this.search = () => {
       
        $state.go('searchForFlights')
        console.log("hello")
    }

}])   