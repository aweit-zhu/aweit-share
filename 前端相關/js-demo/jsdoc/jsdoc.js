/**
 * 
 * @param { string } name 名字
 * @returns {string } Hi, ${name}
 * @example sayHi('John');
 */
const sayHi = (name) => {
  return `Hi, ${name}`;
};

console.log(sayHi('123'));

/**
 * 我的名字
 * @type { { name: string, age: number } }
 */
export const myName = {
    name: 'Ray',
    age: 18,
};


/**
 * 
 * @param {number} id 
 * @param {string} username 
 * @param {string} password 
 * @param {string} email 
 * @param {string} role 
 */
export function User(id,username,password,email, role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.role = role;
  }
  

export const user1 = new User(1,'admin','admin','admin@example.com','ADMIN');

export const users = [
    new User(1,'admin','admin','admin@example.com',Roles.ADMIN),
    new User(2,'user','user','user@example.com',Roles.USER),
  ];
  