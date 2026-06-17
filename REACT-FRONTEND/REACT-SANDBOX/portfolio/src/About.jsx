import React from 'react'
import img from './assets/about.png'

function About() {
  return (
    <>
      <div className='mt-64 flex justify-between '>
        <div>
        <img src={img} alt="" className='w-[45em]'/>
        </div>
        <div>
          <h1>About Me</h1>
          <p>Welcome to my portfolio. I'm Dave Omotoye, a passionate Software Engineer dedicated to creating seamless and visually engaging digital experiences. With 2 years of experience. I specialize in designing intuitive interfaces that enhance usability and user satisfaction.</p>
          <p>My skills include wireframing, development of mobile and web apps, ensuring that each design is both aesthetically pleasing and functionality efficient. I have worked on diverse projects, including mobile apps, web platforms, and interactive dashboards, always focusing on user - centered solutins that drive engagement</p>
          <div>
            <img src="" alt="" />
            <p>I am deeply committed to work, investing creativity and precision into every project to ensure a unique and effective user experience</p>
          </div>
        </div>
      </div>
      <div>
        <h3>Skills</h3>

      </div>
    </>
  )
}

export default About
