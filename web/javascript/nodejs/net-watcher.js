'use strict';
const fs = require('fs');
const net = require('net');
const filename = process.argv[2];
const server = net.createServer(function(connection){
    console.log('Subscriber connected');
    connection.write("Now watching " + filename + " for changes...\n");

    let watcher = fs.watch(filename,function(){
        connection.write("File " + filename + " changed: " + Date.now() + "\n");
    });

    connection.on('close', function(){
        console.log('Subscriber disconnected.');
        watcher.close();
    });
});

if(!filename){
    throw Error('No target filename was specified.');
}

server.listen(5432,function(){
    console.log('Listening for subscribers...');
})
