import React from 'react';

import StyledButton from './Button.styled';

const Button = (props) => {
  return <StyledButton disableElevation={true} {...props} />;
};

export default Button;
