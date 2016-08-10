var num = 100;
var boo = true;
console.log("100 == true: " + (num == boo));
num = 1;
console.log("1 == true: " + (num == boo));
num = 0;
boo = false;
console.log("0 == false: " + (num == boo));

/*
 * When comparing two variable with == of different types, boolean and string will cast to number, object will
 * convert to primitive type
 */
