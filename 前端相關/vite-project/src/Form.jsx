import { useImmer } from 'use-immer';
import PropTypes from 'prop-types';

const initialList = [
    { id: 0, title: 'Big Bellies', seen: false },
    { id: 1, title: 'Lunar Landscape', seen: false },
    { id: 2, title: 'Terracotta Army', seen: true },
];

export default function Form() {

    const [list, updateList] = useImmer(initialList);

    const [person, updatePerson] = useImmer({
        name: 'Niki de Saint Phalle',
        artwork: {
          title: 'Blue Nana',
          city: 'Hamburg',
          image: 'https://i.imgur.com/Sd1AgUOm.jpg',
        }
    });

    function handleChangeName(event) {
        updatePerson(draft=> {
            draft.name = event.target.value;
        });
    }

    function handleChangeCity(event) {
        updatePerson(draft=> {
            draft.artwork.city = event.target.value;
        });
    }

    function handleChangeTitle(event) {
        updatePerson(draft=> {
            draft.artwork.title = event.target.value;
        });
    }

    function submit() {
        console.log(person,list);
    }

    function handleToggle(artworkId, nextSeen) {
        updateList(draft => {
          const artwork = draft.find(a =>
            a.id === artworkId
          );
          artwork.seen = nextSeen;
        });
    }

    return (
        <div className='w-1/3 p-2 shadow overflow-y-auto h-96'>
            <div className='flex flex-col'>
                <div className='flex'>
                    <div className='w-20 text-end self-center mr-2'>Name: </div>
                    <input type="text" className='input' placeholder='名稱' value={person.name} onChange={handleChangeName} />
                </div>
                <div className='flex'>
                    <div className='w-20 text-end self-center mr-2'>Title: </div>
                    <input type="text" className='input' placeholder='標題' value={person.artwork.title} onChange={handleChangeTitle}/>
                </div>
                <div className='flex'>
                    <div className='w-20 text-end self-center mr-2'>City: </div>
                    <input type="text" className='input' placeholder='城市' value={person.artwork.city} onChange={handleChangeCity}/>
                </div>
                <div className='flex'>
                    <button className='btn-primary' onClick={submit}>提交</button>
                </div>
            </div>
            <hr className='border-2 border-green-500 w-full my-3'></hr>
            <div className='flex mt-2'>
                <img src={person.artwork.image} alt={person.name} className=' rounded-full mx-2 w-16'/>
                <div className='flex flex-col'>
                    <p className=' font-bold'>Name: {person.name}</p>
                    <p>Title: {person.artwork.title}</p>
                    <p>City: {person.artwork.city}</p>
                </div>
            </div>
            <hr className='border-2 border-green-500 w-full my-3'></hr>
            <ItemList artworks={list} onToggle={handleToggle} />
        </div>
    )
}

ItemList.propTypes = {
    artworks: PropTypes.array,
    onToggle: PropTypes.func
}

function ItemList({ artworks, onToggle }) {
    return (
      <ul>
        {artworks.map(artwork => (
          <li key={artwork.id}>
            <label>
              <input
                type="checkbox"
                checked={artwork.seen}
                onChange={e => {
                  onToggle(
                    artwork.id,
                    e.target.checked
                  );
                }}
              />
              {artwork.title}
            </label>
          </li>
        ))}
      </ul>
    );
  }