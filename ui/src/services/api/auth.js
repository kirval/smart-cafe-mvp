import { fetchPostData } from './';
import { apiRoutes } from 'constants/index';
import qs from 'qs';

export default {
	signIn: async ({ username, password }) => {
		return await fetchPostData(apiRoutes.LOGIN, qs.stringify({ username, password }), {
		  withCredentials: true,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded',
			},
		});
	},
	signUp: async ({ username, password }) => {
		return await fetchPostData(apiRoutes.REGISTRATION, { username, password });
	},
};
