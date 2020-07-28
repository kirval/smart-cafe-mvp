import React from 'react';
import IconButton from '@material-ui/core/IconButton';
import { useTheme } from '../Theme';

import ToggleTheme from './ToggleTheme.styled';

const Toggle = () => {
  const [theme, toggleTheme] = useTheme();
  const isLight = theme === 'light';

  const labelText = isLight ? 'dark' : 'light';

  return (
    <IconButton size="small" onClick={toggleTheme}>
      <ToggleTheme
        aria-label={`Activate ${labelText} mode`}
        title={`Activate ${labelText} mode`}
      >
        <div className={`icon-${theme}`} />
      </ToggleTheme>
    </IconButton>
  );
};

export default Toggle;
