import React, { Component } from "react";

 class MySection extends Component{
    render(){
    return(
          <section>
            <h2>MySection</h2>
            {this.props.children}
            </section>
    );
}
}

export default MySection;