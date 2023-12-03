<template>
    <div class="d-flex justify-content-between align-items-center mt-3 mb-2 mx-3">
        <h3 class="text-center fw-bolder"><i class="bi bi-person"></i> weizhi.zhu (57169)</h3>
        <button class="btn btn-primary mx-3" onclick="console.log(updateList)">Save</button>
    </div>

    <div class="d-flex justify-content-center align-items-center">
        <div>
            <p class="text-center h3 fw-bolder">A棟</p>
            <div class="d-flex justify-content-start align-items-center flex-wrap" width="500px;">
                <div class="m-2 border door"><aweit-ds-door type="employee" status=0 door_id="A001"
                        door_name="總經理室"></aweit-ds-door></div>
                <div class="m-2 border door"><aweit-ds-door type="employee" status=0 door_id="A002"
                        door_name="健身房"></aweit-ds-door></div>
                <div class="m-2 border door"><aweit-ds-door type="employee" status=1 door_id="A003"
                        door_name="餐廳區"></aweit-ds-door></div>
                <div class="m-2 border door"><aweit-ds-door type="employee" status=1 door_id="A004"
                        door_name="按摩區"></aweit-ds-door></div>
                <div class="m-2 border door"><aweit-ds-door type="employee" status=1 door_id="A005"
                        door_name="諮商室"></aweit-ds-door></div>
            </div>
        </div>
        <div>
            <p class="text-center h3 fw-bolder">B棟</p>
            <div class="d-flex justify-content-start align-items-center flex-wrap" width="500px;">
                <div class="m-2 border door"><aweit-ds-door type="employee" status=0 door_id="B001"
                        door_name="實驗室B"></aweit-ds-door></div>
                <div class="m-2 border door"><aweit-ds-door type="employee" status=1 door_id="B002"
                        door_name="收發室"></aweit-ds-door></div>
                <div class="m-2 border door"><aweit-ds-door type="employee" status=1 door_id="B003"
                        door_name="實驗室A"></aweit-ds-door></div>
                <div class="m-2 border door"><aweit-ds-door type="employee" status=1 door_id="B004"
                        door_name="實驗室C"></aweit-ds-door></div>
                <div class="m-2 border door"><aweit-ds-door type="employee" status=0 door_id="B005"
                        door_name="實驗室D"></aweit-ds-door></div>
            </div>
        </div>
    </div>
</template>

<script setup>

    import { onMounted } from 'vue';
    
    onMounted(() => {
        document.querySelectorAll('aweit-ds-door').forEach(register);
    });

    function register(door) {
        door.registerClickHandler(() => tap(door));
    }

    var updateList = new Map();

    function tap(door) {
        let door_id = door.getAttribute('door_id');
        let status = door.getAttribute('status');
        status = status == 1 ? 0 : 1;
        updateList.set(door_id, status);
        door.setAttribute('status', status);
    }

</script>
<style scoped>
.door {
    background-color: #f5f5f5;
    border-radius: 10px;
}

.door:hover {
    border: 2px solid rgba(90, 123, 20, 0.977) !important;
    box-shadow: 0 .5rem 1rem rgba(0, 0, 0, .15) !important;
}</style>