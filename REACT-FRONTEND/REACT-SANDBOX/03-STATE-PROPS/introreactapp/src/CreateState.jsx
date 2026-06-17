import React, { Component } from 'react'

export default class CreateState extends Component {
    state = {
        heading: 'React Awesome (Busy)',
        content: 'Loading'
    }
  render() {

    const { heading, content} = this.state
    
    return (
      <div>
        <h1>{heading}</h1>
        <p>{content}</p>
      </div>
    )
  }
}
