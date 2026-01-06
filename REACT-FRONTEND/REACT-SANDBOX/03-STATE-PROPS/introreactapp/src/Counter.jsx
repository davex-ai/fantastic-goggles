import React, { Component } from 'react'

export default class Counter extends Component {

    //CREATING OUR STATE
    //THIS WILL CREATE A COMPONENT STATE
    constructor(props){
        super(props)
        //INITIAL STATE WILL CREATE A COMPONENT STATE
        this.state = {
            count: 0
        }
        this.increment = this.increment.bind(this)
    }
    increment(){
        this.setState(prevState => ({
            count: prevState.count +1
        }))
    }
  render() {
    return (
      <div>
       <h1>Counter: {this.state.count}</h1>
       <button onClick={this.increment}>Increase</button>
      </div>
    )
  }
}
