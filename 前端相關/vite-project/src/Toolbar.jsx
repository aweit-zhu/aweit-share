

import PropTypes from 'prop-types';

Toolbar.propTypes = {
    onPlayMovie: PropTypes.func,
    onUploadImage: PropTypes.func
}

/**
 * 
 * @param {object} props 
 * @param {import('react').MouseEventHandler<HTMLButtonElement>} props.onPlayMovie
 * @param {import('react').MouseEventHandler<HTMLButtonElement>} props.onUploadImage
 * @returns
 */
export default function Toolbar({ onPlayMovie, onUploadImage }) {

    return (
        <>
            <div className="w-1/3 p-2 shadow overflow-y-auto h-96" onClick={() => {
                alert('你点击了 toolbar ！');
            }}>
                <div className='flex p-2'>
                    <Button name='Play Movie' handleClick={onPlayMovie}></Button>
                    <Button name='Upload Image' handleClick={onUploadImage}></Button>
                </div>
            </div>
        </>
    )

}


/**
 * 
 * @param {object} props 
 * @param {string} props.name
 * @param {import('react').MouseEventHandler<HTMLButtonElement>} props.handleClick
 * @returns 
 */
export function Button({name,handleClick}) {
    return <button className='btn-success' onClick={e => {
        e.stopPropagation();
        handleClick(e);
    }}>{name}</button>;
}

Button.propTypes = {
    name: PropTypes.string,
    handleClick: PropTypes.func
}