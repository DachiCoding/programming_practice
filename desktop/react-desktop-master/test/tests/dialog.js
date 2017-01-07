import { expect } from 'chai';
import React from 'react';
import { renderToString } from 'react-dom/server';
import Dialog from '../../src/dialog/macOs/dialog';

describe('Dialog', () => {
  it('create osx dialog', () => {
    const string = renderToString(<Dialog/>);
    expect(string).to.match(/div/);
  });
});
