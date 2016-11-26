import React from 'react';
import { Route } from 'react-router';

// Containers
import MainContainer from 'components/containers/main';

// Pages
import Home from 'components/pages/home.jsx';

export default (
  <Route handler={MainContainer}>
    <Route name='home' path='/' handler={Home} />
    <Route name='blog' path='/blog' handler={Home} />
  </Route>
);
