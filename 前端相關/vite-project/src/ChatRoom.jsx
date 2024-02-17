import { useEffect, useState } from "react";
import PropTypes from 'prop-types';

ChatRoom.propTypes = {
    roomId: PropTypes.string
}

/**
 * 
 * @param {object} param0 
 * @param {string} param0.roomId
 * @returns 
 */
export default function ChatRoom({ roomId }) {

    useEffect(() => {
        const connection = createConnection();
        connection.connect();
        return () => connection.disconnect();
    }, []);

    return <h1>欢迎來到 {roomId} 聊天！</h1>
}

export function ChatRoomApp(){
    const [roomId, setRoomId] = useState('general');
    return (
        <>
            <div className="w-1/3 p-2 shadow overflow-y-auto h-96">
                <label>
                    选择聊天室：{' '}
                    <select
                        value={roomId}
                        onChange={e => setRoomId(e.target.value)}
                    >
                    <option value="general">所有</option>
                    <option value="travel">旅游</option>
                    <option value="music">音乐</option>
                    </select>
                </label>
                <hr />
                <ChatRoom roomId={roomId} />
            </div>
        </>
    )
}

export function createConnection() {
    return {
        connect() {
            console.log('✅ 连接中...');
        },
        disconnect() {
            console.log('❌ 断开连接。');
        }
    }
}