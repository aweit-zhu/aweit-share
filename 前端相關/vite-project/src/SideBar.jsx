import { useState } from "react"
import { menuList } from "./data.js";

export default function SideBar() {

    let sessionClose = (sessionStorage.getItem('side-bar-close')?.toLocaleLowerCase?.() === 'true'); // 從 session storage 去取出他是要打開還是關閉。

    const [close, setClose] = useState(sessionClose);

    function handleClose() {
        sessionStorage.setItem('side-bar-close', String(!close));
        setClose(!close);
    }

    return (
        <div className={` border-l-2 absolute right-0 h-lvh shadow z-50 p-2 bg-white ${close ? 'w-8 transition-all duration-300': 'w-1/5 transition-all duration-300'}`}>
            <button className={`absolute rounded border-2 border-green-500 w-8 ${close ? 'right-0': 'right-2'}`} onClick={handleClose} data-close={close} >
                { close ? '☰' : 'X'}
            </button>
            <hr className={`border-2 border-green-700 absolute top-12 w-full left-0 ${close ? 'hidden' : ''}`}></hr>
            <ul className="mt-14 mx-0">
                {
                    menuList.map(item => (
                        <li key={item.id} className="my-2 hover:bg-green-400 cursor-pointer"><a href={item.href}>{item.name}</a></li>
                    ))
                }
            </ul>
        </div>
    )
}