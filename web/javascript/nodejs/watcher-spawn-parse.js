'use strict';
const fs = require('fs');
const spawn = require('child_process').spawn;
const filename = process.argv[2];

if(!filename){
    throw Error("A file to watch must be specified!");
}

fs.watch(filename, function(){
    let ls = spawn('ls',['-lh',filename]);
    let output = '';
    ls.stdout.on('data',function(chunk){
         output += chunk.toString();
    });

    ls.on('close',function(){
        let parts = output.split(/\s+/);
        console.dir([parts[0],parts[4],parts[8]]);
    });
});
