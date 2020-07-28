import styled from 'styled-components';
import ContainerMUI from '@material-ui/core/Container';

const Container = styled(ContainerMUI)`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  padding: ${({ theme }) => theme.spacing(2)}px;

  .spacing {
    flex: 1;
  }

  .login-container {
    flex-direction: column;
    flex-wrap: nowrap;
    max-height: 600px;
    height: 100%;
  }

  .input {
    margin: ${({ theme }) => theme.spacing(2)}px 0;
  }

  .submit-button {
    margin: ${({ theme }) => theme.spacing(2)}px 0;
  }
`;

export default Container;
