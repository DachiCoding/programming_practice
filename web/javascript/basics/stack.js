'use strict';

function Stack(){
    let items = [];

    this.push = function(element){
        items.push(element);
    };

    this.pop = function(){
        return items.pop();
    };

    this.peek = function(){
        return items[items.length-1];
    };

    this.isEmpty = function(){
        return items.length == 0;
    };

    this.size = function(){
         return items.length;
    };

    this.clear = function(){
        items = [];
    };

    this.print = function(){
        console.log(items.toString());
    }
}

let _items = Symbol();

class StackES6 {
    constructor(){
        this[_items] = [];
    }
    push(element){
        this.items.push(element);
    }
}

let stack = new Stack();

console.log(stack.isEmpty());
stack.push(5);
stack.push(8);
console.log(stack.peek());
stack.push(11);
console.log(stack.size());
console.log(stack.isEmpty());
stack.push(15);
stack.pop();
stack.pop();
console.log(stack.size());
stack.print();
