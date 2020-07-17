import { configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';

import * as reducers from './rootReducer';
import epicMiddleware, { rootEpic } from './rootEpic';

const middleware = getDefaultMiddleware({
	immutableCheck: false,
	serializableCheck: false,
	thunk: false,
});

export const store = configureStore({
	reducer: { ...reducers },
	middleware: [...middleware, epicMiddleware],
	devTools: process.env.NODE_ENV !== 'production',
});

epicMiddleware.run(rootEpic);
