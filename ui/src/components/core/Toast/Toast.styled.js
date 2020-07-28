import styled from 'styled-components';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Toast = styled(ToastContainer)`
  .Toastify__toast--info {
    background: rgb(51, 102, 255);
  }
  .Toastify__toast--success {
    background: rgb(51, 187, 102);
  }
  .Toastify__toast--warning {
    background: rgb(254, 255, 20);
  }
  .Toastify__toast--error {
    background: rgb(255, 102, 102);
  }
`;

export default Toast;
