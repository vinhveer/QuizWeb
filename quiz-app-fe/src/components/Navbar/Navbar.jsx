import React, { useState, useEffect } from 'react';
import avatar from '../../assets/63202399.png';
import './Navbar.css';

const Navbar = () => {
    const [darkMode, setDarkMode] = useState(false);

    useEffect(() => {
        document.body.setAttribute('data-bs-theme', darkMode ? 'dark' : 'light');
    }, [darkMode]);

    const toggleDarkMode = () => {
        setDarkMode(!darkMode);
    };

    const loginSuccess = true; // Giả sử người dùng đã đăng nhập thành công

    return (
        <div>
            <nav className="navbar navbar-expand-lg bg-body-tertiary fixed-top">
                <div className="container-fluid ps-4 pe-4">
                    <div className="brand">
                        <a className="navbar-brand" href="#">QuizWeb</a>
                    </div>
                    {/* For desktop */}
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav ms-auto me-auto mb-2 mb-lg-0">
                            <li className="nav-item active-item">
                                <a className="nav-link" href="#">
                                    <i className="fa-solid fa-house"></i>
                                    <span>Trang chủ</span>
                                </a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">
                                    <i className="fa-solid fa-compass"></i>
                                    <span>Khám phá</span>
                                </a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">
                                    <i className="fa-solid fa-magnifying-glass"></i>
                                    <span>Tìm kiếm</span>
                                </a>
                            </li>
                            {loginSuccess && (
                                <li className="nav-item">
                                    <a className="nav-link" href="#">
                                        <i className="fa-solid fa-layer-group"></i>
                                        <span>Thư viện của tôi</span>
                                    </a>
                                </li>
                            )}
                        </ul>
                    </div>

                    <div className="auth-container">
                        <button type="button" className="btn btn-dark-mode me-3" onClick={toggleDarkMode}>
                            {darkMode ? <i className="fa-solid fa-sun"></i> : <i className="fa-solid fa-moon"></i>}
                        </button>
                        {!loginSuccess ? (
                            <button type="button" className="btn btn-login" data-bs-toggle="modal" data-bs-target="#loginModal">Đăng nhập</button>
                        ) : (
                            <button className="btn btn-avatar" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                                <img src={avatar} className='avatar' />
                            </button>)}
                    </div>
                </div>
            </nav>

            {/* For tablet - mobile */}
            <nav className="navbar navbar-expand-lg bg-body-tertiary fixed-bottom mobile-mode">
                <div className="container-fluid">
                    <ul className="nav-items w-100">
                        <li className="nav-item active-item">
                            <a className="nav-link" href="#">
                                <i className="fa-solid fa-house"></i><br />
                                <span>Trang chủ</span>
                            </a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">
                                <i className="fa-solid fa-compass"></i><br />
                                <span>Khám phá</span>
                            </a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">
                                <i className="fa-solid fa-magnifying-glass"></i><br />
                                <span>Tìm kiếm</span>
                            </a>
                        </li>
                        {loginSuccess && (
                            <li className="nav-item">
                                <a className="nav-link" href="#">
                                    <i className="fa-solid fa-layer-group"></i><br />
                                    <span>Thư viện</span>
                                </a>
                            </li>
                        )}
                    </ul>
                </div>
            </nav>

            <div className="offcanvas offcanvas-end" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
                <div className="offcanvas-header">
                    <button type="button" className="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div className="offcanvas-body text-center">
                    <img src={avatar} className='avatar-full mb-2' />
                    <p className="fs-2 full-name">vinhveer</p>
                    <span>vinhveer123@gmail.com</span>

                    <ul className="list-group mt-4">
                        <li className="list-group-item">
                            <i className="fa-solid fa-user"></i>
                            <span>Thông tin cá nhân</span>
                        </li>
                        <li className="list-group-item">
                            <i className="fa-solid fa-shield-halved"></i>
                            <span>Tài khoản và bảo mật</span>
                        </li>
                        <li className="list-group-item">
                            <i className="fa-solid fa-right-to-bracket"></i>
                            <span>Đăng xuất</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    );
};

export default Navbar;
