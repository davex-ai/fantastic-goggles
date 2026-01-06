import React from "react";
import { NavLink } from "react-router-dom";
import { FaStickyNote, FaBookOpen, FaTrophy, FaUser } from "react-icons/fa";

export default function Sidebar() {
  const links = [
    { name: "Notes", path: "/notes", icon: <FaStickyNote /> },
    { name: "Flashcards", path: "/flashcards", icon: <FaBookOpen /> },
    { name: "Quizzes", path: "/quizzes", icon: <FaTrophy /> },
    { name: "Profile", path: "/profile", icon: <FaUser /> },
  ];

  return (
    <div className="w-64 h-screen bg-white border-r shadow-sm px-5 py-6 flex flex-col">
      <h2 className="text-2xl font-bold mb-8 text-gray-800">Notiq</h2>

      <div className="flex flex-col gap-2">
        {links.map((link) => (
          <NavLink
            key={link.name}
            to={link.path}
            className={({ isActive }) =>
              `flex items-center gap-3 px-4 py-3 rounded-xl text-gray-700 font-medium transition
              hover:bg-gray-100 hover:shadow-sm
              ${isActive ? "bg-gray-100 shadow-sm text-gray-900" : ""}`
            }
          >
            {link.icon}
            <span>{link.name}</span>
          </NavLink>
        ))}
      </div>
    </div>
  );
}
