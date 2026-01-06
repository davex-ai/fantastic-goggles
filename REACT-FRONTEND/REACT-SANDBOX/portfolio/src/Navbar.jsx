import React, { Component } from 'react'
import logo from '/logo1.png'

export default function Navbar() {
 
    return (
      <>
      
        <nav className='flex justify-around items-center bg-gradient-to-br from-black to-[#aaaaaa] font-bold p-2 rounded-[300px] m-8 font-sans'>
            <div className="logo">
                <img className=' h-12 rounded-2xl' src={logo} alt="logo" />
                <img src="" alt="" />
            </div>
            <div className="text-[grey] ">
                <a className='ml-8 hover:text-white hover:overline' href="">Home</a>
                <a className='ml-8 hover:text-white  hover:overline' href="">About Me</a>
                <a className='ml-8 hover:text-white  hover:overline' href="">My Projects</a>
                <a className='ml-8 hover:text-white  hover:overline' href="">Testimonials</a>
                <a className='ml-8 hover:text-white  hover:overline' href="">Contact</a>
            </div>
            <div className="px-10 py-2 rounded-3xl bg-gradient-to-tl from-black to-gray-200">
                <button className=''>Contact</button>
            </div>
        </nav>
            {/* <navb className='bg-gradient-to-br from-red-800 to-blue-600 px-[50em] p-10'> mate</navb> from-gray-800 via-gray-500 to-transparent */}
      </>
    )
  }

