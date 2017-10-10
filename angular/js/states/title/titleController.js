angular.module('flightBookingApp').controller('titleController', ['titleService','utilService','$state',
function (titleService,utilService, $state) {

    this.origin = " "
    this.destination = " "
    // this.path = []

    this.search = () => {
       
        // console.log(this.origin)
        titleService.findPaths(this.origin, this.destination).then((succeedResponse) => {
            utilService.paths = succeedResponse.data
            
        })
        $state.go('searchForFlights')
        // console.dir(this.path)
        
    }

}])   