import { people } from './data.js';
import { getImageUrl } from './util.js';

export default function List() {

    const listItems = people.map(person => (
        <li key={person.id} className=' m-2 flex'>
            <img src={getImageUrl(50,50)} alt={person.name} className=' mx-2'/>
            <p>
                <b>{person.name}:</b>
                {' ' + person.profession + ' '}
                known for {person.accomplishment}
            </p>
        </li>
    ));

    return (
        <div className=" w-1/3 p-2 shadow">
            <h1>Scientists</h1>
            <ul>{listItems}</ul>
        </div>
    );
}

