"use strict";

new Vue({
  el: '#app',

  data: {
    message: 'Hello Vue!', grid: [], time: 0, file: ''
  }, computed: {

    timeInMs() {
      return Math.round(this.time * 10E-6 * 100) / 100;
    }
  },

  methods: {
    handleFileUpload() {
      /*
                Initialize the form data
            */
      let formData = new FormData();

      /*
          Add the form data we need to submit
      */
      formData.append('file', this.file);

      /*
        Make the request to the POST /single-file URL
      */
      axios.post('/api/grid', formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      }).then((response) => {
        console.log(response.data);
        console.log('SUCCESS!!');
      })
        .catch(() => {
          console.log('FAILURE!!');
      });
    }, submitFile() {
      this.file = this.$refs.file.files[0];
    }, getGrid() {
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
