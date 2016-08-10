function print(x){
    console.log(x);
}

//Literals
var numbers = [
    1,
    3.14,
    2345.789,
    .3333333,
    6.02e23,
    1.4738223E-32
]
print("--------------");
print(numbers);

//Operations
print("--------------");
print(Math.pow(2,53));
print(Math.round(.6));
print(Math.ceil(.6));
print(Math.floor(.6));
print(Math.abs(-5));
print(Math.max(1,0,-1));
print(Math.min(222,4,3.15));
print(Math.random());
print(Math.PI);
print(Math.E);
print(Math.sqrt(3));
print(Math.pow(3,1/3));
print(Math.sin(0));
print(Math.log(10));
print(Math.log(100)/Math.LN10);
print(Math.log(512)/Math.LN2);
print(Math.exp(3));

//Special values
print("--------------");
print(Infinity);
print(Number.POSITIVE_INFINITY);
print(Number.NEGATIVE_INFINITY);
print(Number.MAX_VALUE);
print(Number.MIN_VALUE);
print(NaN);
print(Number.NaN);

//Dates and Times
var then = new Date(2010,0,1);
var later = new Date(2010,0,1,17,10,30);
var now = new Date();
print("--------------");
print(now-then);
print(later.getFullYear());
print(later.getMonth());
print(later.getDate());
print(later.getDay());
print(later.getHours());
print(later.getUTCHours());
print(later.toString());
print(later.toUTCString());
print(later.toLocaleDateString());
print(later.toLocaleTimeString());
print(later.toISOString());
