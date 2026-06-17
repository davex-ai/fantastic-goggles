import React, { Component } from 'react'
import './style.css'
import img from './assets/Screenshot 2025-09-21 221640.png'

class Hero extends Component {
    render() {
        return (
            <div className='hero'>
                <div className="hero-text">
                    <h3>WELCOME TO MY WORLD💫</h3>
                    <h2>Hi, I'm<span> Nexora</span></h2>
                    <h1>SoftWare Engineer</h1>
                    <p>Passionate Software Engineer. Who judges a book by its cover, Cuz if it doesn't look  impressive what else can. I transform ideas into seamless products that meet user expectetation</p>
                    <div className="hero-button">
                       <button className='project'>My Projects</button>
                       <button className='cv'>Download CV</button>
                    </div>
                </div>
                <div className="hero-image"><img src={img} alt="" /></div>
            </div>
        )
    }
}
export default Hero