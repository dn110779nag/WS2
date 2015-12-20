<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="resources/sockjs.js"></script>
        <script src="resources/stomp.js"></script>
        <script>
            var socket = new SockJS("/WS2/endpoint");
            var stompClient = Stomp.over(socket);
            
            stompClient.connect({}, function (frame) {
                console.log('!!!Connected ' + frame);
                
                stompClient.subscribe("/app/msg", function (message) {
                    console.log(JSON.parse(message.body));
                });
//                
//                stompClient.subscribe("/topic/inf", function (message) {
//                    console.log(message.body);
//                });
//                
//                stompClient.subscribe("/queue/errors", function (message) {
//                    console.log(JSON.parse(message.body));
//                });
            }, function (error) {
                console.log("STOMP protocol error " + error);
            });
            
            function test(){
                console.log("sid: "+socket.sessionId);
                stompClient.send("/app/test", {}, JSON.stringify({data:'test', interval: 100}));
            }
        </script>
    </head>
    <body>
        <h1>Hello World from Spring!</h1>
        <input type="button" onclick="test()" value="test"/>
    </body>
</html>
