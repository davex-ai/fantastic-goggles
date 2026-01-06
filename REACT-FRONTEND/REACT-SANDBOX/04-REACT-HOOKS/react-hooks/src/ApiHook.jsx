import React, { useEffect, useState } from 'react'


function ApiHook() {

const [name, setName] = useState(null)
const [image, setimage] = useState(null)
const [description, setdescription] = useState(null)
const [size, setSize] = useState(null)
const [hitpoint, setHitpoints] = useState(null)
const [Abilities, setAbilities] = useState(null)
// const [img, setImage] = useState(null)

useEffect(() => {
const api = "https://www.dnd5eapi.co/api/monsters/acolyte";
fetch(api)
.then(response => response.json())
  .then(result => {
    console.log(result)
    setName(result.name|| "N/A")
    setimage(result.image || "N/A")
    setdescription(result.desc || "N/A")
    setSize(result.size || "N/A")
    setHitpoints(result.hit_points || "N/A")
    setAbilities(result.special_abilities.name || "N/A")
  },6000)  
},[])

// useEffect(() => {
// const diney = "https://api.disneyapi.dev/character";
// fetch(diney)
//     .then(res => res.json())
//     .then(result => {
//       console.log(result); // 👈 Always check structure first!
//       const char = result.data[8]; // 9th character (index 8)

//       setName(char.name || "N/A");
//       setImage(char.imageUrl || "https://via.placeholder.com/100"); // fallback image
//     })
//     .catch(err => console.error("Error:", err));
// }, [])

   return (
    <div>
      <h1>{name}</h1>
      <h1>{image}</h1>
      <h1>{description}</h1>
      <h1>{size}</h1>
      <h1>{hitpoint}</h1>
      <h1>{Abilities}</h1>
      <div>
  {/* <h1>{name}</h1>
  {img && <img src={img} alt={name} className="w-40 h-40 object-cover rounded-lg" />} */}
</div>
    </div>
  )
}

export default ApiHook
