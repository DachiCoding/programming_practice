import React from 'react';
import Hello from './component.jsx';
import './main.js';

main();

function main() {
    React.render(<Hello />, document.getElementById('app'));
}

