import axios from 'axios';

const BASE_URL = process.env.API_URL || '';

export default (dispatch) => {
	axios.defaults.baseURL = BASE_URL;
};
