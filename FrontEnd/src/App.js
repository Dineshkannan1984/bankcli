import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import TopupComponent from './components/TopupComponent';
import TransferComponent from './components/TransferComponent';
import LoginComponent from './components/LoginComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';

function App() {
  return (
    <div>
        <Router>
              <HeaderComponent />
                <div className="container">
                    <Routes> 
                          <Route path = "/" exact element = {<LoginComponent/>}></Route>
                          <Route path = "/transfer" element = {<TransferComponent/>}></Route>
                           <Route path = "/topup" element = {<TopupComponent/>}></Route>
                     </Routes>
                </div>
              <FooterComponent />
        </Router>
    </div>
    
  );
}

export default App;