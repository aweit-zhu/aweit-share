import { useState } from "react";
import { useUser, useUserDispatcher } from "./provider/UserProvider";

export default function Login() {

    const user = useUser();

    const userDispatcher = useUserDispatcher();

    const [text,setText] = useState();

    function handleUserChange(event) {
        setText(event.target.value);
    }

    function handleChangeUsername() {
        userDispatcher({
            type: 'change',
            username: text,
            id: user.id
        });
    }

    return (
        <>
            <div className="w-1/3 p-2 shadow overflow-y-auto h-96">
                {user.username}
                <input className="input" placeholder="username" onChange={handleUserChange}></input>
                <button className="btn-primary" onClick={handleChangeUsername}>切換帳號</button>
            </div>
        </>
    )

}