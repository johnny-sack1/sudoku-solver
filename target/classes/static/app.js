"use strict";

new Vue({
  el: '#app',

  data: {
    message: 'Hello Vue!', grid: [], time: 0
  }, computed: {

    timeInMs() {
      return Math.round(this.time * 10E-6 * 100) / 100;
    }
  },

  methods: {
    getGrid() {
      axios.get('/api/grid')
          .then((response) => {
            console.log(response);
            this.grid = response.data.grid;
            this.time = response.data.time;
            this.consoleLog();
          });
    }, consoleLog() {
      console.log(this.grid);
    }
  }

});
