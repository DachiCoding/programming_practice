// ex 4.1.4
function sumSalary (salaries) {
    let result = 0;
    if (!salaries) return result;
    for (person in salaries) {
        result += salaries[person];
    }
    return result;
}

function runSumSalary () {
    let salaries = {
        John: 100,
        Ann: 160,
        Pete: 130
    };
    console.log(sumSalary(salaries));
}

// ex 4.1.5
function multiplyNumeric (obj) {
    for (prop in obj) {
        if (typeof obj[prop] === 'number') {
            obj[prop] *= 2;
        }
    }
}

function runMultiplyNumeric () {
    let menu = {
        width: 200,
        height: 300,
        title: "My menu"
    };
    multiplyNumeric(menu);
    console.log(menu);
}

// 4.2 Symbol
function symbolDemo () {
    // create symbol
    let id1 = Symbol("id");
    let id2 = Symbol("id");

    // create hidden prop
    let user = {
        name: 'John'
    };
    let id3 = Symbol();
    user[id3] = 1;

    // global symbol
    let id4 = Symbol.for("ok");
    let id5 = Symbol.for("ok");
    console.log(id4 === id5);
}

// symbolDemo();

// 4.3 Object to primitives
function objectToPrimitivesDemo () {
    let user = {
        name: 'John',
        money: 1000,

        [Symbol.toPrimitive](hint) {
            alert(`hint: ${hint}`);
            return hint === 'string' ? `{name: "${this.name}"}` : this.money;
        }
    };

    alert(user);
    alert(+user);
    alert(user + 500);
}
objectToPrimitivesDemo();