/* eslint-disable react/prop-types */
import React, { useState, useEffect } from 'react';
import { ThemeProvider } from 'styled-components';
import { StylesProvider, ThemeProvider as ThemeProviderMUI } from '@material-ui/styles';
import CssBaseline from '@material-ui/core/CssBaseline';

import getTheme from 'services/theme';
import { GlobalStyles } from './global.styled';

const ThemeContext = React.createContext([]);

const Theme = ({ children }) => {
	const [theme, setTheme] = useState('light');
	const [componentMounted, setComponentMounted] = useState(false);

	useEffect(() => {
		const localTheme = localStorage.getItem('theme');

		const systemTheme =
			localTheme || (window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches) ? 'dark' : 'light';
		setTheme(localTheme || systemTheme || 'light');
		setComponentMounted(true);
	}, []);

	const themeObject = getTheme(theme);

	return (
		<StylesProvider injectFirst>
			<ThemeContext.Provider value={[theme, setTheme, setComponentMounted]}>
				<ThemeProviderMUI theme={themeObject}>
					<ThemeProvider theme={themeObject}>
						<CssBaseline />
						<GlobalStyles />
						{componentMounted ? children : null}
					</ThemeProvider>
				</ThemeProviderMUI>
			</ThemeContext.Provider>
		</StylesProvider>
	);
};

export default Theme;
export { ThemeContext };
export { default as useTheme } from './useTheme';
