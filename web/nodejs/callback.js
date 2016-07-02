var fs = require('fs');

//var data = fs.readFileSync('target.txt');
//console.log(data.toString());

fs.readFile('target.txt',function(err,data){
    if (err) return console.error(err);
    console.log(data.toString());
});

console.log("Program Ended");
