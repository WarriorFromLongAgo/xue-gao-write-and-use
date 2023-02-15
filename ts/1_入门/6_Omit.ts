interface User {
  id: number,
  name: string,
  age: number,
  sex: 0 | 1,
  tel: number,
}

type EditUser = Omit<User, "id"> // 就是在 User 的基础上，去掉 id 属性

let user1: User = {
  age: 0,
  id: 0,
  name: "",
  sex: 1,
  tel: 0,
};

let user2: EditUser = {
  age: 0,
  // id: 0,
  name: "",
  sex: 1,
  tel: 0,
};