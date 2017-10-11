angular.module('flightBookingApp').controller('titleController', ['titleService','utilService','$state',
function (titleService,utilService, $state) {

    this.origin = " "
    this.destination = " "
    

    this.search = () => {
       
        // console.log(this.origin)
        titleService.findPaths(this.origin, this.destination).then((succeedResponse) => {
            utilService.paths = succeedResponse.data
            console.dir(utilService.paths)
        })
        // utilService.paths.forEach((entry) => {
        //     console.dir(entry)
        //     utilService.flightList.add(new flight(entry.origin, entry.destination, entry.flightTime, entry.offset, entry.layover, entry.totalTime))
        // })
        // console.dir(utilService.flightList)
        $state.go('searchForFlights')
        // console.dir(this.path)
        
    }

}])   