import { createGlobalStyle } from 'styled-components';

export const GlobalStyles = createGlobalStyle`
  *,
  *::after,
  *::before {
    font-family: Montserrat, Helvetica, Arial, sans-serif;
    letter-spacing: 0.05rem
  }

  body {
    transition: all 0.25s linear;

    & #root {
      position: absolute;
      top: 0;
      bottom: 0;
      left: 0;
      right: 0;
    }
  }`;
