//Este código asume que las librerías de P5.js ya están cargadas.
//Esta función se ejecuta una sola vez al inicio del script.
function setup() {
    createCanvas(640, 480);
    background(220, 180, 200);
}
// Esta función se ejecuta repetidas veces indefinidamente.
function draw() {
    
    if (mouseIsPressed === true) {
        fill(0,0,0);
        ellipse(mouseX, mouseY, 7, 7);
    }
    if (mouseIsPressed === false) {
        fill(255,255,255);
    }
}