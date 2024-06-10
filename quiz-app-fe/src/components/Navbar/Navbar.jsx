// Navbar.js
import React, { useContext, useState, useEffect } from 'react';
import { QuizContext } from '../../context/QuizContext';
import { assets } from '../../assets/assets';
import { NavLink } from 'react-router-dom';
import './Navbar.css';

const Navbar = () => {
    const { user, logout } = useContext(QuizContext);
    const loginSuccess = !!user;

    const [darkMode, setDarkMode] = useState(false);

    useEffect(() => {
        if (darkMode) {
            document.body.setAttribute('data-bs-theme', 'dark');
        } else {
            document.body.removeAttribute('data-bs-theme');
        }
    }, [darkMode]);

    const toggleDarkMode = () => {
        setDarkMode(!darkMode);
    };

    return (
        <div>
            <nav className={`navbar navbar-expand-lg ${darkMode ? 'navbar-dark bg-dark' : 'bg-body-tertiary'}`}>
                <div className="container-fluid ps-5 pe-5">
                    <NavLink className="navbar-brand" to="/">
                        <img src={assets.logo} alt="Quizz Logo" />
                        <span>Quizz</span>
                    </NavLink>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav me-auto">
                            <li className="nav-item">
                                <NavLink exact className="nav-link" activeClassName="active" to="/">Home</NavLink>
                            </li>
                            <li className="nav-item">
                                <NavLink className="nav-link" activeClassName="active" to="/explore">Explore</NavLink>
                            </li>
                            {loginSuccess ? (
                                <li className="nav-item">
                                    <NavLink className="nav-link" activeClassName="active" to="/my-quiz">Libary</NavLink>
                                </li>
                            ) : null}
                        </ul>
                    </div>
                    <NavLink className="nav-link me-2" activeClassName="active" to="/search"><i class="bi bi-search"></i></NavLink>
                    <button type="button" className="btn btn-outline-secondary ms-3 me-3" onClick={toggleDarkMode}>
                        {darkMode ? <i class="bi bi-brightness-high"></i> : <i class="bi bi-moon-stars"></i>}
                    </button>
                    {loginSuccess ? (
                        <button type="button" className='btn btn-login'>
                            <img src={user.avatar} alt="" srcSet="" className='img-avatar' data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight" />
                        </button>
                    ) : (
                        <ul className='ms-auto navbar-nav d-flex'>
                            <li className="nav-item">
                                <button className="btn btn-primary ms-2 me-2" data-bs-toggle="modal" data-bs-target="#loginModal">Login</button>
                            </li>
                            <li className="nav-item">
                                <a className="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#registerModal">Register</a>
                            </li>
                        </ul>
                    )}
                    <button
                        className="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarNav"
                        aria-controls="navbarNav"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                    >
                        <span className="navbar-toggler-icon"></span>
                    </button>   
                </div>
            </nav>

            {loginSuccess ? (
                <div className="offcanvas offcanvas-end" tabIndex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
                    <div className="offcanvas-header">
                        <button type="button" className="btn btn-primary" onClick={logout}>Logout</button>
                        <button type="button" className="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div className="offcanvas-body text-center">
                        <img src={user.avatar} className='img-avatar-canva'/>
                        <div className="mt-3">
                            <h5>{user.username}</h5>
                            <p>{user.email}</p>
                        </div>
                        <div className="mt-3">
                            
                        </div>
                    </div>
                </div>) : null}
        </div>
    );
};

export default Navbar;
