import React from "react";
import { Link } from "react-router-dom";
import { useAuthState } from "react-firebase-hooks/auth";
import { auth, signOutUser } from "./firebase";
import "./App.css";

function Navbar() {
  const [user] = useAuthState(auth);

  return (
    <div className="navbar">
      <div className="links">
        <Link to="/">Home</Link>
        {!user && <Link to="/login">Login</Link>}
      </div>

      <div className="user">
        {user ? (
          <>
            <p>{user.displayName}</p>
            <img src={user.photoURL} alt="profile" width={30} height={30} />
            <button onClick={signOutUser}>Log Out</button>
          </>
        ) : (
          <p>Not logged in</p>
        )}
      </div>
    </div>
  );
}

export default Navbar;
