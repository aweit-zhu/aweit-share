
import { HttpClient } from '/js/utils/httpClient.js';

const httpClient = new HttpClient();

var hadAccessList = [];
var noAccessList = [];

init();

function init() {

    var doorList = httpClient.getAllDoors();
        
    doorList.forEach(renderDoor);
    
    document.querySelectorAll('aweit-ds-door').forEach(registerDoorTap);
    
    tap(document.querySelectorAll('aweit-ds-door')[0]);  
}

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
    let employees = httpClient.getEmployeesByDoorId(door_id);
    
    hadAccessList = employees.get('had_access_list');
    noAccessList = employees.get('no_access_list');
    
    // console.log(employees);
    // console.log(hadAccessList);
    // console.log(noAccessList);

    renderDoorEmployees(door, hadAccessList,noAccessList);
}

function renderDoorEmployees(door,hadAccessList,noAccessList) {
    
    // 左圖區塊
    let door_id = door.getAttribute('door_id');
    let door_name = door.getAttribute('door_name');
    let door_pic = door.getAttribute('door_pic');
    let door_desc = door.getAttribute('door_desc');
    $('#door_info').removeClass('d-none');
    $('#door_info .door_id').html(`${door_id}(${door_name})`);
    $('#door_info .door_pic').attr('src',door_pic);
    $('#door_info .door_desc').html(`${door_desc}`);

    // 右圖
    $('#left p').remove();
    $('#right p').remove();

    hadAccessList.forEach(
        employee => {
            $('#left').append(
                `
                <p id="${employee.id}" class="border border-2 border-primary rounded-pill shadow p-1 m-1" 
                                         role="button" draggable="true" ondragstart="drag(event)">
                                <i class="bi bi-person"></i>${employee.name}</p>
                `
            );
        }
    );
    noAccessList.forEach(
        employee => {
            $('#right').append(
                `
                <p id="${employee.id}" class="border border-2 border-danger rounded-pill shadow p-1 m-1" 
                                         role="button" draggable="true" ondragstart="drag(event)">
                                <i class="bi bi-person"></i>${employee.name}</p>
                `
            );
        }
    );
}


function submit() {
    alert(123);
}

function reset(){
    alert(456);
}