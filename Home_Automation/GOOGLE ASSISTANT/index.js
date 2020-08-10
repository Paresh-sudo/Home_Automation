'use strict';

const {dialogflow} = require('actions-on-google');
var admin = require('firebase-admin');
const functions = require('firebase-functions');
admin.initializeApp(functions.config().firebase);
var database = admin.database().ref();
const app = dialogflow();

app.intent('SWITCH1', (conv,{SWITCH1}) => {

database.child("SWITCH").update({
  SWITCH1: `${SWITCH1}`
});


conv.ask(`Ok Sir,Switch 1 ${SWITCH1}  successfully.`);
});


app.intent('SWITCH2', (conv,{SWITCH2}) => {


database.child("SWITCH").update({
  SWITCH2: `${SWITCH2}`
});


conv.ask(`Ok Sir,Switch 2 ${SWITCH2} successfully.`);
});

app.intent('SWITCH3', (conv,{SWITCH3}) => {

database.child("SWITCH").update({
  SWITCH3: `${SWITCH3}`
});
/*
var ref = database.ref("SWITCH/SWITCH2");

  ref.on("value", function(snapshot) {
  //console.log(snapshot.val());
}, function (errorObject) {
  //console.log("The read failed: " + errorObject.code);
});

*/
conv.ask(`Ok Sir,Switch 3 ${SWITCH3} successfully.`);
});



exports.yourAction = functions.https.onRequest(app);
