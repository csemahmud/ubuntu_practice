import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ListUserComponent from './components/ListUserComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import UserComponent from './components/UserComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import 'bootstrap-icons/font/bootstrap-icons.css';

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <BrowserRouter className="browser_router">
      <HeaderComponent/>
    <div  style={{margin:'2em'}} className='app_background'>
      <h1>Master App</h1>
      <Routes className="browser_router">
          {/* // http://localhost:3001/ */}
          <Route path='/' element = {<ListUserComponent/>}></Route>
          {/* // http://localhost:3001/users */}
          <Route path='/users' element = {<ListUserComponent/>}></Route>
          {/* // http://localhost:3001/add-user */}
          <Route className="browser_router" path='/add-user' element = {<UserComponent/>}></Route>
          {/* // http://localhost:3001/edit-user/1 */}
          <Route path='/edit-user/:id' element = {<UserComponent/>}></Route>
      </Routes>
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
      </div>
      <FooterComponent/>
      </BrowserRouter>
    </>
  )
}

export default App
