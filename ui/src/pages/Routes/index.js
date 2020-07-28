import React, { Suspense } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

import { routes } from 'lib';
import Spinner from 'components/style/Spinner';

const Routes = () => {
  return (
    <Router>
      <Suspense fallback={<Spinner fullScreen />}>
        <Switch>
          {routes.map(({ path, page, exact }, i) => (
            <Route
              exact={exact}
              path={path}
              component={page}
              key={`${path}_${i}`}
            />
          ))}
        </Switch>
      </Suspense>
    </Router>
  );
};

export default Routes;
