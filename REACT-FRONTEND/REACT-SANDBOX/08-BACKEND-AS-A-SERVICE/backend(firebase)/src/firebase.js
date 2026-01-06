// firebase.js
import { initializeApp } from "firebase/app";
import { 
  getAuth, 
  GoogleAuthProvider, 
  signInWithPopup, 
  signOut 
} from "firebase/auth";
import {
  getFirestore,
  collection,
  doc,
  addDoc,
  getDoc,
  getDocs,
  query,
  orderBy,
  onSnapshot,
  updateDoc,
  deleteDoc,
  serverTimestamp,
  arrayUnion,
  arrayRemove
} from "firebase/firestore";

// Firebase config
// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyC4tN8G5YTz28J08VWa-DmOT0alVtBCfWg",
  authDomain: "blog-app-47599.firebaseapp.com",
  projectId: "blog-app-47599",
  storageBucket: "blog-app-47599.firebasestorage.app",
  messagingSenderId: "55456870603",
  appId: "1:55456870603:web:8f5f0826aa064ec6126b4e",
  measurementId: "G-JW8GGF0X8L"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
const provider = new GoogleAuthProvider();
const db = getFirestore(app);

// Auth helpers
const signInWithGoogle = () => signInWithPopup(auth, provider);
const signOutUser = () => signOut(auth);

// Firestore helpers
const postsCollection = collection(db, "posts");

export {
  auth,
  provider,
  signInWithGoogle,
  signOutUser,
  db,
  postsCollection,
  collection,
  doc,
  addDoc,
  getDoc,
  getDocs,
  query,
  orderBy,
  onSnapshot,
  updateDoc,
  deleteDoc,
  serverTimestamp,
  arrayUnion,
  arrayRemove
};
