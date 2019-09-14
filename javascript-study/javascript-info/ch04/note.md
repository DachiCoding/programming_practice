# Chapter 4 Object: The Basics

## Symbol Type
### What is Symbol
+ Symbol is a primitive type for unique identifiers.
+ Symbols are guaranteed to be unique.
+ Symbols allow us to create “hidden” properties of an object, that no other part of code can accidentally access or overwrite.
+ Symbols are skipped by for…in, but it is copyed in Object.assign

### Create Symbol
```
let id = Symbol(desc);
```

### Crete Global Symbol
```
let id = Symbol.for(desc);
```

### Summary
+ “Hidden” object properties.
+ There are many system symbols used by JavaScript which are accessible as Symbol.*. We can use them to alter some built-in behaviors
+ Technically, symbols are not 100% hidden. There is a built-in method Object.getOwnPropertySymbols(obj) that allows us to get all symbols. Also there is a method named Reflect.ownKeys(obj) that returns all keys of an object including symbolic ones

## Object to primitives
### hint(转换方向)
+ numeric: when subtract object and apply mathematic functions
+ string: when output
+ default

### conversion methods(转换方法)
+ Symbol.toPrimitives (all)
+ toString (string hint)
+ valueOf (otherwise)
