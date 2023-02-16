interface Person1 {
  name: string;
  age: number;
}

// Property 'age' is missing in type '{ age: number; }' but required in type 'Person'.(2741)
const person1: Person1 = {age: 0, name: "chengcheng"};

// ?: 可选属性运算符
interface Person2 {
  name: string;
  age?: number;
}

const person2: Person2 = {name: "chengcheng"};

