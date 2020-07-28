import { createSelector } from '@reduxjs/toolkit';

export const selectAuthState = (state) => state.auth;
export const selectAuthUser = createSelector(
  selectAuthState,
  (state) => state.user
);
export const selectAuthFetchStatus = createSelector(
  selectAuthState,
  (state) => state.fetching
);
export const selectAuthLoggingIn = createSelector(
  selectAuthState,
  (state) => state.loggingIn
);
