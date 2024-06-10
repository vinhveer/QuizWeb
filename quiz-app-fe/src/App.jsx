import Navbar from "./components/Navbar/Navbar"
import Home from "./pages/Home"
import Login from "./components/Login/Login";
import { Routes, Route } from 'react-router-dom'
import React from 'react';
import QuizDetails from "./pages/QuizDetails";
import Libary from "./pages/Libary";
import TakeQuiz from "./pages/TakeQuiz";
import CreateQuiz from "./pages/CreateQuiz";
import Search from "./pages/Search";

function App() {
  return (
    <div>
      <Navbar />
      <Login />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/quiz-details" element={<QuizDetails />} />
        <Route path="/my-quiz" element={<Libary />} />
        <Route path="/take-quiz" element={<TakeQuiz />} />
        <Route path="/create-quiz" element={<CreateQuiz />} />
        <Route path="/search" element={<Search />} />
      </Routes>
    </div>
  )
}

export default App
