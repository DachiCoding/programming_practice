var countdown = require('countdown');
var model = require('./model.js');

var helper = module.exports = {

  dateDiff: function() {
    return countdown(model.currentDate, model.eventDate);
  }

};
