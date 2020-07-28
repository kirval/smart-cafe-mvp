import axios from 'axios';

import { API_BASE_URL, API_REQUEST_TIMEOUT } from 'constpack';

class Client {
  #axios = null;

  constructor() {
    this.#axios = axios.create({
      baseURL: API_BASE_URL,
      timeout: API_REQUEST_TIMEOUT,
      withCredentials: true,
      headers: {
        'Content-Type': 'application/json',
      },
    });
  }

  async get(path, config = {}) {
    return await this.#axios.get(path, config);
  }

  async post(path, payload = {}, config = {}) {
    return await this.#axios.post(path, payload, config);
  }

  async put(path, payload = {}, config = {}) {
    return await this.#axios.put(path, payload, config);
  }

  async delete(path, config = {}) {
    return await this.#axios.delete(path, config);
  }
}

const client = new Client();

export default client;
