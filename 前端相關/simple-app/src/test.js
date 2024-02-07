// // 箭头函数示例
// const add = (a, b) => a + b;
// console.log(add(2, 3));

// // 解构赋值示例
// const person = { name: 'Alice', age: 30 };
// const { name, age } = person;
// console.log(name, age);

// // 模板字符串示例
// const greeting = `Hello, ${name}!`;
// console.log(greeting);

// // 类示例
// class Animal {
//   constructor(name) {
//     this.name = name;
//   }
//   speak() {
//     console.log(`${this.name} makes a noise.`);
//   }
// }

// const dog = new Animal('Dog');
// dog.speak();

// const foo = null ?? 'default value';
// console.log(foo); // 输出: "default value"


// const student = {
//     name: 'Alice',
//     address: {
//         city: 'New York'
//     }
// };
  
// // 使用可选链操作符
// const city = student.address?.city;
// console.log(city); // 输出: "New York"

// // 当属性不存在时，不会抛出错误，而是返回 undefined
// const country = student.address?.country;
// console.log(country); // 输出: undefined