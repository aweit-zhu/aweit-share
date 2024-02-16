import { useReducer, useState } from 'react';
//import { useImmer } from 'use-immer';
import './types.js';

export function Counter() {

    //const [number,setNumber] = useImmer(0);

    const [number, dispatch] = useReducer(counterReducer,0);

    return (
        <>
            <div className='flex flex-col justify-center items-center px-4 py-2 border-2 border-black my-1 w-32 mx-1'>
                <h1 className='mb-5'>{number}</h1>
                <div className='flex'>
                    <button onClick={()=> {dispatch({type: 'add',num: 1})}} className=" border-2 border-black px-1 mx-1 w-8 hover:bg-blue-400">+1</button>
                    <button onClick={()=> {dispatch({type: 'subtract',num: 1})}} className=" border-2 border-black px-1 mx-1 w-8 hover:bg-red-400">-1</button>
                </div>
            </div>
        </>
    );
}

export default function CounterApp() {

    const [showB, setShowB] = useState(true);

    return (
        <div className='w-1/3 p-2 shadow overflow-y-auto h-96'>
            <div className='flex'>
                {/* <Counter />
                {showB && <Counter />}  */}
                {showB ?  <Counter/>:  <Counter/>}
                {showB ?  <Counter key={1}/>:  <Counter key={2}/>}
            </div>
            <label>
                <input
                    type="checkbox"
                    checked={showB}
                    onChange={e => {
                        setShowB(e.target.checked)
                    }}
                />
                渲染第二个计数器
            </label>
        </div>
    );
}

/**
 * 
 * @param {number} count 
 * @param {CounterAction} action 
 * @returns {number}
 */
export function counterReducer(count, action) {

    if(action.type == 'add') {
        count = count + action.num;
    }

    if(action.type == 'subtract') {
        count = count - action.num;
    }

    return count;
}