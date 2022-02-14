import axios from 'axios';

const BANK_API_BASE_URL = "http://localhost:8080";

class BankService{
    loginUser(account){
        return axios.get(BANK_API_BASE_URL + '/login',account);
    }

    topupDetails(amount){
        return axios.post(BANK_API_BASE_URL + '/topup/' + amount);
    }

    transferDetails(account,amount){
        return axios.post(BANK_API_BASE_URL + '/pay' , amount,account);
    }
}

export default new BankService();
