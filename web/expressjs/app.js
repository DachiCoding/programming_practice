const express = require("express");
const morgan = require("morgan");
const path = require("path");
const fs = require("fs");
const app = express();

app.use(morgan("short"));

const staticPath = path.join(__dirname,"static");
app.use(express.static(staticPath));

app.use(function(req,res,next){
    console.log("Request ID: " + req.url);
    console.log("Request date: " + new Date());
    next();
});

app.get("/olivia", function(req,res){
    res.send("Welcome to Olivia's homepage!");
});

app.use(function(req,res){
    res.status(404);
    res.send("File not found!");
});

app.listen(3000,function(){
    console.log("App started on port 3000");
});

