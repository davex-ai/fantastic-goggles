import React, { Component } from 'react'
import img from './assets/hero-.png'

function Hero () {
  
        return (
            <>
            <div className='mt-[30px] flex justify-around font-sans h-[90vh] flex-wrap -mb-[14em] '>
                <div className="text-left m-[30px] ">
                    <h3 className='text-[25px] text-[#8b8787]'>WELCOME TO MY WORLD💫</h3>
                    <h2 className=' text-[80px]'>Hi, I'm<span className='text-[50%]'> Nexora</span></h2>
                    <strong className='text-[450%] font-sans text-[#8b8787]'>SoftWare <strong className='text-[#ffff]'>Engineer </strong></strong>
                    <p className='text-[20px] w-[40em]'>Passionate Software Engineer. Who judges a book by its cover, Cuz if it doesn't look  impressive what else can. I transform ideas into seamless products that meet user expectetation</p>
                    <div className="flex m-8">
                        <button className='py-[12px] px-[60px] rounded-[25px] text-[18px] bg-[#8b8787]'>My Projects</button>
                        <button className='ml-14 px-8 py-3 border-[1px] rounded-full'>Download CV</button>
                    </div>
                         <div class="contact-icons">
                    <a href="#" target="_blank" className='text-gray-700 text-[30px] bg-[#8b8787] rounded-[50%] p-2 w-[71em] h-[14em]'>
                        <i class="fab fa-github"></i>
                    </a>
                    <a href="mailto:omotoyedave4@gmail.com">
                        <i class="fab fa-instagram"></i>
                    </a>
                    <a href="#" target="_blank">
                         <i class="fa-brands fa-linkedin-in"></i>
                    </a>
                    <a href="#" target="_blank">
                        <i class="fab fa-twitter"></i>
                    </a>
                </div>
                </div>
                <div className="m-[30px] w-[40em]"><img src={img} alt="" /></div>
            </div> 
                 <button className='bg-gradient-to-t from-gray-950 to-white p-5 rounded-[50%] ml-[50em] text-[20px] w-16 '>↡</button>
            </>
        )
    }

export default Hero