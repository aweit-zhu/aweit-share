console.log(process.env.NODE_ENV);

import '@/styles.css';
import _ from 'lodash';
import '@/test.js';
import '@/test.js';
import '@/data.js';


function component() {
    const element = document.createElement('div');
    element.innerHTML = _.join(['Hello', 'webpack', '!'], ' ');
    return element;
}

document.body.appendChild(component());

