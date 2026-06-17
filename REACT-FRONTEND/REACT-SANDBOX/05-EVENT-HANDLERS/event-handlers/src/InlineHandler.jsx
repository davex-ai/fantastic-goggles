import React from 'react'
import './App.css'

function InlineHandler( {children} ) {
 //DECLARING INLINE EVENT HANDLER
  return (
    <button onClick={e => console.log("clicked ",e)
    }>{children}</button>
  )
}

export default InlineHandler
