import React, { Component, PropTypes } from 'react';
import Header from './header/header';
import styles from './style/10.11';

class Section extends Component {
  static propTypes = {
    header: PropTypes.oneOfType([PropTypes.string, PropTypes.element, PropTypes.array])
  };

  render() {
    let { children, header, ...props } = this.props;

    if (typeof header === 'string') {
      header = <Header>{header}</Header>;
    }

    return (
      <section {...props}>
        {header}
        <ul style={styles.list}>
          {children}
        </ul>
      </section>
    );
  }
}

export default Section;
