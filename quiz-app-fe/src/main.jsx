import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import { BrowserRouter } from 'react-router-dom'
import { QuizProvider } from './context/QuizContext.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <React.StrictMode>
      <QuizProvider>
        <App />
      </QuizProvider>
    </React.StrictMode>
  </BrowserRouter>,
)
