// Q1: In JavaScript, how is "undefined" different from "null"? 
// Show an example that demonstrates the difference.

console.log("---- Q1: undefined vs null ----");

let a; // not assigned
let b = null;

console.log("a =", a);           // undefined
console.log("b =", b);           // null
console.log("typeof a =", typeof a); // "undefined"
console.log("typeof b =", typeof b); // "object"

console.log("Explanation: 'undefined' means a variable is declared but has no value. 'null' means an intentional empty value.");


////////////////////////////////////////////////////////////////////////////////////////////////


// Q2: What is "truthy" and "falsy" values in JavaScript? 
// Show an example of how they are evaluated in conditions.

console.log("---- Q2: truthy vs falsy ----");

if (0) console.log("0 is truthy"); 
else console.log("0 is falsy"); // -> falsy

if ("") console.log("Empty string is truthy");
else console.log("Empty string is falsy"); // -> falsy

if ("hello") console.log("Non-empty string is truthy"); // -> truthy

if (undefined) console.log("undefined is truthy");
else console.log("undefined is falsy"); // -> falsy

console.log("Explanation: In JavaScript, some values are considered 'falsy' (false in condition) → 0, '', null, undefined, NaN, false. Everything else is 'truthy'.");


////////////////////////////////////////////////////////////////////////////////////////////////


// Q3: What is the difference between "var", "let", and "const" in JavaScript?

console.log("---- Q3: var, let, const ----");

var x = 1; 
let y = 2; 
const z = 3; 

{
  var x = 10;   // re-declared inside block
  let y = 20;   // block scoped
  const z = 30; // block scoped
}

console.log("x =", x); // 10
console.log("y =", y); // 2
console.log("z =", z); // 3

console.log("Explanation: var is function-scoped, let & const are block-scoped. const cannot be reassigned.");


////////////////////////////////////////////////////////////////////////////////////////////////


// Q4: What are "arrow functions" and how are they different from normal functions?

console.log("---- Q4: normal vs arrow functions ----");

"use strict";

function normalFunc() {
  console.log("normalFunc this =", this);
  return this;
}

const arrowFunc = () => {
  console.log("arrowFunc this =", this);
  return this;
};

// Case 1: Called directly
console.log("Direct call:");
console.log("normalFunc() returns:", normalFunc()); // undefined in strict mode
console.log("arrowFunc() returns:", arrowFunc());  // global object (window in browser)

// Case 2: As object methods
const obj = {
  normalFunc: function() {
    console.log("obj.normalFunc this =", this);
    return this;
  },
  arrowFunc: () => {
    console.log("obj.arrowFunc this =", this);
    return this;
  }
};

console.log("Object method call:");
obj.normalFunc(); // "this" = obj
obj.arrowFunc();  // "this" = global object, NOT obj

console.log("Explanation: Normal functions get 'this' based on how they are called. Arrow functions don’t have their own 'this' — they use 'this' from where they were defined.");


////////////////////////////////////////////////////////////////////////////////////////////////


// Q5: What is "destructuring" in JavaScript? 
// Show examples with arrays and objects.

console.log("---- Q5: destructuring ----");

const arr = [10, 20, 30];
const [first, second] = arr;

console.log("first =", first);   // 10
console.log("second =", second); // 20

const person = { name: "Khan", age: 35 };
const { name, age } = person;

console.log("name =", name); // Khan
console.log("age =", age);   // 35

console.log("Explanation: Destructuring allows easy extraction of array elements or object properties into variables.");


////////////////////////////////////////////////////////////////////////////////////////////////


// Q6: What are "spread" and "rest" operators in JavaScript?

console.log("---- Q6: spread vs rest ----");

// Spread
const nums = [1, 2, 3];
const newNums = [...nums, 4, 5];
console.log("Spread array:", newNums);

const obj1 = { a: 1, b: 2 };
const obj2 = { ...obj1, c: 3 };
console.log("Spread object:", obj2);

// Rest
function sum(...args) {
  return args.reduce((a, b) => a + b, 0);
}
console.log("Sum using rest =", sum(1, 2, 3, 4));

console.log("Explanation: Spread expands arrays/objects. Rest collects multiple arguments into an array.");


////////////////////////////////////////////////////////////////////////////////////////////////


// Q7: Explain "closures" in JavaScript with an example.

console.log("---- Q7: closures ----");

// Example 1: Counter closure
function outerCounter() {
  let counter = 0; // private variable
  return function inner() {
    counter++;
    return counter;
  };
}

const inc = outerCounter();
console.log("Counter Example:");
console.log(inc()); // 1
console.log(inc()); // 2
console.log(inc()); // 3

// Example 2: Real-world use case → user session
function createUserSession(username) {
  let isLoggedIn = true; // private state
  return {
    getUser: function() {
      return isLoggedIn ? `${username} is logged in` : `${username} is logged out`;
    },
    logout: function() {
      isLoggedIn = false;
      return `${username} has logged out`;
    }
  };
}

const session = createUserSession("Khan");
console.log("Session Example:");
console.log(session.getUser());   // Khan is logged in
console.log(session.logout());    // Khan has logged out
console.log(session.getUser());   // Khan is logged out

console.log("Explanation: A closure is when an inner function remembers variables from its outer function even after the outer function has finished. This allows private state, useful in counters, sessions, caching, etc.");


////////////////////////////////////////////////////////////////////////////////////////////////


// Q8: What is the difference between "==" and "===" in JavaScript?

console.log("---- Q8: == vs === ----");

console.log("5 == '5' →", 5 == "5");   // true
console.log("5 === '5' →", 5 === "5"); // false

console.log("Explanation: '==' checks only value (type coercion). '===' checks value AND type.");


////////////////////////////////////////////////////////////////////////////////////////////////


// Q9: How does "async/await" work in JavaScript?

console.log("---- Q9: async/await ----");

function delay(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

async function example() {
  console.log("Start");
  await delay(1000);
  console.log("1 second later...");
}

example();

console.log("Explanation: async/await makes async code look like sync. await pauses until Promise resolves.");


////////////////////////////////////////////////////////////////////////////////////////////////


// Q10: What are "default parameters" in JavaScript functions?

console.log("---- Q10: default parameters ----");

function greet(name = "Guest") {
  console.log(`Hello, ${name}`);
}

greet("Khan");
greet();

console.log("Explanation: Default parameters let you set fallback values for missing function arguments.");
