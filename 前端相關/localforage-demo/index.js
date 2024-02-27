/**
 * @type {import('localforage')}
 */
import './node_modules/localforage/dist/localforage.js';

console.log('localforage is: ', localforage);

const numList = [1,2,3,4];

localforage.setItem('numList', numList).then(function (value) {
    console.log(value);
});

localforage.getItem('numList').then( nums => {
    console.log(nums);
}).catch(error=> {
    console.log(error);
});

localforage.setItem('somekey', 'some value').then(function (value) {

}).catch(function(err) {
    // 当出错时，此处代码运行
    console.log(err);
});


localforage.getItem('somekey').then(function(value) {
    // 当离线仓库中的值被载入时，此处代码运行
    console.log(value);
}).catch(function(err) {
    // 当出错时，此处代码运行
    console.log(err);
});