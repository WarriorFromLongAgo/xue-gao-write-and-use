// 注意区别

// 普通的接口
interface discount1 {
  getNum: (price: number) => number;
}

let tempDiscount1: discount1 = {
  getNum(price: number): number {
    return 0;
  },
};

// 函数类型接口
interface discount2 {
  // 注意:
  // “:” 前面的是函数的签名，用来约束函数的参数
  // ":" 后面的用来约束函数的返回值
  (price: number): number;
}

let cost: discount2 = function (price: number): number {
  return price * .8;
};

// 也可以使用类型别名
type Add = (x: number, y: number) => number
let add: Add = (a: number, b: number) => a + b;





