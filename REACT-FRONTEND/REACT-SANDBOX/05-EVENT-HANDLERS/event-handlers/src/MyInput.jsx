import React from 'react' 

function MyInput() {

    const handleChange = () => {
        console.log("changed");
     
    }

    const handleBlur = () => {
        console.log("blurred");
     
    }
 
  return (
    <>
      <input type="text" onChange={handleChange} onBlur={handleBlur} />
     </>
  )
}

export default MyInput
