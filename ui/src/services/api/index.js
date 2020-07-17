import axios from 'axios';

export const fetchGetData = async (url, config) => await axios.get(url, config);
export const fetchPostData = async (url, data, config) => await axios.post(url, data, config);
export const fetchPutData = async (url, data, config) => await axios.put(url, data, config);
export const fetchDeleteData = async (url, config) => await axios.delete(url, config);

export { default as authAPI } from './auth';
