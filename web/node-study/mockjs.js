var Mock = require('mockjs');

//print funciton
function printMockData(data){
    console.log(JSON.stringify(data))
}

//DATA TEMPALTE DEFINITION 说白了就是先设置一个数据的模版，然后根据这个模版生成随机数据

/*
 * string mock data
 * varName|minRepeat-maxRepeat:string
 * varName|repeat:string
 * */
var strData1 = Mock.mock({
    'string|1-5':'abc'
});

var strData2 = Mock.mock({
    'string|3':'Hello'
});

printMockData(strData1);
printMockData(strData2);

/*
 * number mock data
 * varName|numRange:number
 * varName|numRange.floatingRange:number
 * */
var numData1 = Mock.mock({
    'number|1-100':1
});
var numData2 = Mock.mock({
    'number|1-10.1-5':1
});
var numData3 = Mock.mock({
    'number|+1':1000
});

printMockData(numData1);
printMockData(numData2);
printMockData(numData3);

/*
 * boolean mock data
 * varName|1(P=50%):boolean
 * varName|min-max(P=min/(min+max)):boolean
 * */
var booleanData = Mock.mock({
    'boolean|1':true
})
printMockData(booleanData);

/*
 * object data
 * varName|numOfPropertySelected: object
 * varName|minSelect-maxSelect:object
 * */
var objData1 = Mock.mock({
    'object|2':{x:'y',a:'b',m:'n'}
})

var objData2 = Mock.mock({
    'object|1-3':{x:'y',a:'b',m:'n'}
})
printMockData(objData1);
printMockData(objData2);

/*
 * array data
 * varName|1(select one element):array
 * varName|+1(select one element with order):array
 * varName|minRepeat-maxRepeat:array
 * varName|repeat:array
 * 
 * */
var arrData1 = Mock.mock({
    'arr|1':[1,2,3,4,5]
});

var arrData2 = Mock.mock({
    'arr|+1':[1,2,3,4,5]
});

var arrData3 = Mock.mock({
    'arr|2-4':[1,2,3,4,5]
});

var arrData4 = Mock.mock({
    'arr|2':[1,2,3,4,5]
})

printMockData(arrData1);
printMockData(arrData2);
printMockData(arrData3);
printMockData(arrData4);

//function mock data
//RegExp mock data

//Data Placeholder Definition 
var dpdData = Mock.mock({
    name: {
        first: '@FIRST'
    }
})
printMockData(dpdData);

//Mock.setup
//Mock.setup({
//    timeout: 300 //or 'minTimeout-maxTimeout'
//})

//Mock.random
printMockData(Mock.Random.email())

//Mock.valid
//Mock.toJSONSchema
