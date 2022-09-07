import Head from "next/head";
import Register from "../layouts/register";

export default function SignUp() {
  return (
    <div className="w-full h-screen bg-gradient-to-tr from-slate-900 to-gray-800">
      <Head>
        <title>URL Shortener | Registro</title>
      </Head>
      <Register />
    </div>
  )
}