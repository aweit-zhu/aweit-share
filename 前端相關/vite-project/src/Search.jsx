
import { useState } from "react";
import { people } from "./data.js";
import { getImageUrl } from './util.js';

export default function Search() {

    const [listItems, setListItems] = useState(people);

    function onSearchChange(event) {
        let word = String(event.target.value)?.toLocaleLowerCase();
        setListItems(people.filter(person => person.name.toLocaleLowerCase().indexOf(word)>=0));
    }
    
    return (
        <>
            <div className=" w-1/3 p-2 shadow overflow-y-auto h-96">
                <input type="text" onChange={onSearchChange} className="input" placeholder="輸入查詢關鍵字"></input>
                <ul className=" list-image-none ">
                    {
                        listItems.map( person => (
                            <li key={person.id}>
                                <img src={getImageUrl(20,20)} alt={person.name} className=' mx-2 inline-block'/>    
                                {person.name} 
                            </li>
                        ))
                    }
                </ul>
            </div>
        </>
    );
}