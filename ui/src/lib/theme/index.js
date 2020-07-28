import { createMuiTheme } from '@material-ui/core/styles';

import lightTheme from './lightTheme';
import darkTheme from './darkTheme';

const themes = {
  light: lightTheme,
  dark: darkTheme,
};

const changeMetaThemeColor = (color) => {
  const el = document.querySelector('meta[name="theme-color"]');
  if (el && color) {
    el.setAttribute('content', color);
  }
};

export default (theme) => {
  const selectTheme = themes[theme] || lightTheme;

  const usedTheme = createMuiTheme(selectTheme);
  changeMetaThemeColor(usedTheme.palette.primary.main);

  return usedTheme;
};
