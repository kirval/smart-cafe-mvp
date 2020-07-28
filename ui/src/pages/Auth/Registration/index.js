import React, { useCallback } from 'react';
import { reduxForm } from 'redux-form';
import { useDispatch } from 'react-redux';
import { Link as LinkRouter } from 'react-router-dom';
import { useTranslation } from 'react-i18next';

import {
  ValidationInput,
  Button,
  Grid,
  Link,
  Typography,
} from 'components/core';
import {
  AnimationContainer,
  ToggleLanguage,
  ToggleTheme,
  Logo,
} from 'components/style';

import Container from './Container.styled';

import { FORMS, APP_ROUTES } from 'constpack';
import { signUp } from 'store/auth';

import validate from './validate';
import { FIELDS } from './config.js';

const { USERNAME, PASSWORD } = FIELDS;

const Registration = (props) => {
  const { t } = useTranslation('pages.registration');
  const dispatch = useDispatch();

  const { handleSubmit, anyTouched, valid } = props;

  const onSubmit = handleSubmit(
    useCallback(
      (user) => {
        dispatch(signUp(user));
      },
      [dispatch]
    )
  );

  return (
    <AnimationContainer>
      <Container maxWidth="xs">
        <Grid container direction="column" className="registration-container">
          <Grid container>
            <Grid item container xs={6} alignItems="center">
              <Logo />
            </Grid>
            <Grid xs={6} item container justify="flex-end" alignItems="center">
              <ToggleLanguage />
              <ToggleTheme />
            </Grid>
          </Grid>

          <div className="spacing" />
          <Grid container justify="center">
            <Typography
              variant="h5"
              gutterBottom
              style={{ textTransform: 'uppercase' }}
            >
              {t('text.title')}
            </Typography>
          </Grid>
          <Grid container>
            <form onSubmit={onSubmit}>
              <ValidationInput
                label={t('input.phone.label')}
                placeholder={t('input.phone.placeholder')}
                className="input"
                type="tel"
                name={USERNAME}
              />
              <ValidationInput
                label={t('input.password.label')}
                placeholder={t('input.password.placeholder')}
                className="input"
                type="password"
                name={PASSWORD}
              />
              <Button
                fullWidth
                color="primary"
                variant="contained"
                size="large"
                className="submit-button"
                type="submit"
                onClick={onSubmit}
                disabled={!anyTouched || !valid}
              >
                {t('action.button.signUp')}
              </Button>
            </form>
          </Grid>
          <Grid container justify="center">
            <Link color="primary">{t('action.link.forgotPassword')}</Link>
          </Grid>
          <div className="spacing" />
          <Grid item>
            <Typography
              variant="body2"
              gutterBottom
              align="center"
              component="div"
            >
              {t('text.yesAccount')}
            </Typography>
          </Grid>
          <Grid item>
            <Button
              fullWidth
              color="primary"
              component={LinkRouter}
              to={APP_ROUTES.LOGIN}
            >
              {t('action.button.signIn')}
            </Button>
          </Grid>
        </Grid>
      </Container>
    </AnimationContainer>
  );
};

export default reduxForm({
  form: FORMS.REGISTRATION_FORM,
  validate,
})(Registration);
