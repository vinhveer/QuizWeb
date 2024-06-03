import Navbar from "./components/Navbar/Navbar"
import Home from "./pages/Home"
import Login from "./components/Login/Login";
import { Routes, Route } from 'react-router-dom'
import React from 'react';
import QuizDetails from "./pages/QuizDetails";
import MyQuiz from "./pages/MyQuiz";
import TakeQuiz from "./pages/TakeQuiz";

function App() {
  return (
    <div>
      <Navbar />
      <Login />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/quiz-details" element={<QuizDetails />} />
        <Route path="/my-quiz" element={<MyQuiz />} />
        <Route path="/take-quiz" element={<TakeQuiz />} />
      </Routes>
    </div>
  )
}

export default App
