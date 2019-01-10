"use strict";

new Vue({
  el: '#app',

  data: {
    message: 'Hello Vue!',
    grid: [],
    time: 0,
    file: '',
    uploaded: false,
    messageAvailable: false,
    color: 'alert-success'
  }, computed: {

    timeInMs() {
      return Math.round(this.time * 10E-6 * 100) / 100;
    }
  },

  methods: {
    handleFileUpload() {
      let formData = new FormData();
      formData.append('file', this.file);

      console.log('upload');
      axios.post('/api/grid', formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      }).then((response) => {
        this.uploaded = true;
        this.showMessage("SUCCESS!!! Your file was uploaded", "alert-success");
        this.grid = response.data.grid;
      })
        .catch(() => {
         this.showMessage("FAILURE!!! Your file wasn't uploaded", "alert-warning");
      });
    },

    submitFile() {
      this.file = this.$refs.file.files[0];
    },

    getGrid() {
      axios.get('/api/grid')
          .then((response) => {
            console.log(response);
            this.grid = response.data.grid;
            this.time = response.data.time;
            this.consoleLog();
          });
    },

    consoleLog() {
      console.log(this.grid);
    },
    showMessage(message, color) {
      this.messageAvailable = true;
      this.message = message;
      this.color = color;


      setTimeout(()=>{
        this.messageAvailable = false;
      },2500);
    }
  }
});
