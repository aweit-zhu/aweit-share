import { Door } from '../models/door.js';

export class HttpClient {

    getAllDoors() {
        var doorList = [];
        $.ajax({
            async: false,
            url: './api/ds_door.json',
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

}