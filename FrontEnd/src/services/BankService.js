import axios from 'axios';

const BANK_API_BASE_URL = "http://localhost:8080";

class BankService{
    loginUser(){
        return axios.get(BANK_API_BASE_URL + '/login');
    }

    topupDetails(account,amount){
        return axios.post(BANK_API_BASE_URL + '/topup/' + amount,account);
    }

    transferDetails(account){
        return axios.post(BANK_API_BASE_URL + '/pay' ,account);
    }
}

export default new BankService();
