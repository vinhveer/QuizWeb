import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import Authentication from './components/Authentication/Authentication';
import Navbar from './components/Navbar/Navbar';
import Home from './pages/Home/Home';
import AccountSettings from './pages/Account/AccountSettings';
import PersonalInfo from './pages/Account/PersonalInfo';

function App() {
  return (
    <div>
      <Navbar />
      <Authentication />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/account-settings" element={<AccountSettings />} />
        <Route path="/personal-info" element={<PersonalInfo />} />
      </Routes>
    </div>
  );
}

export default App;
