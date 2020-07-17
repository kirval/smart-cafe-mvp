import React, { useState, useEffect } from 'react';
import { useTranslation } from 'react-i18next';

import { Button, SvgIcon, Menu, MenuItem } from '@material-ui/core';

import { ReactComponent as FlagRU } from 'assets/icons/flags/ru.svg';
import { ReactComponent as FlagEN } from 'assets/icons/flags/en.svg';

const languages = {
	ru: {
		icon: FlagRU,
	},
	en: {
		icon: FlagEN,
	},
};

const ToggleLanguage = () => {
	const [anchorEl, setAnchorEl] = useState(null);
	const { i18n } = useTranslation();
	const [lng, setLng] = useState(i18n.language.split('-')[0]);

	useEffect(() => {
		setLng(i18n.language.split('-')[0]);
	}, [i18n.language]);

	const handleOpen = (event) => {
		setAnchorEl(event.currentTarget);
	};

	const handleClick = (language) => {
		setAnchorEl(null);
		if (language !== lng) {
			i18n.changeLanguage(language);
		}
	};

	const handleClose = () => {
		setAnchorEl(null);
	};

	const SelectFlag = languages[lng].icon;
	return (
		<>
			<Button onClick={handleOpen} style={{ minWidth: '56px' }}>
				<SvgIcon>
					<SelectFlag />
				</SvgIcon>
			</Button>
			<Menu id="simple-menu" anchorEl={anchorEl} keepMounted open={Boolean(anchorEl)} onClose={handleClose}>
				{Object.keys(languages)
					.sort((item) => (item === lng ? -1 : 0))
					.map((item) => {
						const Flag = languages[item].icon;
						return (
							<MenuItem onClick={() => handleClick(item)} key={item}>
								<SvgIcon>
									<Flag />
								</SvgIcon>
							</MenuItem>
						);
					})}
			</Menu>
		</>
	);
};

export default ToggleLanguage;
