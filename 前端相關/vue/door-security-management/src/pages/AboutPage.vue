<script setup>
import { ref } from 'vue'

// 给每个 todo 对象一个唯一的 id
let id = 0

const newTodo = ref('')
const todos = ref([
    { id: id++, text: 'Learn HTML' },
    { id: id++, text: 'Learn JavaScript' },
    { id: id++, text: 'Learn Vue' }
])

function addTodo() {
    todos.value.push( { id: id++, text: newTodo.value });
    newTodo.value = ''
}

function removeTodo(todo) {
    todos.value = todos.value.filter((t) => t !== todo);
}
</script>

<template>

<div class="mx-auto mt-5 w-50">
    <form @submit.prevent="addTodo">
        <input v-model="newTodo">
        <button>Add Todo</button>
    </form>
    <ul>
        <li v-for="todo in todos" :key="todo.id">
           {{ todo.id }}, {{ todo.text }}
            <button @click="removeTodo(todo)">X</button>
        </li>
    </ul>
</div>

</template>