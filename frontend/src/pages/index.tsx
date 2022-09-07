import Head from "next/head";
import { useState } from "react";

export default function Home() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  return (
    <div className="w-full h-screen bg-gradient-to-tr from-slate-900 to-gray-800">
      <Head>
        <title>URL Shortener | Login</title>
      </Head>
      <div className="container mx-auto h-full max-w-4xl">
        <main className="w-full h-full flex items-center justify-center content-center flex-col p-2">
          <div className="w-10/12 md:w-4/6 lg:w-2/4 h-3/6 lg:h-2/6 rounded-lg bg-white shadow p-4">
            <h1 className="text-3xl font-thin">Login</h1>
            <form>
              <fieldset className="flex flex-col gap-2 my-2">
                <label htmlFor="email-login" className="text-lg font-thin">
                  Email:
                </label>
                <input
                  value={email}
                  onChange={(e) => setEmail(() => e.target.value)}
                  type="email"
                  name="email-login"
                  id="email-login"
                  className="border border-gray-300 rounded-lg text-lg px-2 font-extralight outline-gray-200"
                />
              </fieldset>
              <fieldset className="flex flex-col gap-2 my-2">
                <label htmlFor="password-login" className="text-lg font-thin">
                  Password:
                </label>
                <input
                  value={password}
                  onChange={(e) => setPassword(() => e.target.value)}
                  type="password"
                  name="password-login"
                  id="password-login"
                  className="border border-gray-300 rounded-lg text-lg px-2 font-extralight outline-gray-200"
                />
              </fieldset>
              <div className="w-full my-4 flex gap-2 items-end justify-end flex-col">
                <button
                  type="submit"
                  className="
                  border-blue-500 border rounded-lg px-6 text-lg text-blue-500 transition-all duration-200
                  hover:bg-blue-500 hover:text-white
                  "
                >
                  Logar
                </button>
                <a href="">Ainda não possui uma conta?</a>
              </div>
            </form>
          </div>
        </main>
      </div>
    </div>
  );
}
