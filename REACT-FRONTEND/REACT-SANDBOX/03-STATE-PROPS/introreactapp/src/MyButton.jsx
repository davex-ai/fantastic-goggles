import React, { Component } from 'react'

export default class MyButton extends Component {
    // CREATING OUR DEFAULT PROPS
    static defaultProps = {
        disabled: false,
        text: 'Click Me'
    }
  render() {
    const {disabled, text} = this.props
    return (
      <div>
        <button disabled={disabled}>{text}</button>
      </div>
    )
  }
}
