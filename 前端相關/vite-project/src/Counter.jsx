import React from "react";
import { useImmer } from 'use-immer';

export function Counter() {

    const [number,setNumber] = useImmer(0);

    return (
        <>
            <h1>{number}</h1>
            <button onClick={()=> {
               setNumber(number + 5);
               setNumber(n => n + 1);
            }} className="btn-primary w-14">+6</button>
        
        </>
    );
}

export default function CounterApp() {
    return (
        <div className='w-1/3 p-2 shadow overflow-y-auto h-96'>
           <Counter />
        </div>
    );
}