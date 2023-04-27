<template>
  <l-map
    :center="center"
    :zoom="zoom"
    class="map"
    ref="map"
    @update:zoom="zoomUpdated"
    @update:center="centerUpdated"
  >
    <l-tile-layer :url="url"> </l-tile-layer>
    <map-marker v-for="marker in markers" :key="marker.id" :marker="marker">
    </map-marker>
  </l-map>
</template>

<script>
import { LMap, LTileLayer } from "vue2-leaflet";
import MapMarker from "./MapMarker";
import "leaflet/dist/leaflet.css";

// let imageUrl =
//   "https://cdn4.iconfinder.com/data/icons/small-n-flat/24/map-marker-128.png";

export default {
  components: {
    LMap,
    LTileLayer,
    MapMarker,
  },
  data() {
    return {
      url: "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
      center: [48.427452586056134, -123.35031490390607],
      zoom: 12,
      markers: [],
      //   {
      //     id: 1,
      //     imageUrl,
      //     coordinates: [48.427452586056134, -123.35031490390607],
      //   },
      //   {
      //     id: 2,
      //     imageUrl,
      //     coordinates: [48.40335879609444, -123.34903446343779],
      //   },
      //   {
      //     id: 3,
      //     imageUrl,
      //     coordinates: [48.415755024410906, -123.37533871319111],
      //   },
      //   {
      //     id: 4,
      //     imageUrl,
      //     coordinates: [48.41401650527631, -123.36556999252505],
      //   },
      //   {
      //     id: 5,
      //     imageUrl,
      //     coordinates: [48.423509239695235, -123.35607679550283],
      //   },
      // ],
    };
  },
  methods: {
    async getData() {
      const res = await fetch("http://localhost:8080/test");
      const finalRes = await res.json();
      this.markers = finalRes;
    },
    zoomUpdated(zoom) {
      this.zoom = zoom;
      console.log(this.markers);
    },
    centerUpdated(center) {
      this.center = center;
    },
  },
  mounted() {
    this.getData();
  },
};
</script>

<style>
.map {
  position: absolute;
  width: 100%;
  height: 100%;
  overflow: hidden;
}
</style>
