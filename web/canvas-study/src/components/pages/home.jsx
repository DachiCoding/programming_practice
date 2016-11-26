import React from 'react';
import { connect } from 'react-redux';
import { logIn } from 'actions/login-actions';

const HomePage = function HomePage(props) {

  return {
    props,

    login() {
      this.props.dispatch(logIn());
    },

    renderStuff() {
      const user = this.props.login.toJS().user;
      
      if (!user) {
        return null;
      }

      return <p>Hello {user.name}</p>

    },

    render() {
      return (
        <div>
          <h1>Login</h1>
          <button onClick={this.login.bind(this)}>Click Meeee</button>
          {this.renderStuff()}
        </div>
      )
    }
  }
}

function mapStateToProps(state) {
  return {
    home: state.home,
    login: state.login
  }
}

export default connect(mapStateToProps)(HomePage);
