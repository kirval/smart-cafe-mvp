import { combineEpics, createEpicMiddleware } from 'redux-observable';
import { authEpic } from './auth';

export const rootEpic = combineEpics(authEpic);

export default createEpicMiddleware();
