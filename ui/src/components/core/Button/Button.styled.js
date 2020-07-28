import styled from 'styled-components';
import React from 'react';

import ButtonMUI from '@material-ui/core/Button';

const Button = (props) => (
  <ButtonMUI
    classes={{
      containedPrimary: 'containedPrimary',
      label: 'label',
      text: 'text',
    }}
    {...props}
  />
);

const StyleButton = styled(Button)`
  border-radius: 16px;
  font-weight: 700;

  &.text {
    font-weight: 600;
  }

  & .label {
    z-index: 1;
  }

  &.containedPrimary {
    &:hover {
      background-color: ${({ theme }) => theme.palette.primary.main};
      overflow: hidden;
      &:before {
        content: ' ';
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        background-color: ${({ theme }) => theme.palette.action.hover};
      }
    }
  }
`;

export default StyleButton;
