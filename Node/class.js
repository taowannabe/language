const http = require('http');

http.createServer(function(req,res){
  res.write("hello node");
  res.end();
}).listen(2000);
