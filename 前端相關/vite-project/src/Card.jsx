import { getImageUrl } from "./util.js";
import PropTypes from 'prop-types';

/**
 * 
 * @param {string} name 
 */
export function Person(name) {
    this.name = name;
}

export default function Card() {

    const person = new Person('aweit');
    return (
        <div className=" w-1/3 p-2 shadow mx-auto mt-2">
            <Avatar size={50} person={person}/>
        </div>
    );
}

/**
 * @param {Object} props
 * @param {number} props.size
 * @param {Person} props.person
 */
export function Avatar({ size, person }) {
    return (
        <img src={getImageUrl(size, size)} className="rounded-full" alt={person.name} />
    );
}

Avatar.propTypes = {
    size: PropTypes.number,
    person: PropTypes.objectOf(PropTypes.string),
};

Avatar.defaultProps = {
    size: 50
};
