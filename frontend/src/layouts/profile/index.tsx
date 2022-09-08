import Head from "next/head";
import { FormEvent, useEffect, useState } from "react";
import { useCookies } from "react-cookie";
import api from "../../api/api";

type URLEntity = {
  _id: string;
  originURL: string;
  generateURL: string;
  user_id: string;
  created_at: string;
};

export default function Profile() {
  const [originURL, setOriginURL] = useState("");
  const [baseURL, setBaseURL] = useState("");

  const [URLs, setURLS] = useState<URLEntity[]>();

  async function handleFetchURLS() {
    const response = await api.get<URLEntity[]>("/url");

    setURLS(response.data);
  }

  useEffect(() => {
    handleFetchURLS();
  }, []);

  async function handleSubmit(e: FormEvent) {
    e.preventDefault();

    try {
      await api.post(
        "/url",
        {
          originURL,
          baseURL,
        },
        {
          withCredentials: true,
        }
      );

      await handleFetchURLS();
    } catch (error) {}
  }

  return (
    <div>
      <Head>
        <title>URL Shortener | Perfil</title>
      </Head>
      <div className="container mx-auto h-full py-16 max-w-4xl">
        <div className="w-full text-white">
          <h1 className="text-4xl font-bold tracking-wide">Perfil</h1>
          <p className="text-lg text-gray-400">
            Aqui é o lugar onde você gerencia todos os seus links.
          </p>
        </div>

        <div className="w-full mt-12">
          <h1 className="text-2xl font-semibold text-white">
            Adicionar um novo link
          </h1>
          <form
            onSubmit={handleSubmit}
            className="flex my-2 flex-col gap-4 items-center justify-center"
          >
            <div className="w-full flex flex-row gap-4 items-center justify-center">
              <fieldset className="flex w-full flex-col gap-2">
                <label htmlFor="" className="text-lg text-gray-400">
                  Domínio da url encurtada
                </label>
                <input
                  type="text"
                  value={baseURL}
                  onChange={(e) => setBaseURL(e.target.value)}
                  className="rounded-lg border border-white bg-white text-lg px-2"
                />
              </fieldset>
              <fieldset className="flex w-full flex-col gap-2">
                <label htmlFor="" className="text-lg text-gray-400">
                  URL:
                </label>
                <input
                  type="text"
                  value={originURL}
                  onChange={(e) => setOriginURL(e.target.value)}
                  className="rounded-lg border border-white bg-white text-lg px-2"
                />
              </fieldset>
            </div>
            <button
              type="submit"
              className="w-full text-xl font-semibold rounded-lg bg-indigo-700 text-white transition-all duration-200 hover:bg-indigo-800"
            >
              Criar
            </button>
          </form>
        </div>
        <div className="w-full my-8">
          <h1 className="text-2xl font-semibold text-white">Suas URL's</h1>
          {URLs?.map((url) => (
            <div
              key={url._id}
              className="w-full my-4 bg-white rounded-lg p-1 flex items-center flex-row justify-around"
            >
              <p className="text-lg">
                <span className="font-bold">URL Compactada:</span>{" "}
                <a
                  href={url.originURL}
                  target="_blank"
                  rel="noopener noreferrer"
                  className="underline"
                >
                  {url.generateURL}
                </a>
              </p>
              <p>
                <span className="font-bold">URL Original:</span> {url.originURL}
              </p>
              <p>
                <span className="font-bold">Data de Criação:</span>{" "}
                {url.created_at}
              </p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
