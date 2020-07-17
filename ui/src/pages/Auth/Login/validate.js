import { FIELDS } from './config.js';
import { regExp } from 'constants/index';

const { USERNAME, PASSWORD } = FIELDS;
const { REGEX_EMAIL, REGEX_PASSWORD } = regExp;

export default (values) => {
	const errors = {};
	const requiredFields = [USERNAME, PASSWORD];
	requiredFields.forEach((field) => {
		if (!values[field]) {
			errors[field] = 'login.required';
		}
	});
	if (values[USERNAME] && !REGEX_EMAIL.test(values[USERNAME])) {
		errors[USERNAME] = 'login.email';
	}
	if (values[PASSWORD] && !REGEX_PASSWORD.test(values[PASSWORD])) {
		// errors[PASSWORD] = 'login.password';
	}
	return errors;
};
