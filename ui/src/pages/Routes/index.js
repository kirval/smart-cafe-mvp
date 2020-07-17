//TODO:

import React, { Suspense, lazy } from 'react';

import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

import Spinner from 'components/style/Spinner';

const Login = lazy(() => import('../Auth/Login'));
const Registration = lazy(() => import('../Auth/Registration'));
const Main = lazy(() => import('components/other/Main'));

const Routes = () => {
	return (
		<Router>
			<Suspense fallback={<Spinner fullScreen />}>
				<Switch>
					<Route exact path="/">
						<Main />
					</Route>
					<Route path="/login">
						<Login />
					</Route>
					<Route path="/registration">
						<Registration />
					</Route>
				</Switch>
			</Suspense>
		</Router>
	);
};

export default Routes;
