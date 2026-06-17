import React, { useEffect, useState } from 'react'
import Promise from 'bluebird'

Promise.config({ cancellation: true })

function fetchUser() {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({ id: 1, name: "Adam" })
        }, 10000)
    });
}

function User() {

    // CREATING OUR STATES WHICH WILL BE UPDATED
    const [id, setId] = useState("Loading..")
    const [name, setName] = useState("Loading..")

    // UPDATE OUR STATE USING USEEFFECT HOOK    
    useEffect(() => {
        const promise = fetchUser().then((user) => {
            setId(user.id)
            setName(user.name)
        })
        //CANCEL A PROMIS
        return () => {
            promise.cancel()
        }
    })

    return (
        <>
            <p>ID: {id}</p>
            <p>Name: {name}</p>
        </>
    )
}

export default User
