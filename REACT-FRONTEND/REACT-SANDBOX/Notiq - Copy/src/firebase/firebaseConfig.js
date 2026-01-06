// Replace this with your config from Firebase
import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import { getFirestore } from "firebase/firestore";
import { getStorage } from "firebase/storage";

const firebaseConfig = {
  apiKey: "AIzaSyDDm9o_MuX7nKc2NtINDzi0WZKo6IqK_zM",
  authDomain: "notiq-8990b.firebaseapp.com",
  projectId: "notiq-8990b",
  storageBucket: "notiq-8990b.firebasestorage.app",
  messagingSenderId: "685616456436",
  appId: "1:685616456436:web:2cbd255f24725dd8dc74a1",
  measurementId: "G-W4B8EQFTDY"
};

const app = initializeApp(firebaseConfig);

export const auth = getAuth(app);
export const db = getFirestore(app);
export const storage = getStorage(app);
