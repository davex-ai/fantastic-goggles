import React from "react";
import { signInWithGoogle } from "./firebase";
import { useNavigate } from "react-router-dom";

function Login() {
  const navigate = useNavigate();

  const login = async () => {
    await signInWithGoogle();
    navigate("/");
  };

  return (
    <div>
      <p className="psin">Sign In With Google</p>
      <button className="sign" onClick={login}>Sign In With Google</button>
    </div>
  );
}

export default Login;
