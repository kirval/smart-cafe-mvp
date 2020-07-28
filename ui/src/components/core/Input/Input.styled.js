import styled from 'styled-components';
import React from 'react';

import InputMUI from '@material-ui/core/TextField';

const Input = (props) => <InputMUI {...props} />;

const StyleInput = styled(Input)`
  & .MuiInputLabel-shrink {
    font-weight: 600;
  }
`;

export default StyleInput;
