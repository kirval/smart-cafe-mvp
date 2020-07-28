export const signIn = (state) => {
  state.fetching = true;
};

export const signInSuccess = (state) => {
  state.fetching = false;
  state.loggingIn = true;
};

export const signUp = (state) => {
  state.fetching = true;
};

export const signUpSuccess = (state) => {
  state.fetching = false;
};

export const failed = (state) => {
  state.fetching = false;
};
