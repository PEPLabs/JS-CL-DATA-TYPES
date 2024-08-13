// Number Datatype
// Represents both integers and floating-point numbers.

function numberMethod() {   
    // TODO: Declare and initialize a number variable named 'myNumber' with a value of 3.14
    let outputElement = document.getElementById("output");
    outputElement.textContent = `Number: ${"Replace me with the variable you've just created"}`;
}

// Undefined Datatype
// Indicates that a variable has not been assigned a value.

function undefinedMethod() {
    // TODO: Declare an undefined variable named 'myUndefined' and display its type
    let outputElement = document.getElementById("output");
    outputElement.textContent = `Undefined: ${typeof "Replace me with the variable you've just created"}`;
}

// Null Datatype
// Represents the intentional absence of any object value.

function nullMethod() {
    // TODO: Declare a null variable named 'myNull' and display its value
    let outputElement = document.getElementById("output");
    outputElement.textContent = `Null: ${"Replace me with the variable you've just created"}`;
}

// Object Datatype
// Collections of properties where each property is a key-value pair.

function objectMethod(name, age) {
    // TODO: Declare and initialize an object variable named 'myObject' with properties name and age, assign it with the parameters accordingly.
    let outputElement = document.getElementById("output");
    outputElement.textContent = `Object: ${JSON.stringify("Replace me with the variable you've just created")}`;
}


// Array Datatype
// List-like objects used to store multiple values in a single variable.

function arrayMethod() {
    // TODO: Declare and initialize an array variable named 'myArray' with values from 1 to 5
    let outputElement = document.getElementById("output");
    outputElement.textContent = `Array: ${JSON.stringify("Replace me with the variable you've just created")}`;
}
