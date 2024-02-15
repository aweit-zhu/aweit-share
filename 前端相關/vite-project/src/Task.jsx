import { useReducer, useState } from "react";
import './types.js';
import { useUser } from "./provider/UserProvider.jsx";

export default function Task() {

    const user = useUser();

    const [tasks, dispatch] = useReducer(tasksReducer,initialTasks);

    const [text,seText] = useState('');

    function handleAddTask() {
        dispatch({
            type: 'added',
            id: nextId++,
            text: text
        })
    }

    function handleTeleteTask(taskId) {
        dispatch({
            type: 'deleted',
            id: taskId
        })
    }

    return (
        <>
            <div className="w-1/3 p-2 shadow overflow-y-auto h-96">
                登入者：{user.username}
                <input type="text" className="input" onChange={e => seText(e.target.value)}/>
                <button className="btn-success disabled:bg-gray-500" onClick={handleAddTask} disabled={text == ''}>添加</button>
                <ul className="list-decimal list-inside">
                    {
                        tasks.map(task => {
                            return (
                                <li key={task.id}>
                                    {task.text} 
                                    <button className="border-2 border-green-500 px-2 rounded-full" onClick={()=>handleTeleteTask(task.id)}>-</button>
                                </li>
                            )
                        })
                    }
                </ul>
            </div>
        </>
    )
}

let nextId = 3;

const initialTasks = [
    { id: 0, text: '参观卡夫卡博物馆', done: true },
    { id: 1, text: '看木偶戏', done: false },
    { id: 2, text: '列侬墙图片', done: false }
];

/**
 * 
 * @param {Array<Task>} tasks 
 * @param {TaskAction} action 
 * @returns {Array<Task>}
 */
function tasksReducer(tasks, action) {
    switch (action.type) {
        case 'added': {

            if(action.text == '') throw Error('請輸入任務內容');

            return [...tasks, {
                id: action.id,
                text: action.text,
                done: false
            }];
        }
        case 'deleted': {
            return [...tasks].filter(task => task.id!= action.id)
        }
        default: {
            throw Error('未知操作：' + action.type);
        }
    }
}