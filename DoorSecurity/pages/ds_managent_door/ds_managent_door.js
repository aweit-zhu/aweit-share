
function renderDoor(door,index) {
    $('#door_list').append(
    ` 
        <div class="border door flex-shrink-0">
            <aweit-ds-door type="door" door_id="${door.id}" door_name="${door.name}" door_pic="${door.pic}" door_desc="${door.desc}"></aweit-ds-door>
        </div>
    `);
}

function registerDoorTap(door,index) {
    door.registerClickHandler(() => tap(door));
}

function tap(door) {
    let door_id = door.getAttribute('door_id');
    let door_name = door.getAttribute('door_name');
    let door_pic = door.getAttribute('door_pic');
    let door_desc = door.getAttribute('door_desc');
    $('#door_info').removeClass('d-none');
    $('#door_info .door_id').html(`${door_id}(${door_name})`);
    $('#door_info .door_pic').attr('src',door_pic);
    $('#door_info .door_desc').html(`${door_desc}`);
}

function allowDrop(event) {
    event.preventDefault();
}

function drag(event) {
    event.dataTransfer.setData('employee_name', event.target.innerText);
    event.dataTransfer.setData('employee_id', event.target.id);
}

function drop(event) {
    event.preventDefault();
    var employee_name = event.dataTransfer.getData('employee_name');
    var employee_id = event.dataTransfer.getData('employee_id');
    var targetId = event.target.id;
    var sourceId = (targetId == 'right') ? 'left': 'right';
    var employee = document.getElementById(employee_id);
    //console.log(`${employee_name} (${employee_id}) 從 ${sourceId} 到 ${targetId}`);
    document.getElementById(sourceId).removeChild(employee);
    document.getElementById(targetId).appendChild(employee);
}