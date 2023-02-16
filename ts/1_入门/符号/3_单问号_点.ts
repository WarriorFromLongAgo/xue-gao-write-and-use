// let a = undefined;
// let a = null;
// let b = "b";
// let c = a?.b;
// console.log("c ", c);
//


// 这里 Error对象定义的stack是可选参数，如果这样写的话编译器会提示
// 出错 TS2532: Object is possibly 'undefined'.
new Error().stack.split("\n");

// 我们可以添加?操作符，当stack属性存在时，调用 stack.split。
// 若stack不存在，则返回空
new Error().stack?.split("\n");

// 以上代码等同以下代码, 感谢 @dingyanhe 的监督
const err = new Error();
err.stack && err.stack.split("\n");







