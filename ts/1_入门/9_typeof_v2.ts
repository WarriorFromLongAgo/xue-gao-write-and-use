class Greeter {
  static message = "hello";

  greet() {
    return Greeter.message;
  }
}

// 获取的是实例的类型，该类型可以获取实例对象上的属性/方法
let greeter1: Greeter = new Greeter();
console.log(greeter1.greet());// 'hello'
// 报错
// console.log(greeter1.message);// 'hello'


// 获取的是类的类型，该类型可以获取类上面的静态属性/方法
let greeterTwo: typeof Greeter = Greeter;
greeterTwo.message = "hey";

let greeter2: Greeter = new greeterTwo();
console.log(greeter2.greet());// 'hey'