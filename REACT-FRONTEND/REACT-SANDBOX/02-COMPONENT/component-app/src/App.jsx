import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Nexora from './Nexora'
import Footer from './footer'
import MySection from './MySection'
import MyButton from './MyButton'
import MyNamespace from './MyNamespace'
 
function App() {
  const [count, setCount] = useState(0)
  const placeholder = 'Try inputing a value...'
  const text = "Nexora's Button"

  const array = ['First', 'Second', 'Third']

  const object = {
    first: 1,
    second: 2,
    third: 3
  }
 
  return (
     <>
    <Nexora/>
    <MySection>
      <input type="text" placeholder={placeholder} />
      <MyButton>{text}</MyButton>
      {/* <MyButton>button</MyButton> */}
    </MySection>
     <MyNamespace>
      <MyNamespace.First/>
      <MyNamespace.Second/>
     </MyNamespace>

     <h1>Displaying Our Array</h1>
     <ul>
      {/* {object.first} */}
      {array.map((i) => (
        <li key={i}> {i}</li>
      ))}
      </ul>

      <h1>Displaying Our Objects</h1>
      <ul>
      {/* {object.first} */}
      {Object.keys(object).map((i) => (
        <li key={i}><strong>{i} : </strong>
        {object[i]}
        </li>
      ))}
      </ul>
      <Footer/>
     </>
  )
}

export default App
