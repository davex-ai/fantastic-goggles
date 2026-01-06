import React from "react";
import { useAuth } from "../context/AuthContext";

export default function Navbar() {
  const { user } = useAuth();
  console.log(`Photo: ${user.photoURL}`);
  

  return (
    <div className="w-full h-16 bg-white border-b shadow-sm flex items-center justify-between px-6">
      
      <h1 className="text-2xl font-bold text-gray-800">Dashboard</h1>

      <div className="flex items-center gap-4">
        <div className="bg-gray-100 px-4 py-1 rounded-full text-sm text-gray-700 shadow-sm">
          Level 1 · XP 0
        </div>

         {user?.photoURL ? (
          <img
            src={user.photoURL}
            alt="Profile"
            className="w-10 h-10 rounded-full shadow-sm object-cover"
          />
        ) : (
          <div className="w-10 h-10 rounded-full bg-gray-200 flex items-center justify-center text-gray-700 font-bold shadow-sm">
            {user?.email?.charAt(0).toUpperCase()}
          </div>
        )}
      </div>
    </div>
  );
}
