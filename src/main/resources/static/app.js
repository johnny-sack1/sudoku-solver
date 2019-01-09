"use strict";

new Vue({
  el: '#app',

  data: {
    message: 'Hello Vue!', grid: []
  },

  methods: {
    getGrid() {
      axios.get('/api')
          .then((response) => {
            this.grid = response.data.grid;
            this.consoleLog();
          });
    }, consoleLog() {
      console.log(this.grid);
    }
  }

});

// Make a request for a user with a given ID
