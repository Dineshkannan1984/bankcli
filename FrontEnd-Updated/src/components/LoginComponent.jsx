import React, { Component } from 'react';
import BankService from '../services/BankService';
import { Link } from 'react-router-dom';


class LoginComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {accountName:'',account:{}}
        this.handleSubmit=this.handleSubmit.bind(this);
        this.handleChange=this.handleChange.bind(this);
    }

    handleSubmit(event){
        event.preventDefault();
        const account = {
            accountName:this.state.accountName
        };
        BankService.loginUser(account).then((res) => {
            this.setState({ account: res.data});
        });
    }
    handleChange(event){
        this.setState({accountName:event.target.value});    
    }

      render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <fieldset>
                    <label>
                         <p>
                             Enter your UserID 
                        </p>
                         <input name="accountName" value={this.state.accountName} onChange={this.handleChange}/>
                    </label>
                </fieldset>
                <button type="Submit">Login</button>
            </form>
        )
    }
}

export default LoginComponent;

