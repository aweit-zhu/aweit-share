<template>
    <img src="/src/assets/architecture.jpg" alt="" class="d-block mx-auto w-100 vh-100" style="object-fit: cover;">

    <div class="company_name position-absolute text-light top-50">
        <p>MiMAX</p>
        <div class="m-0 position-absolute top-0 text-light" style="font-size: 16px;">The Best Choice of</div>
    </div>
</template>

<style scoped>
.company_name {
    z-index: 99;
    top: 30% !important;
    font-size: 10em;
    cursor: pointer;
    animation-duration: 2s;
    animation-name: slidein;
    margin-left: 1em;
}

.company_name:hover {
    background: linear-gradient(to top, #3a1c71, #d76d77, #ffaf7b);
    background: -webkit-linear-gradient(to top, #3a1c71, #d76d77, #ffaf7b);
    background-clip: text;
    -webkit-background-clip: text;
    color: transparent !important;
}

@keyframes slidein {
    from {
        margin-left: 100%;
        width: 300%
    }

    to {
        margin-left: 1em;
        width: 100%;
    }
}

</style>