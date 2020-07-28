import React from 'react';
import { toast } from 'react-toastify';

import Toast from './Toast.styled';

export const showToast = ({ type, message }) => {
  switch (type) {
    case 'success':
      toast.success(message);
      break;
    case 'warn':
      toast.warn(message);
      break;
    case 'error':
      toast.error(message);
      break;
    default:
      toast.info(message);
  }
};

const ToastAnimated = () => {
  return <Toast />;
};

export default ToastAnimated;
