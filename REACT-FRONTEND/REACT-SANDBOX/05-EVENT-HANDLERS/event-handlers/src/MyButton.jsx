import React, { Children } from "react"

function MyButton({children}) {

    
 const onClick = () => {
console.log("Do you understand eventhandler now??");

 }
  return (
    <>
       <button onClick={onClick}>{children}</button>
    </>
  )
}

export default MyButton
