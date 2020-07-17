import {fetchGetData, fetchPostData} from './';

const TEST = '/test';
const USER = '/user';

export const testGet = async () => {
	return await fetchGetData(TEST, {withCredentials: true});
};
export const testPost = async (value) => {
	return await fetchPostData(TEST, { value }, {withCredentials: true});
};

export const testUserPost = async (value) => {
  return await fetchPostData(USER, { email: "user1@email.com", password: "password" }, {withCredentials: true});
};
