//import modules
var http = require('http');
var util = require('util');
var url = require('url');
var os = require('os');

//create server
var server = http.createServer();

//config server to handle req
server.on('request',(req,res) => {
    //parseUrl
    var requrl = url.parse(req.url,true);

    //index
    if (requrl.pathname === '/'){
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.end(
            `<html><head><title>Hello, world!</title></head>
            <body><h1>Hello, world!</h1><p><a href='/osinfo'>OS Info</a></p></body></html>`
        );

    //osinfo page
    } else if (requrl.pathname === "/osinfo"){
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.end(
            `<html><head><title>Operating System Info</title></head>
            <body><h1>Operating System Info</h1>
            <table>
            <tr><th>TMP Dir</th><td>${os.tmpDir()}</td></tr>
            <tr><th>Host Name</th><td>${os.hostname()}</td></tr>
            <tr><th>OS Type</th><td>${os.type()} ${os.platform()} ${os.arch()} ${os.release()}</td></tr>
            <tr><th>Uptime</th><td>${os.uptime()} ${util.inspect(os.loadavg())}</td></tr>
            <tr><th>Memory</th><td>total: ${os.totalmem()} free: ${os.freemem()}</td></tr>
            <tr><th>CPU's</th><td><pre>${util.inspect(os.cpus())}</pre></td></tr>
            <tr><th>Network</th><td><pre>${util.inspect(os.networkInterfaces())}</pre></td></tr>
            </table>
            </body></html>`
        );
    
    //other url req
    } else {
        res.writeHead(404,{'Content-Type': 'text/plain'});
        res.end("bad URL " + req.url);
    }
});

//set server port
require('./httpsniffer').sniffOn(server);
server.listen(8124, '127.0.0.1');
console.log('Server running at http://127.0.0.1:8124');
