import React, { createContext, useState, useEffect } from 'react';
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';
const API_URLS = {
    AUTHENTICATE: `${API_BASE_URL}/auth/authenticate`,
    REGISTER: `${API_BASE_URL}/auth/register`,
    QUIZZES: `${API_BASE_URL}/quizzes`,
    QUESTIONS: `${API_BASE_URL}/questions`,
    RESULTS: `${API_BASE_URL}/results`,
    USER_INFO: (userId) => `${API_BASE_URL}/users/${userId}`,
};

const QuizContext = createContext();

const QuizProvider = ({ children }) => {
    const [user, setUser] = useState(null);
    const [quizzes, setQuizzes] = useState([]);
    const [questions, setQuestions] = useState([]);
    const [results, setResults] = useState([]);

    useEffect(() => {
        const storedUserId = localStorage.getItem('id');
        if (storedUserId) {
            fetchUserInfo(storedUserId);
        }
    }, []);

    useEffect(() => {
        if (user) {
            fetchQuizzes();
            fetchQuestions();
            fetchResults();
        }
    }, [user]);

    const getToken = () => localStorage.getItem('token') || '';

    const login = async (email, password) => {
        try {
            const response = await axios.post(API_URLS.AUTHENTICATE, {
                username: email,
                password,
            });
            const { jwt, id } = response.data;
            localStorage.setItem('token', jwt);
            localStorage.setItem('id', id);
            await fetchUserInfo(id);
        } catch (error) {
            console.error('Login error:', error.response ? error.response.data : error.message);
        }
    };

    const register = async (username, password, avatarFile) => {
        try {
            let avatarUrl = '';
            if (avatarFile) {
                avatarUrl = await uploadAvatar(avatarFile);
            }
            await axios.post(API_URLS.REGISTER, {
                username,
                password,
                email: username,
                avatar: avatarUrl,
            });
        } catch (error) {
            console.error('Register error:', error.response ? error.response.data : error.message);
        }
    };

    const uploadAvatar = async (avatarFile) => {
        try {
            const formData = new FormData();
            formData.append('file', avatarFile);
            const response = await axios.post('http://localhost:8080/upload', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                    Authorization: `Bearer ${getToken()}`,
                },
            });
            return response.data.url;
        } catch (error) {
            console.error('Upload avatar error:', error.response ? error.response.data : error.message);
            throw error;
        }
    };

    const logout = () => {
        localStorage.removeItem('token');
        localStorage.removeItem('id');
        setUser(null);
        window.location.reload();
    };

    const fetchQuizzes = async () => {
        try {
            const response = await axios.get(API_URLS.QUIZZES, {
                headers: {
                    Authorization: `Bearer ${getToken()}`,
                },
            });
            if (response.data) {
                setQuizzes(response.data);
            }
        } catch (error) {
            console.error('Fetch quizzes error:', error.response ? error.response.data : error.message);
        }
    };

    const fetchQuestions = async () => {
        try {
            const response = await axios.get(API_URLS.QUESTIONS, {
                headers: {
                    Authorization: `Bearer ${getToken()}`,
                },
            });
            if (response.data) {
                setQuestions(response.data);
            }
        } catch (error) {
            console.error('Fetch questions error:', error.response ? error.response.data : error.message);
        }
    };

    const fetchResults = async () => {
        try {
            const response = await axios.get(API_URLS.RESULTS, {
                headers: {
                    Authorization: `Bearer ${getToken()}`,
                },
            });
            if (response.data) {
                setResults(response.data);
            }
        } catch (error) {
            console.error('Fetch results error:', error.response ? error.response.data : error.message);
        }
    };

    const fetchUserInfo = async (userId) => {
        try {
            const response = await axios.get(API_URLS.USER_INFO(userId), {
                headers: {
                    Authorization: `Bearer ${getToken()}`,
                },
            });
            if (response.data) {
                setUser(response.data);
            }
        } catch (error) {
            console.error('Fetch user info error:', error.response ? error.response.data : error.message);
        }
    };

    const uploadImage = async (imageFile) => {
        try {
            const formData = new FormData();
            formData.append('file', imageFile);
            const response = await axios.post('http://localhost:8080/upload', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                    Authorization: `Bearer ${getToken()}`,
                },
            });
            return response.data.url;
        } catch (error) {
            console.error('Upload image error:', error.response ? error.response.data : error.message);
            throw error;
        }
    };

    const createQuiz = async (newQuiz) => {
        try {
            const response = await axios.post(API_URLS.QUIZZES, newQuiz, {
                headers: {
                    Authorization: `Bearer ${getToken()}`,
                    'Content-Type': 'application/json',
                },
            });
            return response.data;
        } catch (error) {
            console.error('Create quiz error:', error.response ? error.response.data : error.message);
            throw error;
        }
    };

    return (
        <QuizContext.Provider value={{ user, login, register, logout, quizzes, questions, results, createQuiz, uploadImage }}>
            {children}
        </QuizContext.Provider>
    );
};

export { QuizProvider, QuizContext };
