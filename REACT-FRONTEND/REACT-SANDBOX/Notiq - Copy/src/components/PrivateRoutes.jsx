import React from 'react'
import { useAuth } from '../context/AuthContext'
import { Navigate } from 'react-router-dom'
import Login from '../pages/Login'

function PrivateRoutes({ children }) {
    const { user, loading } = useAuth()
    if(loading) return null
    if (!user)  return <Navigate to={'/login'} />
    
  return children
}

export default PrivateRoutes
