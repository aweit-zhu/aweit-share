import { useState } from 'react';
import {sculptureList} from './data.js';


export default function Post() {

    const [index, setIndex] = useState(0);
    
    let sculpture = sculptureList[index];

    function add() {
        setIndex(index+ 1);
    }

    function minus() {
        setIndex(index - 1);
    }

    return (
        <div className='w-1/3 p-2 shadow overflow-y-auto h-96'>
           <div className='flex flex-col items-center mx-2 relative'>
                <img src={sculpture.url} alt={sculpture.name} className=" w-1/4"/>
                <p className=' text-lg font-bold'>{sculpture.name}</p>
                <p>{sculpture.description}</p>
                <p className='absolute left-2'>({ index + 1 }/{sculptureList.length})</p>
                <button 
                    className={` w-8 absolute right-2 text-lg border-2 border-green-500 px-2 rounded ${index == sculptureList.length -1 ? 'opacity-50 cursor-not-allowed' : ''}`} 
                    onClick={add} 
                    disabled={index == sculptureList.length -1}>+</button>
                <button 
                    className={` w-8 absolute right-12 text-lg border-2 border-red-500 px-2 rounded ${index ==  0 ? 'opacity-50 cursor-not-allowed' : ''}`} 
                    onClick={minus} 
                    disabled={index == 0}>-</button>
           </div>
        </div>
    )
}