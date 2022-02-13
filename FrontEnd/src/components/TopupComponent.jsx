import React, { Component } from 'react'
import BankService from '../services/BankService'

class TopupComponent extends Component {
    constructor(props) {
        super(props)
    }

componentDidMount(){
    let account = {AccountName: this.state.accountName};
    BankService.loginUser().then((res) => {
        this.setState({ account: res.data});
    });
    }

    render() {
        return (
            <form>
                <fieldset>
                <label>
                    <p>
                        Enter your UserID 
                    </p>
                    <input name="accountName"/>
                </label>
            </fieldset>
            <button type="Submit">Login</button>
            </form>
        )
    }
}

export default TopupComponent;