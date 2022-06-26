var stompClient;
var colores = "black";
//Este código asume que las librerías de P5.js ya están cargadas.
//Esta función se ejecuta una sola vez al inicio del script.
function setup() {
    createCanvas(640, 480);
    background(220, 180, 200);
    stomp();
}
// Esta función se ejecuta repetidas veces indefinidamente.
function draw() {
    
    if (mouseIsPressed === true) {
        fill("red");
        stroke("red")
        ellipse(mouseX, mouseY, 7, 7);
        var json = {
            xPos: mouseX,
            yPos: mouseY,
        }
        message(json)
    }
}

function stomp(){
    var socket = new SockJS("/stompEndpoint");
    stompClient = Stomp.over(socket);
    stompClient.connect({},function(frame){
        console.log(frame);
        stompClient.subscribe("/topic/tablero", function(event){
            var json = JSON.parse(event.body);
            ellipse(json.xPos, json.yPos, 7, 7);
        });
    });
}

function message(json){
    stompClient.send("/topic/tablero", {},JSON.stringify(json));
}

function colorSelector() {
    colores = document.getElementById("colour").value;
    console.log(colores);
}