import React from 'react';

import {  SvgIcon } from '@material-ui/core';

import { ReactComponent as AppLogo } from 'assets/icons/logo/coffeecup.svg';

const Logo = () => {
	return (
		<>
				<SvgIcon fontSize="large" color="action">
					<AppLogo />
				</SvgIcon>
		</>
	);
};

export default Logo;
