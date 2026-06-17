import { Component, useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import './App.css'
import CreateState from './CreateState'
import Counter from './Counter'
import MyButton from './MyButton'
import AWSServices from './Appl'

class App extends Component {
  constructor(props) {
    super(props)
    //INITIAL STATE WILL CREATE A COMPONENT STATE
    this.state = {
      btnDisable: false,
      btnText: 'Clicky'
    }
  }

componentDidMount(){ 
//AFTER 3 SECONDS UPDATE
setTimeout(() => {
  this.setState({
    btnDisable: true,
      btnText: 'I have been disabled'
  })
},3000)

}

render(){
  return (
    <>
      <CreateState />
      <Counter />
      <MyButton disabled={this.state.btnDisable} text={this.state.btnText} />
      <AWSServices/>
    </>
  )
}
}

export default App
