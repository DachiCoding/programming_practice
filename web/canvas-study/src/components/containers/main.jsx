import React from 'react';
import { createStore, combineReducers, applyMiddleware } from 'redux';
import { Provider } from 'react-redux';
import thunkMiddleware from 'redux-thunk';
import * as reducers from '../../reducers/index';
import Router from 'react-router';

const reducer = combineReducers(reducers);
const createStoreWithMiddleware = applyMiddleware(
  thunkMiddleware)(createStore);

const store = createStoreWithMiddleware(reducer);

const MainContainer = function (props) {
  return {
    props,

    render() {
      return (
        <Provider store={store}>
          {() => <Router.RouteHandler {...this.props} />}
        </Provider>
      )
    }
  }
};

export default MainContainer;
