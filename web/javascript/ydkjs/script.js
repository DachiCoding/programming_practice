//Chpater 1
const SPENDING_THRESHOLD = 200;
const TAX_RATE = 0.08;
const PHONE_PRICE = 99.99;
const ACCESSORY_PRICE = 9.99;

var bank_balance = 303.91;
var amount = 0;

function calculateTax(amount){
  return amount * TAX_RATE;
}

function formatAmount(amount){
  return '$' + amount.toFixed(2);
}

while ( amount < bank_balance ){
  amount = amount + PHONE_PRICE;

  if(amount < SPENDING_THRESHOLD){
    amount += ACCESSORY_PRICE;
  }
}

amount = amount + calculateTax(amount);

console.log("Your purchase: " + formatAmount(amount));

if (amount > bank_balance){
  console.log("You can't afford this purchase. :(");
}

//Chapter 2
a = [1,2];
b = [1,2];
if(a == b || a === b){
  console.log("EQUAL");
} else {
  console.log("NOT EQUAL");
}
console.log((3 > 1)? "3 > 1" : "3 < 1");

function foo(){
  "user strict";
  a = 1;
}

foo();

(function DoItNow(){console.log("Do it now function.")}) ();
