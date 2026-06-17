import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import UpdateHooksState from './UpdateHookState'
import UseEffect from './UseEffect'
import User from './User'
import Country from './Country'
import UserProvider from './UserProvidery'
import {Page1, Page2, Page3} from "./Pages";

// const ShowHideUser = ({ show }) => (show ? <User/> : null)

function Choosepage({page}) {
  const Page = [page, Page2, Page3]
  const CurrentPage = pages[page] || Page1
  return <CurrentPage/>
}

function App() {
  const [count, setCount] = useState(0)
  const [show, setShow] = useState(false)
  const [page , setPage] = useState(0)

  return (
     <UserProvider/>     
      <h1>Working with React Hooks</h1>
    
    <button onClick={() => setPage(0)} disabled={page === 0}>Page 1</button>
    <button onClick={() => setPage(1)} disabled={page === 1}>Page 2</button>
    <button onClick={() => setPage(2)} disabled={page === 2}>Page 3</button>

      </UserProvider>
    )
}

export default App
