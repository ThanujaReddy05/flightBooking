angular.module('flightBookingApp').controller('mapController', ['utilService','mapService','$state',
function (utilService, mapService, $state) {

    this.mapService = mapService

    const locations =  {
        memphis: {
          latitude: 35.1495,
          longitude: -90.0490
        },
      
        nashville: {
          latitude: 36.1627,
          longitude: -86.7816
        },
      
        knoxville: {
          latitude: 35.9606,
          longitude: -83.9207
        }
      }

    this.zoom = 7
    this.center = [35.5175, -86.5804]
    this.markers = []
    this.paths = []
  
    
  
      const { memphis, nashville, knoxville } = locations
      const markers = [utilService.flight.origin, utilService.flight.destination]

      const addMarker = ({ latitude, longitude }) => {
        this.markers.push({
          position: `[${latitude}, ${longitude}]`
        })
      }

      const addPath = (a, b, color) => {
        this.paths.push({
          path: `[[${a.latitude}, ${a.longitude}], [${b.latitude}, ${b.longitude}]]`,
          strokeColor: color,
          strokeOpacity: 1.0,
          strokeWeight: 3,
          geodesic: true
        })
      }
  
      markers.forEach(marker => addMarker(marker))
  
      const paths = [
        [memphis, nashville, '#CC0099']
       
      ]
  
      paths.forEach(args => addPath(...args))
  
      mapService.getMarkerByCityName(utilService.flight.destination).then((succeedResponse) => {        
           this.destination = succeedResponse.data
         addPath(utilService.flight.origin, this.destination, '#FF3388')
        }) 
  
}])