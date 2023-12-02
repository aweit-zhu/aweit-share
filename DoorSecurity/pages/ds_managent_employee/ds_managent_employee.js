document.querySelectorAll('aweit-ds-door').forEach(register);

function register(door,index) {
    door.registerClickHandler(() => tap(door));
}

var updateList = new Map();

function tap(door) {
    let door_id = door.getAttribute('door_id');
    let status = door.getAttribute('status');
    status = status == 1 ? 0: 1;
    updateList.set(door_id,status);
    door.setAttribute('status', status);
}