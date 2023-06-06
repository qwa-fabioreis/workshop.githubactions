import React, { Component } from 'react'
import ClientService from '../services/ClientService'

class ViewClientComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            client: {}
        }
    }

    componentDidMount(){
        ClientService.getClientById(this.state.id).then( res => {
            this.setState({client: res.data});
        })
    }

    back(){
        this.props.history.push('/clients');
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Client Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Client First Name: </label>
                            <div> { this.state.client.name }</div>
                        </div>
                        <div className = "row">
                            <label> Client Email: </label>
                            <div> { this.state.client.email }</div>
                        </div>
                        <div className = "row">
                            <hr />
                        </div>
                        <div className = "row">
                            <div className='d-grid gap-2 col-6 mx-auto' >
                                <button className="btn btn-secondary btn-sm" onClick={this.back.bind(this)} style={{marginLeft: "10px"}}>Back</button>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewClientComponent

