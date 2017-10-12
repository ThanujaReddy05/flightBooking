angular.module('flightBookingApp').controller('titleController', ['titleService','utilService','$state',
function (titleService,utilService, $state) {

    this.origin = " "
    this.destination = " "   

    this.search = () => {
        titleService.findPaths(this.origin, this.destination).then((succeedResponse) => {
            utilService.paths = succeedResponse.data           
        })        
        $state.go('searchForFlights')      
    }

}])   