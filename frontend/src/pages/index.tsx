import Head from "next/head";
import { FormEvent, useEffect, useState } from "react";
import { AxiosError } from "axios";
import api from "../api/api";
import Login from "../layouts/login";

export default function Home() {
  return (
    <div className="w-full h-screen bg-gradient-to-tr from-slate-900 to-gray-800">
      <Head>
        <title>URL Shortener | Login</title>
      </Head>
      <Login />
    </div>
  );
}
