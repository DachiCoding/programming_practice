const EventEmitter = require('events');
const util = require('util');

function MyEmitter(){
    EventEmitter.call(this);
}
util.inherits(MyEmitter,EventEmitter);

const myEmitter = new MyEmitter();

//myEmitter.on('event',() => {
//    console.log('an event occurred!');
//});

myEmitter.on('event',function(a,b){
    console.log(a,b,this);
});

myEmitter.emit('event');
