var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/websocket/cdaq');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/marketSummry', function (marketSummry) {
            // console.log("marketSummry",marketSummry);
            console.log("marketSummry",JSON.parse(marketSummry.body));
            showGreeting(JSON.parse(marketSummry.body));
        });
        stompClient.subscribe('/topic/test', function (msg) {
            console.log("msg",msg);
            showGreeting(JSON.parse(msg.body).name);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}


function sendName() {
    stompClient.send("/cdaq/marketSummry", {}, JSON.stringify([{}]));
    // stompClient.send("/cdaq/marketSummry", {}, JSON.stringify([{'marketName': $("#name").val()}]));
}
function sendName2() {
    stompClient.send("/cdaq/test", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    $( "#send2" ).click(function() { sendName2(); });
});