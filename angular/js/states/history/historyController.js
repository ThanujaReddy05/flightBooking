angular.module('flightBookingApp').controller('historyController', ['utilService', '$state',
    function (utilService, $state) {

        this.map =() => {
            $state.go('map')
        }
        
}])