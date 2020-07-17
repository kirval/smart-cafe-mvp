import * as React from 'react';
import { Provider } from 'react-redux';
import { I18nextProvider } from 'react-i18next';
import { store } from 'store';
import i18n from 'translations';

import Theme from '../../style/Theme';
import ToastAnimated from '../../core/Toast';

import Routes from 'pages/Routes';

import initApplication from 'utils/initApplication';

initApplication(store.dispatch);

const App = () => (
	<Provider store={store}>
		<I18nextProvider i18n={i18n}>
			<Theme>
				<ToastAnimated />
				<Routes />
			</Theme>
		</I18nextProvider>
	</Provider>
);

export default App;
