export const singIn = (state) => {
	state.fetching = true;
};

export const singInSuccess = (state, action) => {
	state.user = action.payload;
	state.fetching = false;
};

export const failed = (state) => {
    state.fetching = false;
};
