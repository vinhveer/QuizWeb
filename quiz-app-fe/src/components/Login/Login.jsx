import React, { useContext, useState } from 'react';
import { QuizContext } from '../../context/QuizContext';
import Spinner from '../Spinner/Spinner';

const Login = () => {
    const { login, register } = useContext(QuizContext);
    const [loginUsername, setLoginUsername] = useState('');
    const [loginPassword, setLoginPassword] = useState('');
    const [registerUsername, setRegisterUsername] = useState('');
    const [registerEmail, setRegisterEmail] = useState('');
    const [registerPassword, setRegisterPassword] = useState('');
    const [registerAvatar, setRegisterAvatar] = useState(null);
    const [loginError, setLoginError] = useState('');
    const [registerError, setRegisterError] = useState('');
    const [registerSuccess, setRegisterSuccess] = useState('');
    const [loading, setLoading] = useState(false);

    const validateEmail = (email) => {
        const re = /\S+@\S+\.\S+/;
        return re.test(email);
    };

    const handleLoginSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        setLoginError('');
        try {
            await login(loginUsername, loginPassword);
            setLoading(false);
            window.location.reload();
        } catch (error) {
            setLoginError('Incorrect username or password.');
            setLoading(false);
        }
    };

    const handleRegisterSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        setRegisterError('');
        setRegisterSuccess('');

        // Validate inputs
        if (!registerAvatar) {
            setRegisterError('You have not uploaded an image. Please upload to continue.');
            setLoading(false);
            return;
        }
        if (!/^[a-zA-Z0-9]+$/.test(registerUsername)) {
            setRegisterError('Username can only contain letters and numbers.');
            setLoading(false);
            return;
        }
        if (registerPassword.length < 8) {
            setRegisterError('Password must be more than 8 characters.');
            setLoading(false);
            return;
        }
        if (!validateEmail(registerEmail)) {
            setRegisterError('Invalid email format.');
            setLoading(false);
            return;
        }

        try {
            await register(registerUsername, registerPassword, registerAvatar);
            setLoading(false);
            setRegisterSuccess('Registration successful!');
            setTimeout(() => {
                window.location.reload();
            }, 1500);
        } catch (error) {
            setRegisterError('Registration unsuccessful.');
            setLoading(false);
        }
    };

    return (
        <div>
            <div className="modal fade" id="loginModal" tabIndex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
                <div className="modal-dialog modal-dialog-centered">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h3 className="modal-title fs-5" id="loginModalLabel">Login</h3>
                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            {loginError && <div className="alert alert-danger">{loginError}</div>}
                            <form onSubmit={handleLoginSubmit}>
                                <div className="mb-3">
                                    <label htmlFor="username" className="form-label">Username</label>
                                    <input 
                                        type="text" 
                                        className="form-control" 
                                        id="username" 
                                        value={loginUsername} 
                                        onChange={(e) => setLoginUsername(e.target.value)} 
                                    />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="password" className="form-label">Password</label>
                                    <input 
                                        type="password" 
                                        className="form-control" 
                                        id="password" 
                                        value={loginPassword} 
                                        onChange={(e) => setLoginPassword(e.target.value)} 
                                    />
                                </div>
                                <button type="submit" className="btn btn-primary" disabled={loading}>
                                    {loading ? <Spinner /> : 'Login'}
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div className="modal fade" id="registerModal" tabIndex="-1" aria-labelledby="registerModalLabel" aria-hidden="true">
                <div className="modal-dialog modal-dialog-centered">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h3 className="modal-title fs-5" id="registerModalLabel">Register</h3>
                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            {registerError && <div className="alert alert-danger">{registerError}</div>}
                            {registerSuccess && <div className="alert alert-success">{registerSuccess}</div>}
                            <form onSubmit={handleRegisterSubmit}>
                                <div className="mb-3">
                                    <label htmlFor="registerUsername" className="form-label">Username</label>
                                    <input 
                                        type="text" 
                                        className="form-control" 
                                        id="registerUsername" 
                                        value={registerUsername} 
                                        onChange={(e) => setRegisterUsername(e.target.value)} 
                                    />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="registerEmail" className="form-label">Email</label>
                                    <input 
                                        type="email" 
                                        className="form-control" 
                                        id="registerEmail" 
                                        aria-describedby="emailHelp" 
                                        value={registerEmail} 
                                        onChange={(e) => setRegisterEmail(e.target.value)} 
                                    />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="registerPassword" className="form-label">Password</label>
                                    <input 
                                        type="password" 
                                        className="form-control" 
                                        id="registerPassword" 
                                        value={registerPassword} 
                                        onChange={(e) => setRegisterPassword(e.target.value)} 
                                    />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="registerAvatar" className="form-label">Avatar</label>
                                    <input 
                                        type="file" 
                                        className="form-control" 
                                        id="registerAvatar" 
                                        onChange={(e) => setRegisterAvatar(e.target.files[0])} 
                                    />
                                </div>
                                <button type="submit" className="btn btn-primary" disabled={loading}>
                                    {loading ? <Spinner /> : 'Register'}
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Login;
