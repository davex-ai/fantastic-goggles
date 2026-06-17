import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
 import AWSServices from './Appl.jsx'
 
createRoot(document.getElementById('root')).render(
  <StrictMode>
    {/* <App /> */}
    <AWSServices/>
  </StrictMode>,
)
