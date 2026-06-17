import { useState } from 'react'
import { BrowserRouter as Router, Route, Routes, NavLink } from 'react-router-dom'
import './App.css'
import Contact from './Contact '
import About from './About'
import Info from './Info'
import Testimonial from './Testimonial'

function App() {

  return (
    <>

      <header>
        <nav>
          <NavLink to="/">Home</NavLink> | {" "}
          <NavLink to="/about">About</NavLink> | {" "}
          <NavLink to="/contact">Contact</NavLink>| {" "}
          <NavLink to="/info">Info</NavLink> | {" "}
          <NavLink to="/testimonial">Testimonial</NavLink> |
        </nav>
      </header>

      <h1>Working With Routes</h1>

      <Routes>
        <Route path="/" element={<h1>Home</h1>} />
        <Route path="/about" element={<About/>} />
        <Route path="/contact" element={<Contact/>} />
        <Route path="/info" element={<Info/>} />
        <Route path="/testimonial" element={<Testimonial/>} />
      </Routes>
    </>
  )
}

export default App
