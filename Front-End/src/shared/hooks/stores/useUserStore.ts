import { create } from "zustand";

type Role = "ADMIN" | "PL" | "DEV" | "TESTER";

export const useUserStore = create<User.UserStore>((set, get) => ({
  //State
  isSignIn: localStorage.getItem("isSignIn") === "true" || false,
  userId: localStorage.getItem("userId") ? parseInt(localStorage.getItem("userId")!) : -1,
  role: localStorage.getItem("role") as Role || "ADMIN",

  //Set function
  signIn: (data) => {
    localStorage.setItem("isSignIn", "true");
    localStorage.setItem("userId", data.id.toString());
    localStorage.setItem("role", data.role);
    set(() => ({ isSignIn: true, userId: data.id, role: data.role }));
  },

  signOut: () => {
    localStorage.removeItem("isSignIn");
    localStorage.removeItem("userId");
    localStorage.removeItem("role");
    set(() => ({ isSignIn: false, userId: -1, role: "ADMIN" }));
  },

  isAdmin: () => get().role === "ADMIN",
  isPl: () => get().role === "PL",
  isDev: () => get().role === "DEV",
  isTester: () => get().role === "TESTER",
}));
