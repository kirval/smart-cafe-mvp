import { Main, Login, Registration } from 'pages';
import { APP_ROUTES } from 'constpack';

const routes = [
  {
    path: [APP_ROUTES.MAIN, APP_ROUTES.HOME],
    page: Main,
    exact: true,
  },
  {
    path: APP_ROUTES.LOGIN,
    page: Login,
    exact: true,
  },
  {
    path: APP_ROUTES.REGISTRATION,
    page: Registration,
    exact: true,
  },
];

export default routes;
