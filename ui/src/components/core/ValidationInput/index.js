import React from 'react';
import { Field } from 'redux-form';
import Input from '../Input';
import { useTranslation } from 'react-i18next';

const renderTextField = ({ input, meta, t, ...props }) => {
	const { touched, error, invalid } = meta;
	const errorText = touched && t(error);
	return <Input error={touched && invalid} helperText={errorText} fullWidth {...input} {...props} />;
};

const ValidationInput = (props) => {
	const { t } = useTranslation('error');

	return <Field component={renderTextField} t={t} {...props} />;
};

export default ValidationInput;
