class EventEmitter {
    constructor(){
        this.listeners = new Map();
    }
    addListener(label, callback) {}
    removeListener(label, callback) {}
    emit(label, ...args) {}
}

addListener(label,callback){
    this.listeners.has(label) || this.listeners.set(label,[]);
    this.listeners.get(label).push(callback);
}

let isFunction = function(obj){
    return typeof obj == 'function' || false;
}

removeListener(label,callback){
    let listeners = this.listeners.get(label),
        index;

    if (listeners && listeners.length){
        index = listeners.reduce((i,listener,index) => {
            return (isFunction(listener) && listener === callback) ?
                i = index :
                i;
        }, -1);

        if (index > -1){
            listeners.splice(index,1);
            this.listeners.set(label,listeners);
            return true;
        }
    }

    return false;
}

emit(label, ...args){
    let listeners = this.listeners.get(label);

    if (listeners && listener.length){
        listener.forEach((listener) => {
            listener(...args);
        });
        return true;
    }
    return false;
}

function Func(){}
Func.prototype.name = "Sean";
Func.prototype.getInfo = function(){
     return this.name;
}
var person = new Func();
console.log(person.getInfo());
console.log(person.prototype);
