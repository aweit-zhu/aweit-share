"use strict";

/**
 * 
 * @param {number} a 
 * @param {number} b 
 * @returns {number}
 */
function add(a, b) {
  return a + b;
}
var max = function max(a, b) {
  return a >= b ? a : b;
};
console.log(max(1, 2));

// npx babel module/Babel/main.js --out-file module/Babel/dist/main.js
