import React from 'react'
import { assets } from '../../assets/assets'
import './Navbar.css'

const Navbar = () => {
    return (
        <nav className="navbar navbar-expand-lg">
            <div className="container">
                <a className="navbar-brand" href="#">
                    <img src={assets.logo} alt="" srcset="" />
                    <span>Quizz</span>
                </a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav me-auto">
                        <li className="nav-item">
                            <a className="nav-link active" aria-current="page" href="#">Trang chủ</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">Quizz nổi bật</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#"></a>
                        </li>
                    </ul>
                    <ul className='navbar-nav d-flex'>
                        <li className="nav-item">
                            <a className="nav-link" href="#">Về chúng tôi</a>
                        </li>
                        <li className="nav-item">
                            <a className="btn btn-primary ms-2 me-2" href="#">Đăng nhập</a>
                        </li>
                        <li className="nav-item">
                            <a className="btn btn-outline-primary" href="#">Đăng ký</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}

export default Navbar
