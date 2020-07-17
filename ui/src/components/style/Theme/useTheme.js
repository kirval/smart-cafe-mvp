/* eslint-disable react-hooks/exhaustive-deps */
import { useContext } from 'react';
import { ThemeContext } from './';

const useTheme = () => {
	const [theme, setTheme] = useContext(ThemeContext);

	const changeTheme = (theme) => {
		localStorage.setItem('theme', theme);
		setTheme(theme);
	};

	const toggleTheme = () => {
		changeTheme(theme === 'light' ? 'dark' : 'light');
	};

	return [theme, toggleTheme];
};

export default useTheme;
