interface Person {
  name: string;
  age: number;
}

const sem: Person = {name: "semlinker", age: 30};
type Sem = typeof sem; // -> Person

let sem2: Sem = {
  age: 0,
  name: "",
};


function toArray(x: number): Array<number> {
  return [x];
}

type Func = typeof toArray; // -> (x: number) => number[]