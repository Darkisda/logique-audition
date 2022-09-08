import Login from "../layouts/login";
import { useCookies } from "react-cookie";
import Profile from "../layouts/profile";
import { useEffect, useState } from "react";

export default function Home() {
  const [cookies] = useCookies(["user-id"]);

  return (
    <div className="w-full h-screen bg-blackvariant">
      {cookies["user-id"] ? <Profile /> : <Login />}
    </div>
  );
}
