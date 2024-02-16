
import PropTypes from 'prop-types';
import { useEffect, useRef, useState } from 'react';

VideoPlayer.propTypes = {
    src: PropTypes.string,
    isPlaying: PropTypes.bool
}

/**
 * 
 * @param {object} param 
 * @param { string } param.src
 * @param { boolean } param.isPlaying
 * @returns 
 */
export default function VideoPlayer({src,isPlaying}) {
    
    const ref = useRef(null);

    useEffect(() => {
        
        if(isPlaying) {
            ref.current.play();
        } else {
            ref.current.pause();
        }
        
    }, [isPlaying]);
    
    return <video ref={ref} src={src} loop playsInline />;
}

export function VideoPlayerApp() {

    const [isPlaying, setIsPlaying] = useState(false);

    return (
        <>
            <div className='w-1/3 p-2 shadow overflow-y-auto h-96'>
               <div className='flex flex-col'>
                    <button onClick={()=> setIsPlaying(!isPlaying)} className='btn-primary p-2'>
                        {isPlaying ? '暫停': '播放'}
                    </button>
                    <div>
                        <VideoPlayer src={'https://interactive-examples.mdn.mozilla.net/media/cc0-videos/flower.mp4'} isPlaying={isPlaying} />
                    </div>
               </div>
            </div>
        </>
    )
}