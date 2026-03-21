import { useState } from 'react'
import Navbar from './components/common/Navbar'
import Login from './features/auth/pages/Login'
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Register from './features/auth/pages/Register';

function App() {

  return (
    <>
    <Login/>
    <Register/>
    <ToastContainer position='bottom-right'/>
    </>
  )
}

export default App
