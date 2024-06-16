import './App.css'
import Authenciation from './components/Authentication/Authentication'
import Navbar from './components/Navbar/Navbar'
import Home from './pages/Home'

function App() {
  return (
    <div>
      <Navbar />
      <Authenciation />
      <Home />
    </div>
  )
}

export default App
