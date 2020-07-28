import { API_ROUTES } from 'constpack';
import { client } from 'lib';
import qs from 'qs';

const signIn = async (props) => {
  const payload = qs.stringify(props);
  const config = {
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded',
    },
  };
  return await client.post(API_ROUTES.LOGIN, payload, config);
};

const signUp = async (props) => {
  return await client.post(API_ROUTES.REGISTRATION, props);
};

export default {
  signIn,
  signUp,
};
