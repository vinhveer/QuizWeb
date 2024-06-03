import React from 'react';
import { assets } from '../../assets/assets';
import './Navbar.css';
import Search from '../Search/Search';

const Navbar = () => {
    const loginSuccess = true;

    return (
        <div>
            <nav className="navbar navbar-expand-lg">
                <div className="container-fluid">
                    <a className="navbar-brand" href="#">
                        <img src={assets.logo} alt="Quizz Logo" />
                        <span>Quizz</span>
                    </a>
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
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav me-auto">
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="#">Trang chủ</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Thư viện của tôi</a>
                            </li>
                        </ul>
                        <Search />
                        {loginSuccess ? (
                            <ul className='ms-auto navbar-nav d-flex'>
                                <li className="nav-item">
                                    <a className="nav-link" href="#" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">A</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="#">Đăng xuất</a>
                                </li>
                            </ul>
                        ) : (
                            <ul className='ms-auto navbar-nav d-flex'>
                                <li className="nav-item">
                                    <button className="btn btn-primary ms-2 me-2" data-bs-toggle="modal" data-bs-target="#loginModal">Đăng nhập</button>
                                </li>
                                <li className="nav-item">
                                    <a className="btn btn-outline-primary" href="#">Đăng ký</a>
                                </li>
                            </ul>
                        )}
                    </div>
                </div>
            </nav>

            <div className="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
                <div className="offcanvas-header">
                    <h5 className="offcanvas-title" id="offcanvasRightLabel">Offcanvas right</h5>
                    <button type="button" className="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div className="offcanvas-body">
                    ...
                </div>
            </div>
        </div>
    );
};

export default Navbar;
