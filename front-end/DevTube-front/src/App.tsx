import './App.css'
import { Route, Routes } from 'react-router-dom'
import Home from './pages/Home'
import DevTubeHome from './pages/DevTubeHome'

function App() {
  return (
			<Routes>
				<Route path="/" element={<Home />}/>
				<Route path="devTube" element={<DevTubeHome />} />
			</Routes>
  )
}

export default App
