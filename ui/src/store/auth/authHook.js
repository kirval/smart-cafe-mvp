import { useSelector } from 'react-redux';

import * as selects from './authSelect';

export const useAuthUser = () => useSelector(selects.selectAuthUser);
export const useAuthFetchStatus = () =>
  useSelector(selects.selectAuthFetchStatus);
export const useAuthLoggingIn = () => useSelector(selects.selectAuthLoggingIn);
