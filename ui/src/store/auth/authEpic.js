import { from, of } from 'rxjs';
import { combineEpics } from 'redux-observable';
import { switchMap, map, catchError, filter } from 'rxjs/operators';

import { authAPI } from 'services/api';

import { singIn, singInSuccess, failed } from './';

console.log("authAPI", authAPI)
const singInUser = (action$) =>
	action$.pipe(
		filter(singIn.match),
		switchMap((action) => {
			return from(authAPI.signIn(action.payload)).pipe(
				map((response) => {
					console.log('response', response);
					const { data } = response;
					return singInSuccess(data);
				}),
				catchError((e) => of(failed(e))),
			);
		}),
	);

export default combineEpics(singInUser);
