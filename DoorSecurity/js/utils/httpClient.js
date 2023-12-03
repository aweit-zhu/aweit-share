import { Door } from '../models/door.js';
import { Employee } from '../models/employee.js';

export class HttpClient {

    getAllDoors() {
        var doorList = [];
        $.ajax({
            async: false,
            url: './api/ds_doors.json',
            dataType: 'json',
            success: function (doors) {
                doorList = doors.map(
                    door => new Door(door.door_id, door.door_name, door.door_pic, door.door_desc)
                );
                //console.log(doorList);
            }
        });
        return doorList;
    }

    getEmployeesByDoorId(doorId) {
        
        var map = new Map();
        map.set('door_id',doorId);
        $.ajax({
            async: false,
            url: './api/ds_doors_employees.json',
            dataType: 'json',
            success: function (data) {
                var hadAccessList = data.filter(door => door.door_id == doorId )
                              .map(door => door.had_access)[0]
                              .map(employee => new Employee(employee.employee_id,employee.employee_name));

                var noAccessList = data.filter(door => door.door_id == doorId )
                              .map(door => door.no_access)[0]
                              .map(employee => new Employee(employee.employee_id,employee.employee_name));

                map.set('had_access_list', hadAccessList);
                map.set('no_access_list', noAccessList);
            }
        });

        return map;
    }

}

//=> new Employee(employee.employee_id,employee.employee_name)