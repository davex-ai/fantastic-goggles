import React, { createContext, useEffect, useState } from 'react'

export const UserContext = createContext()

function fetchUser(){
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({ id: 1, name: "Adam"})
        }, 5000)
    })
}
function UserProvider({children}) {
 
const [user, setUser] = useState({name: "..."})

    useEffect(() => {
    fetchUser().then((user) => {
        setUser(user)
    })
    }, [])
  return (
    <div>     
    <UserContext.Provider value={user}>{children}</UserContext.Provider>
    </div>
  )
}

export default UserProvider
