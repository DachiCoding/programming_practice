//Primitive
var str1 = "this is a simple string";
var num1 = 1.45;
var answer1 = true;

//Still Primitive
var str2 = String("this is a simple string");
var num2 = Number(1.45);
var answer2 = Boolean(true);

//Object
var str3 = new String("this is a simple string");
var num3 = new Number(1.45);
var answer3 = new Boolean(true);

console.log(typeof(str1));
console.log(typeof(str2));
console.log(typeof(str3));
