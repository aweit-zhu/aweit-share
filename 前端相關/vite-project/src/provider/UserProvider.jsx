import { createContext, useContext, useReducer } from "react";
import PropTypes from 'prop-types';
import '../types.js';

const UserContext = createContext(null);
const UserDispatchContext = createContext(null);

export default function UserProvder({children}) {

    const [user, dispatch] = useReducer(
        userReducer,
        initial
      );

    return (
        <>
            <UserContext.Provider value={user}>
                <UserDispatchContext.Provider value={dispatch}>
                    {children}
                </UserDispatchContext.Provider>
            </UserContext.Provider>
        </>
    )
}

/**
 * 
 * @returns { User }
 */
export function useUser() {
    return useContext(UserContext);
}

/**
 * 
 * @returns {React.Dispatch<UserAction>}
 */
export function useUserDispatcher() {
    return useContext(UserDispatchContext);
}

UserProvder.propTypes = {
    children: PropTypes.node
}

/** @type { User } */
const initial = {
    username: 'aweit',id: 1
};

/**
 * 
 * @param {User} user 
 * @param {UserAction} action
 * @returns {User}
 */
function userReducer(user,action) {

    switch (action.type) {
        case 'change': {
            return {...user, username: action.username, id: action.id}
        }
        default: {
            throw Error('未知操作：' + action.type);
        }
    }
}