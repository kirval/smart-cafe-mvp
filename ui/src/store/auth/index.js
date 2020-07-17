import { createSlice } from '@reduxjs/toolkit';
import * as reducers from './authReducer';

const initialState = {
	loggingIn: false,
	fetching: false,
	user: null,
};

const slice = createSlice({
	name: 'Auth',
	initialState,
	reducers,
});

const { actions, reducer } = slice;

export const { singIn, singInSuccess, failed } = actions;

export * from './authHook';
export { default as authEpic } from './authEpic';
export default reducer;
