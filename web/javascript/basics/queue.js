'use strict';
function Queue(){
    let items = [];

    this.enqueue = function(element){
        items.push(element);
    }

    this.dequeue = function(){
        return items.shift();
    }

    this.front = function(){
        return items[0];
    }

    this.isEmpty = function(){
        return items.length == 0;
    }

    this.size = function(){
        return items.length;
    }

    this.print = function(){
         console.log(items.toString());
    }
}

let queue = new Queue();
console.log(queue.isEmpty());
queue.enqueue("John");
queue.enqueue("Jack");
queue.enqueue("Camila");
queue.print();
console.log(queue.size());
console.log(queue.isEmpty());
queue.dequeue();
queue.dequeue();
queue.print();

let Queue2 =(function(){
    const items = new WeakMap();

    class Queue2 {
        constructor(){
            items.set(this,[]);
        }
        enqueue(element){
            let q = items.get(this);
            q.push(element);
        }
        dequeue(){
            let q = items.get(this);
            let r = q.shift();
            return r;
        }
        front(){
            let q = items.get(this);
            return q[0];
        }
        isEmpty(){
            let q = items.get(this);
            return q.length == 0;
        }
        size(){
            let q = items.get(this);
            return q.length;
        }
        print(){
            let q = items.get(this);
            console.log(q.toString());
        }
    }
    return Queue2;
})();

function PriorityQueue(){
    let items = [];
    function QueueElement(element,priority){
        this.element = element;
        this.priority = priority;
    }

    this.enqueue = function(element,priority){
        let queueElement = new QueueElement(element,priority);

        let added = false;

        for(let i = 0; i < items.length; i++){
            if (queueElement.priority < items[i].priority){
                items.splice(i,0,queueElement);
                added = true;
                break;
            }
        }
        if(!added){
             items.push(queueElement);
        }
    };

    this.print = function(){
        for(let i = 0; i < items.length; i++){
            console.log(`${items[i].element} - ${items[i].priority}`);
        }
    }

}

let pq = new PriorityQueue();
pq.enqueue("John",2);
pq.enqueue("Jack",1);
pq.enqueue("Camila",1);
pq.print();


