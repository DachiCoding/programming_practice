import React from 'react';
import router from './router';

document.addEventListener('DOMContentLoaded', () => {
  router.run((Handler, state) => {
    React.render(
      <Handler params={state.params} query={state.query} />,
      document.querySelector('#app')
    );
  });
});
