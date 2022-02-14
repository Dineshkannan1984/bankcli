import React, { Component } from 'react';
import BankService from '../services/BankService';

class TopupComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {topupAmt:'',account:{}}
        this.handleSubmit=this.handleSubmit.bind(this);
        this.handleChange=this.handleChange.bind(this);
    }


handleSubmit(event){
    event.preventDefault();
    const topupAmt=this.state.topupAmt;
    BankService.loginUser(topupAmt).then((res) => {
        this.setState({ account: res.data});
    });
}
handleChange(event){
    this.setState({topupAmt:event.target.value});    
}

    render(){
        return (
            <form onSubmit={this.handleSubmit}>
                <fieldset>
                    <label>
                        <p>
                            Enter the amunt to Topup
                        </p>
                        <input name="topupAmt" value={this.state.topupAmt} onChange={this.handleChange}/>
                    </label>
                </fieldset>
                <button type="Submit">Topup</button>
            </form>
        )
    }
}
export default TopupComponent;