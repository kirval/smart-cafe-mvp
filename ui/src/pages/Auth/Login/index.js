import React, {useState} from 'react';
import {reduxForm} from 'redux-form';
import {Link as LinkRouter} from 'react-router-dom';
import {useTranslation} from 'react-i18next';

import {Button, Grid, Input, Link, Typography, ValidationInput} from 'components/core';
import {AnimationContainer, Logo, ToggleLanguage, ToggleTheme} from 'components/style';

import Container from './Container.styled';

import {appRoutes, forms} from 'constants/index';

import validate from './validate';
import {FIELDS} from './config.js';
import {singIn} from 'store/auth';
import {testGet} from 'services/api/test';
import {useDispatch} from 'react-redux';
import {testUserPost} from "../../../services/api/test";

const { USERNAME, PASSWORD } = FIELDS;

const Login = (props) => {
	const [value, setValue] = useState('');
	const { t } = useTranslation('pages.login');
	const dispatch = useDispatch();
	const { handleSubmit, anyTouched, valid } = props;

	const onSubmit = handleSubmit(async (user) => {
		console.log(user);
		const kek = await dispatch(singIn(user));
		console.log('onSubmit -> kek', kek);
	});

	return (
		<AnimationContainer>
			<Container maxWidth="xs">
				<Grid container direction="column" className="login-container">
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
						<Typography variant="h5" gutterBottom style={{ textTransform: 'uppercase' }}>
							{t('text.title')}
						</Typography>
					</Grid>
					<Grid container>
						<form onSubmit={onSubmit}>
							<ValidationInput
								label={t('input.email.label')}
								placeholder={t('input.email.placeholder')}
								className="input"
								type="email"
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
								{t('action.button.signIn')}
							</Button>
						</form>
					</Grid>
					<Grid container justify="center">
						<Link color="primary">{t('action.link.forgotPassword')}</Link>
					</Grid>
					<div>
						<Input
							label={'value'}
							placeholder={'value'}
							className="input"
							fullWidth
							value={value}
							onChange={(e) => setValue(e.target.value)}
						/>
						<div style={{display:'flex', justifyContent: 'space-around'}}>
							<Button
								color="primary"
								variant="contained"
								onClick={async () => {
									console.log('Login -> value', value);
									const { status, data } = await testUserPost(value);
									console.log('Login -> status, data', status, data);
								}}
							>
								POST
							</Button>
							<Button
								color="primary"
								variant="contained"
								onClick={async () => {
									const { status, data } = await testGet();
									console.log('Login -> status, data', status, data);
								}}
							>
								GET
							</Button>
						</div>
					</div>
					<div className="spacing" />
					<Grid item>
						<Typography variant="body2" gutterBottom align="center" component="div">
							{t('text.noAccount')}
						</Typography>
					</Grid>
					<Grid item>
						<Button fullWidth color="primary" component={LinkRouter} to={appRoutes.REGISTRATION}>
							{t('action.button.signUp')}
						</Button>
					</Grid>
				</Grid>
			</Container>
		</AnimationContainer>
	);
};

export default reduxForm({
	form: forms.LOGIN_FORM,
	validate,
})(Login);
