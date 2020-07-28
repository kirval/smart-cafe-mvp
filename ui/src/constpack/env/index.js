const API_INFO_URL = {
  production: process.env.API_BASE_URL_PRODUCTION ?? '',
  development: process.env.API_BASE_URL_DEVELOPMENT ?? '',
};

// Server Stage
export const SERVER_STAGE = process.env.NODE_ENV;

// Server URL Info
export const API_BASE_URL = API_INFO_URL[SERVER_STAGE];
export const API_REQUEST_TIMEOUT = process.env.API_REQUEST_TIMEOUT ?? 5000;
