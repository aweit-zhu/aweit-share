import { useImmer } from 'use-immer';

export default function Form() {

    const [person, updatePerson] = useImmer({
        name: 'Niki de Saint Phalle',
        artwork: {
          title: 'Blue Nana',
          city: 'Hamburg',
          image: 'https://i.imgur.com/Sd1AgUOm.jpg',
        }
    });

    function handleChangeName(event) {
        updatePerson(p=> {
            p.name = event.target.value;
        });
    }

    function handleChangeCity(event) {
        updatePerson(p=> {
            p.artwork.city = event.target.value;
        });
    }

    function handleChangeTitle(event) {
        updatePerson(p=> {
            p.artwork.title = event.target.value;
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
        </div>
    )
}