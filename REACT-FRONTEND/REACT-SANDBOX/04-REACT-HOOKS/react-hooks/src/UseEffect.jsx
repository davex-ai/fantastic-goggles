import React, { useEffect ,useState } from 'react'

function fetchUser(){
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({ id: 1, name: "Adam"})
        }, 5000)
    })
}

function UseEffect() {
    // CREATING OUR STATES WHICH WILL BE UPDATED
    const [id, setId] = useState("Loading..")
    const [name, setName] = useState("Loading..")

    // UPDATE OUR STATE USING USEEFFECT HOOK
    useEffect(() => {
        fetchUser().then((user) => {
            setId(user.id)
             setName(user.name)
        })
    })
  return (
    <>
      <p>ID: {id}</p>
      <p>Name: {name}</p>
    </>
  )
}

export default UseEffect
