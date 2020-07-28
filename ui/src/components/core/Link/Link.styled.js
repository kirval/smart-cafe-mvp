import styled from 'styled-components';
import React from 'react';

import LinkMUI from '@material-ui/core/Link';

const Link = ({ fullWidth, ...props }) => <LinkMUI {...props} />;

const StyleLink = styled(Link)`
  cursor: pointer;
  font-weight: 600;
  user-select: none;
  display: ${({ fullWidth }) => (fullWidth ? 'inline-block' : 'auto')};
  width: ${({ fullWidth }) => (fullWidth ? '100%' : 'auto')};
  text-align: ${({ fullWidth }) => (fullWidth ? 'center' : 'inherit')};
`;

export default StyleLink;
