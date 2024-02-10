import PropTypes from 'prop-types';

export default function PackingList() {
    return (
        <div className=" w-1/3 p-2 shadow mx-auto mt-2">
            <h1 className=' text-lg my-2'>{`Sally Ride's Packing List`}</h1>
            <ul>
                <Item  isPacked={true}  name="Space suit1"/>
                <Item  isPacked={false} name="Space suit2"/>
                <Item  isPacked={true}  name="Space suit3"/>
            </ul>
        </div>
    );
}

Item.propTypes = {
    name: PropTypes.string,
    isPacked: PropTypes.bool
}

/**
 * 
 * @param {object} props
 * @param {string} props.name
 * @param {boolean} props.isPacked 
 */
export function Item({name,isPacked}){
    return (
        <li className='ms-4 list-disc'>{name} {isPacked? '✔': ''}</li>
    )
}


