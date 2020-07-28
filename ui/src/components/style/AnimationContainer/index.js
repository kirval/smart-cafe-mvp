import React from 'react';

import StyledContainer from './StyledContainer.styled';

const AnimationContainer = ({ children }) => {
  return (
    <StyledContainer>
      <div className="area">
        <ul className="circles">
          <li />
          <li />
          <li />
          <li />
          <li />
          <li />
          <li />
          <li />
          <li />
          <li />
        </ul>
      </div>
      <div className="content">{children}</div>
    </StyledContainer>
  );
};

export default AnimationContainer;
