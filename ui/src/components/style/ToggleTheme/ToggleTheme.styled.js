import styled from 'styled-components';

const ToggleTheme = styled.span`
	position: relative;
	background-color: transparent;
	border: 0;
	display: inline-flex;
	cursor: pointer;
	justify-content: center;
	width: 40px;
	height: 40px;
	outline: none;
	transition: opacity 0.3s ease;
	overflow: hidden;
	transform: scale(0.6);

	.icon-light {
		position: absolute;
		height: 28px;
		width: 28px;
		border-radius: 50%;
		transition: box-shadow 0.25s linear;
		top: 0;
		left: -3px;
		box-shadow: 6px 6px 0 0 ${({ theme }) => theme.palette.text.primary};
		&::before {
			content: '';
			display: block;
		}
	}

	.icon-dark {
		width: 16px;
		height: 16px;
		background-color: ${({ theme }) => theme.palette.text.primary};
		border-radius: 50%;
		position: absolute;
		top: 12px;
		transition: background-color 0.25s linear;
		&::before {
			content: '';
			display: block;
			width: 16px;
			height: 16px;
			border-radius: 50%;
			transition: box-shadow 0.25s linear;

			box-shadow: -15px 0 0 -5px ${({ theme }) => theme.palette.text.primary},
				0 -15px 0 -5px ${({ theme }) => theme.palette.text.primary},
				-11px -11px 0 -5px ${({ theme }) => theme.palette.text.primary},
				-11px 11px 0 -5px ${({ theme }) => theme.palette.text.primary},
				0 15px 0 -5px ${({ theme }) => theme.palette.text.primary},
				11px -11px 0 -5px ${({ theme }) => theme.palette.text.primary},
				15px 0 0 -5px ${({ theme }) => theme.palette.text.primary},
				11px 11px 0 -5px ${({ theme }) => theme.palette.text.primary};
		}
	}
`;

export default ToggleTheme;
