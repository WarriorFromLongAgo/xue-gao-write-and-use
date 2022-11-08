# 入门
ts版本，tsc -v

将ts变成js，tsc 1_ts.ts

监听ts文件修改，变成js，tsc --watch

运行js文件，node 3_Interfaces.js

ts文件初始化，生成tsconfig.json，tsc --init
# webstorm 调试ts js文件
```
js文件可以直接运行调试


在ts目录下，本地安装ts和ts-node
// 安装typescript
npm i typescript -D
// 安装ts-node
npm i ts-node -D

ts 这个时候就可以调试了

```


# 4 4_declare.ts
```
https://ts.xcatliu.com/basics/declaration-files.html#declare-var

新语法索引§
由于本章涉及大量新语法，故在本章开头列出新语法的索引，方便大家在使用这些新语法时能快速查找到对应的讲解：

declare var 声明全局变量
declare function 声明全局方法
declare class 声明全局类
declare enum 声明全局枚举类型
declare namespace 声明（含有子属性的）全局对象
interface 和 type 声明全局类型
export 导出变量
export namespace 导出（含有子属性的）对象
export default ES6 默认导出
export = commonjs 导出模块
export as namespace UMD 库声明全局变量
declare global 扩展全局变量
declare module 扩展模块
/// <reference /> 三斜线指令

```