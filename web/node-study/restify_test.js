var restify = require('restify');
var Mock = require('mockjs');

function respond(req, res, next){
    res.send(Mock.Random.word() + " " + req.params.name);
    next();
}

var server = restify.createServer();
server.get('/hello/:name', respond);
server.head('/hello/:name', respond);

server.listen(8080, function(){
    console.log(`${server.name} listening at ${server.url}`);
});
