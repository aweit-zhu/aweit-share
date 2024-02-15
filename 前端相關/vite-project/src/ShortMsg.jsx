import PropTypes from 'prop-types';
import { useState } from 'react';
import './types.js';

export default function ShortMsg() {

    const [contact, setContact] = useState({
        name:'', email: ''
    });

    function onselect(c) {
        setContact(c);
    }

    return (
        <>
             <div className="w-1/3 p-2 shadow overflow-y-auto h-96">
                <div className='flex h-full'>
                    <div className=' flex-1 m-1'>
                        <ContactList onselect={onselect} contacts={contacts}/>
                    </div>
                    <div className=' w-full m-1'>
                        <Chat key={contact.email} contact={contact}/>
                    </div>
                </div>
             </div>
        </>
    )
}


/** @type {Contact[]} */
const contacts = [
    { name: 'Taylor', email: 'taylor@mail.com' },
    { name: 'Alice', email: 'alice@mail.com' },
    { name: 'Bob', email: 'bob@mail.com' }
];

ContactList.propTypes = {
    contacts: PropTypes.array,
    onselect: PropTypes.func
};

/**
 * @param {object} param
 * @param {Array<Contact>} param.contacts
 * @param {Function} param.onselect
 * @returns 
 */
export function ContactList({
    contacts,
    onselect
}) {

    return (
        <>
            {
                contacts.map(c => {
                    return (<button key={c.email} className='btn-success my-2' onClick={()=> onselect(c)} >{c.name}</button>)
                })
            }
        </>
    )
}

Chat.propTypes = {
    contact: PropTypes.shape({
        name: PropTypes.string,
        email: PropTypes.string
    })
};
export function Chat({
    contact
}) {
    const [text, setText] = useState('');
    return (
      <section className="w-full border-2">
        <textarea
          value={text}
          placeholder={'Chat to ' + contact.name}
          onChange={e => setText(e.target.value)}
          className=' border-2 border-green-500 m-1 w-2/3'
        />
        <br />
        <button className='btn-primary'>发送给 {contact.email}</button>
      </section>
    );
}