// 有关联的地方都改成 <T>
function createArray<T>(length: number, value: T): Array<T> {
  let result: T[] = [];
  for (let i = 0; i < length; i++) {
    result[i] = value;
  }
  return result;
}

// 使用的时候再指定类型
let result = createArray<string>(3, "x");

// 也可以不指定类型，TS 会自动类型推导
let result2 = createArray(3, "x");
console.log(result);