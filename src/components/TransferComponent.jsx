import React, { Component } from 'react'
import BankService from '../services/BankService';

class TransferComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            amountTransfer: '',
            accountName:'',
            account:{}
        }
    }


    handleSubmit(event){
        event.preventDefault();
        const amountToTransfer = this.state.amountTransfer;
        const account = {
            accountName:this.state.accountName
        };
        BankService.transferDetails(account,amountToTransfer).then((res) => {
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
                             Enter The Amount to be transferred
                        </p>
                         <input name="amountTransfer" value={this.state.amountTransfer} onChange={this.handleChange}/>
                    </label>
                    <label>
                         <p>
                             Enter The Account Details
                        </p>
                         <input name="accountName" value={this.state.accountName} onChange={this.handleChange}/>
                    </label>
                </fieldset>
                <button type="Submit">Login</button>
            </form>
        )
    }
}

export default TransferComponent;