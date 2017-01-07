//Basic Selectors
//Select all elements
var allElements = $('*');
console.log(allElements);

//Select by id
console.log($('#description'));

//Select by class
console.log($('.blue'));

//Select by element
console.log($('p'));

//Select mix elements
console.log($('div,p'));

//Select by hierarchy

//Select by attribute
console.log($("a[href^='css']"));
/*
 * [key=val] eqauls
 * [key^=val] begin with
 * [key$=val] end with
 * [key*=val] contains
 * [key|=val] followed by hyphen
 * [key~=val] not equal to
 * */

//Filters
//Position filter
/*
 * :first
 * :last
 * :even
 * :odd
 * :eq(n)
 * :gt(n)
 * :lt(n)
 * /

//Child filter

//Form filter

//Content filter
