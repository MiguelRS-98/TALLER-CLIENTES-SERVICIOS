let points = 0, fames = 0;
let historyAttempts = "", historyPredictions = "", historyPoints = "", historyFames = "";
let contHistory = 0;

let numberRandom = setNumber();

function setNumber () 
{
    let number1 = Math.floor(Math.random()*9) + "";
    let number2 = Math.floor(Math.random()*9) + "";
    let number3 = Math.floor(Math.random()*9) + "";
    let number4 = Math.floor(Math.random()*9) + "";
    return number1 + number2 + number3 + number4;
}

function getNumberUser ()
{
    let numberUser = document.getElementsByName("number")[0].value;
    contHistory +=1;
    let numberUser1 = numberUser[0] + "";
    let numberUser2 = numberUser[1] + "";
    let numberUser3 = numberUser[2] + "";
    let numberUser4 = numberUser[3] + "";
    numberUser = numberUser1 + numberUser2 + numberUser3 + numberUser4;
    checkInput(numberUser);
}

function checkInput (x) {
    if (x.length < 4) {
        alert('El numero debe contener 4 digitos.');
    } else if (isNaN(x) === true) {
        alert('La entrada deben ser numeros.');
    } else {
        numberEquals(x);
    }
}

function numberEquals (x) 
{
    if (x === numberRandom) {
        document.getElementById('numberUnlock'.toString()).innerHTML = numberRandom;
        alert('Ganaste el numero es: ' + numberRandom);
    } else {
        getPoints(x);
    }
}

function getPoints (x)
{
    points = 0;
    fames = 0;
    for (let i=0; i<4; i++) {
        if (numberRandom.includes(x[i])) {
            if (x[i] === numberRandom[i]) {
                points +=1;
                fames -=1;
            } else {
                if (fames < 0) {
                    fames = 0;
                } else {
                    fames +=1;
                }
            }
        }
    }
    getHistory(x, points, fames)
}

function getHistory (x, y, z)
{
    historyAttempts = 'Intento #' + contHistory + '<br></br>' + historyAttempts;
    historyPredictions = 'Numero ' + x + '<br></br>' + historyPredictions;
    historyPoints = 'Puntos ' + y + '<br></br>' + historyPoints;
    historyFames = 'Famas ' + z + '<br></br>' + historyFames;
    document.getElementById('attempt'.toString()).innerHTML = historyAttempts;
    document.getElementById('prediction'.toString()).innerHTML = historyPredictions;
    document.getElementById('point'.toString()).innerHTML = historyPoints;
    document.getElementById('fame'.toString()).innerHTML = historyFames;
}