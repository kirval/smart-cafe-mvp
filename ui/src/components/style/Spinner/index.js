import React from 'react';
import styled, { keyframes } from 'styled-components';

const animate = keyframes`
	0% {
    	transform: perspective(120px) rotateX(0deg) rotateY(0deg);
	} 50% {
 		transform: perspective(120px) rotateX(-180.1deg) rotateY(0deg);
	} 100% {
 		transform: perspective(120px) rotateX(-180deg) rotateY(-179.9deg);
	}
`;

const SpinnerContainer = styled.div`
	&.fullScreen {
		position: absolute;
		top: 0;
		left: 0;
		bottom: 0;
		right: 0;
		display: flex;
		justify-content: center;
		align-items: center;
	}
`;

const Spinner = styled.div`
	width: 40px;
	height: 40px;
	background-color: ${({ theme }) => theme.palette.primary.main};

	margin: 18px auto;
	animation: ${animate} 1.2s infinite ease-in-out;
`;

const S = ({ fullScreen, ...props }) => (
	<SpinnerContainer className={fullScreen ? 'fullScreen' : ''}>
		<Spinner {...props} />
	</SpinnerContainer>
);

export default S;
