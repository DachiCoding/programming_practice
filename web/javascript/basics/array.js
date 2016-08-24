//KIM: Array is also object in JavaScript

function dow(){
    var daysOfWeek = new Array();
    var daysOfWeek = new Array(7);
    var daysOfWeek = new Array('Sun','Mon','Tue','Wed','Thr','Fri','Sat');
    var daysOfWeek = [];
    var daysOfWeek = ['Sun','Mon','Tue','Wed','Thr','Fri','Sat'];
    console.log(daysOfWeek.length);
}

function fib(){
    var fibonacci = [];
    fibonacci[0] = 1;
    fibonacci[1] = 1;

    for(var i = 2; i <= 20; i++){
        fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
    }

    for(var i = 0; i < fibonacci.length; i++){
        console.log(fibonacci[i]);
    }
}

var numbers = [0,1,2,3,4,5,6,7,8,9];

function appendElement(){
    console.log("Running appendElement");
    numbers[numbers.length] = 10;
    numbers.push(11);
    numbers.push(12,13);
    console.log(numbers);
}

function insertElementHead(){
    console.log("Running insertElementHead");
    for(var i = numbers.length; i >= 0; i--){
        numbers[i] = numbers[i-1];
    }
    numbers[0] = -1;
    console.log(numbers);
    numbers.unshift(-2);
    numbers.unshift(-4,-3);
    console.log(numbers);
}

function removeElementEnd(){
    console.log("Running removeElementEnd...");
    numbers.pop();
    console.log(numbers);
    numbers.shift();
    console.log(numbers);

}

function addRemoveElementIndex(){
    console.log("Running addRemoveElementIndex");
     numbers.splice(5,3);
     console.log(numbers);
     numbers.splice(5,0,2,3,4);
     console.log(numbers);
}

appendElement();
insertElementHead();
removeElementEnd();
addRemoveElementIndex();

/*
 *
 * arr.push() => add to end
 * arr.unshift() => add to beg
 * arr.pop() => remove from end
 * arr.shift() => remove from beg
 * arr.splice(m,n) => remove n elements starting at m
 * arr.splice(m,n,x1,x2,x3) => revmoe n elements starting at m and insert (x1...x3)
 * */
