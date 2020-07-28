import { lazy } from 'react';
import Routes from './Routes';

export const Login = lazy(() => import('./Auth/Login'));
export const Registration = lazy(() => import('./Auth/Registration'));
export const Main = lazy(() => import('components/other/Main'));

export default Routes;
