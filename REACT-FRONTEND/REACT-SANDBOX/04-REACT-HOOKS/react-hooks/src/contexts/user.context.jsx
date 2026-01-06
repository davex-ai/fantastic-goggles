import React, { createContext } from 'react'

 //CREATING THE CONTEXTT
 export const UserContext = createContext()

 export const UserProvider = ({ children }) => {
    return <UserContext.Provider></UserContext.Provider>
 }

 