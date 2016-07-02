"use strict";
const 
    fs = require('fs'),
    spawn = require('child_process').spawn,
    filename = process.argv[2];

if (!filename){
    throw Error("A file to watch must be specified.");
}

fs.watch(filename,function(){
    let ls = spawn('ls',['-lh',filename]);
    let logStream = fs.createWriteStream('./logFile.log',{flags:'a'});
    ls.stdout.pipe(process.stdout);
    //ls.stdout.pipe(logStream);
});

console.log("Now watching " + filename + " for changes...");
