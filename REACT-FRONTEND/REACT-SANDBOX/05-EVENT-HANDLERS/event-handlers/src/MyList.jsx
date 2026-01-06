import React from 'react' 

function MyList() {
 
     const items = [
    {id: 0, name: "First"},
    {id: 1, name: "Second"},
    {id: 2, name: "Third"}
  ]
  
  const onClick = (id) => {
    const { name } = items.find((i) => i.id === id)
    console.log(`clicked ${name}`);
     
  }

  return (
    <>
      <h1>My List</h1>
      <ul>
        {items.map(({id, name}) => (
            <li key={id} onClick={() => onClick(id)}>
                {name}
            </li>
        ))}
      </ul>
    </>
  )
}

export default MyList
