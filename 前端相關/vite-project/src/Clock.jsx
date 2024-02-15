
import PropTypes from 'prop-types';
import { useEffect, useState } from 'react';

export function Clock({time}) {
    return (
        <>
            <h1>{time}</h1>
            <input type="text" className='input'/>
        </>
    )
}

Clock.propTypes = {
    time: PropTypes.string
}

function useTime() {
    const [time, setTime] = useState(() => new Date());
    useEffect(() => {
      const id = setInterval(() => {
        setTime(new Date());
      }, 1000);
      return () => clearInterval(id);
    }, []);
    return time;
}

export default function ClockApp() {
    const time = useTime();
    return (
        <div className='w-1/3 p-2 shadow overflow-y-auto h-96'>
            <Clock time={time.toLocaleTimeString()} />
        </div>
    );
}