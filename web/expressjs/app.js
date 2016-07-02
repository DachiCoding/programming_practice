const express = require("express");
const http = require("http");
const logger = require("morgan");
const path = require("path");
const app = express();

const publicPath = path.resolve(__dirname,"public");
app.use(express.static(publicPath));

app.set("views", path.resolve(__dirname,"views"));
app.set("view engine", "ejs");

/*
app.use(logger("short"));

app.use(function(req,res,next){
    console.log("In comes a request to: " + req.url);
    next();
});

app.use(function(req,res){
    res.writeHead(200, {"Content-Type": "text/plain"});
    res.end("Hello,world!");
});
*/

app.get("/",function(req,res){
    //res.end("Welcome to my homepage!");
    res.render("index",{
        message: "Hey everyone! This is my webpage."
    });
});

app.get("/about", function(req,res){
    res.end("Welcome to the about page!");
});

app.get("/weather",function(req,res){
    res.end("The current weather is NICE.");
});

app.use(function(req,res){
    res.statusCode = 404;
    res.end("404!");
});


http.createServer(app).listen(3000);
