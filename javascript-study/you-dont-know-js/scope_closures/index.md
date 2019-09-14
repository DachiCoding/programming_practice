# Scope & Clouses

## Ch01 作用域
### 1.1 编译原理
+ JS引擎：调度完成JS代码运行
+ 编译器：完成源代码到机器码的生成与优化
+ 作用域：存放变量

### 1.2 作用域
+ 存放变量
+ 作用域层级：全局作用域，函数作用域，块级作用域
+ 变量查找: LHS(赋值查找), RHS(非赋值查找)

### 1.4 异常
+ 找不到变量：ReferenceError
+ 找到了类型错误: TypeError

## Ch02 词法作用域
### 2.2 欺骗
+ eval: 动态生成代码
+ with: 
+ Function(...params, body)

## Ch03 函数作用域和块级作用域
### 函数作用域

### 块级作用域
+ let
+ try/catch

### 规避冲突
+ 全局命名空间
+ 模块管理

## Ch04 提升

## Ch05 作用域闭包
+ 词法作用域：函数的作用域在编写时确定
```
function foo() {
    console.log(a);
}

function bar() {
    var a = 3;
    foo();
}

var a = 2;

bar(); // 词法作用域输出2，动态作用域输出3
```