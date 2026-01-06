import { useState } from "react"

function UpdateHooksState(){
const [name, setName] = useState("Adam")
const [age, setAge] = useState(34)

return (
    <>
        <section>
            <input value={name} onChange={(e) => setName(e.target.value)} />
            <p>name is {name}</p>
        </section>
        <section>
            <input value={age} onChange={(e) => setAge(e.target.value)} />
            <p>age is {age}</p>
        </section>
    </>
)
}

export default UpdateHooksState