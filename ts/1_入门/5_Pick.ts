// Pick
// 从类型定义的属性中，选取指定一组属性，返回一个新的类型定义。
// 主要是从一个已知的类型中，取出子集，作为一个新的类型返回。

interface Person {
  name: string;
  age: number;
  id: number;
  sex: 0 | 1;
}

// 问女生年纪不太礼貌，所以我们不需要 age 这个属性
type Woman = Pick<Person, "name" | "id">;

// 此时 Woman 等效于 Female
interface Female {
  name: string;
  id: number;
}

let per1: Person = {
  age: 0,
  id: 0,
  sex: 1,
  name: "11",
};

console.log("person1 ", per1);

let per2: Woman = {
  // age: 0,
  id: 0,
  // sex: 1,
  name: "11",
};
console.log("person2 ", per2);

let per3: Woman = {
  // age: 0,
  id: 0,
  // sex: 1,
  name: "11",
};
console.log("person3 ", per3);