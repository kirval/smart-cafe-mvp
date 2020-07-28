import { from, of } from 'rxjs';
import { combineEpics } from 'redux-observable';
import { switchMap, map, catchError, filter } from 'rxjs/operators';

import { authAPI } from 'API';

import { signIn, signInSuccess, signUp, signUpSuccess, failed } from './';

const signInUser = (action$) =>
  action$.pipe(
    filter(signIn.match),
    switchMap((action) => {
      return from(authAPI.signIn(action.payload)).pipe(
        map((response) => {
          const { data } = response;
          return signInSuccess(data);
        }),
        catchError((e) => of(failed(e)))
      );
    })
  );

const signUpUser = (action$) =>
  action$.pipe(
    filter(signUp.match),
    switchMap((action) => {
      return from(authAPI.signUp(action.payload)).pipe(
        map((response) => {
          const { data } = response;
          return signUpSuccess(data);
        }),
        catchError((e) => of(failed(e)))
      );
    })
  );

export default combineEpics(signInUser, signUpUser);
