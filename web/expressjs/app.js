const express = require("express");
const path = require("path");
const fs = require("fs");
const app = express();

app.use(function(req,res,next){
    console.log("Request ID: " + req.url);
    console.log("Request date: " + new Date());
    next();
});

app.use(function(req,res,next){
    var filePath = path.join(__dirname,"static",req.url);
    fs.stat(filePath, function(err, fileInfo){
        if (err){
            next();
            return;
        }

        if (fileInfo.isFile()){
            res.sendFile(filePath);
        } else {
            next();
        }
    });
});

app.use(function(req,res){
    res.status(404);
    res.send("File not found!");
});

app.listen(3000,function(){
    console.log("App started on port 3000");
});

