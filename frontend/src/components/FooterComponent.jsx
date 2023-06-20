
import React, { Component } from 'react'

class FooterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                <footer className = "footer">
                {/* <footer className = "footer text-center"> */}
                    <span className="text-muted">Workshop QWA Soluções</span>
                </footer>
            </div>
        )
    }
}

export default FooterComponent

