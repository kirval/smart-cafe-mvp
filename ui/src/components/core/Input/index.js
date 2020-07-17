import React from 'react';

import StyledInput from './Input.styled';

const Input = (props) => {
	return (
		<StyledInput
			InputLabelProps={{
				shrink: true,
			}}
			{...props}
		/>
	);
};

export default Input;
