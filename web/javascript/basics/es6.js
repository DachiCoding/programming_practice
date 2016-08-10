'use strict';

//Using let to declare variables
let movie = 'Lord of the Rings';

function starWarsFan(){
    let movie = 'Star Wars';
    return movie;
}

function marvelFan(){
    movie = 'The Avengers';
    return movie;
}

function blizzardFan(){
    let isFan = true;
    let phrase = 'Warcraft';
    console.log('Before if: ' + phrase);
    if(isFan){
        let phrase = 'initial text';
        phrase = 'For the horde!';
        console.log('Inside if: ' + phrase);
    }
    phrase = 'For the Alliance!';
    console.log('After if: ' + phrase);
}

console.log(movie);
console.log(starWarsFan());
console.log(marvelFan());
console.log(movie);
blizzardFan();

//Arrow function
let circleArea = (r) => {
    const PI = 3.14;
    let area = PI * r * r;
    return area;
}

let circleArea2 = (r) => 3.14 * r * r;

console.log(circleArea(2));
console.log(circleArea2(4));

//Spread operator
//var params = [3,4,5];
//console.log(sum(...params));
