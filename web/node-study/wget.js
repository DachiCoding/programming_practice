var http = require('http');
var url = require('url');
var util = require('util');

var argUrl = process.argv[2];
var parsedUrl = url.parse(argUrl, true);

var options = {
    host: parsedUrl.hostname,
    port: parsedUrl.port,
    path: parsedUrl.pathname,
    method: 'GET'
};

if (parsedUrl.search) options.path += "?" + parsedUrl.search;

var req = http.request(options);

req.on('response', res => {
    util.log('STATUS: ' + res.statusCode);
    util.log('HEADERS: ' + util.inspect(res.headers));
    res.setEncoding('utf8');
    res.on('data', chunk => { util.log('BODY: ' + chunk); });
    res.on('error', err => { util.log('RESPONSE ERROR: ' + err); });
});

req.on('error', err => { util.log('REQUEST ERROR: ' + err); });
req.end();
