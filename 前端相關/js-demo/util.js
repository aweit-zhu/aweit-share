function printProtoTypes(object) {
    console.log(object);
    do {
        object = Object.getPrototypeOf(object);
        console.log(object);
    } while (object);
}

function degToRad(degrees) {
    return (degrees * Math.PI) / 180;
}

function rand(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}