import { Routes, Route } from "react-router-dom";
import Login from "./pages/Login.jsx";
import Register from "./pages/Register.jsx";
import PrivateRoutes from "./components/PrivateRoutes.jsx";
import DashboardLayout from "./components/DashboardLayout.jsx";
import Home from "./pages/Home.jsx";
 import Notes from "./pages/Notes"; 

function App() {
  return (
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/" element={<Home />} />
      <Route path="/register" element={<Register/>} />
       <Route path="/dashboard" element={<PrivateRoutes> <DashboardLayout/> </PrivateRoutes>} />

<Route
  path="/sample"
  element={
    <PrivateRoutes>
      <DashboardLayout>
        <Notes />
      </DashboardLayout>
    </PrivateRoutes>
  }
/>


    </Routes>
  );
}

export default App;
