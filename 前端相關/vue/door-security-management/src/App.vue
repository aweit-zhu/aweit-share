
<script setup>

import { ref } from 'vue';

const webName = ref('門禁管理系統');

</script>

<template>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark vw-100">
        <div class="container-fluid">
            <i class="bi  bi-buildings-fill h5 my-0 text-light me-2"></i>
            <a class="navbar-brand text-light" href="/#">{{ webName }}</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <router-link to="/home" class="custom-link mx-2">Home</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/about" class="custom-link mx-2">About</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/mgtByEmploye" class="custom-link mx-2">權限管理(by員工)</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/mgtByDoor" class="custom-link mx-2">權限管理(by門點)</router-link>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
                    <li class="nav-item"><i class="bi bi-person-circle d-none d-lg-block h5 my-0 text-light me-3" role="button">admin</i></li>
                    <i class="bi bi-box-arrow-right text-light ml-3" role="button" onclick="window.location.href='/login.html'">Logout</i>
                </ul>
            </div>
        </div>
    </nav>
    <div style="padding-top:3.5rem">
        <router-view></router-view>
    </div>

</template>

<style scoped>
.custom-link {
    color: #fff;
    text-decoration: none;
    /* font-weight: bold; */
}

.custom-link:hover {
    color: #2980b9;
}
</style>