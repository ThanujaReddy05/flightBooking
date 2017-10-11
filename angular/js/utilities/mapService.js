angular.module('flightBookingApp').service('mapService', ['$state', function ($state) {

const location =  {
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
  this.mapPaths = []


  class Map  {  
    constructor ($map, locations) {
      this.$map = $map
  
      // add markers from an angular constant
      const { memphis, nashville, knoxville } = locations
      const markers = [memphis, nashville, knoxville]
  
      markers.forEach(marker => this.addMarker(marker))
  
      // add paths manually
      const mapPaths = [
        [memphis, nashville, '#CC0099'],
        [nashville, knoxville, '#AA1100']
      ]
  
      paths.forEach(args => this.addPath(...args))
  
      // add path from webservice
      $map.getMarkerByCityName('Chattanooga')
        .then(chattanooga => {
          this.addPath(knoxville, chattanooga, '#FF3388')
        })
    }
  
    addMarker ({ latitude, longitude }) {
      this.markers.push({
        position: `[${latitude}, ${longitude}]`
      })
    }
  
    addPath (a, b, color) {
      this.paths.push({
        path: `[[${a.latitude}, ${a.longitude}], [${b.latitude}, ${b.longitude}]]`,
        strokeColor: color,
        strokeOpacity: 1.0,
        strokeWeight: 3,
        geodesic: true
      })
    }
  
  }

}]) 