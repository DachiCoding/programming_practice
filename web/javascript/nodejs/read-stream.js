const fs = require('fs');
const stream = fs.createReadStream(process.argv[2]);
stream.on('data',function(chunk){
    process.stdout.write(chunk);
});
stream.on('error',function(err){
    process.stderr.write("ERROR: " + err.message + "\n");
});
