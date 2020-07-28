import { FIELDS } from './config.js';
import { REG_EXP } from 'constpack';

const { USERNAME, PASSWORD } = FIELDS;
const { REGEX_PASSWORD } = REG_EXP;

export default (values) => {
  const errors = {};
  const requiredFields = [USERNAME, PASSWORD];
  requiredFields.forEach((field) => {
    if (!values[field]) {
      errors[field] = 'registration.required';
    }
  });
  if (values[USERNAME] && false) {
    errors[USERNAME] = 'registration.phone';
  }
  if (values[PASSWORD] && !REGEX_PASSWORD.test(values[PASSWORD])) {
    // errors[PASSWORD] = 'registration.password';
  }
  return errors;
};
