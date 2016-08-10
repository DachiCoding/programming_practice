function print(x){
    console.log(x);
}

//String are immutable
function stringManipulation(){
    var s = "hello, world";
    print(s.charAt(0));
    print(s.charAt(s.length-1));
    print(s.substring(1,4));
    print(s.slice(1,4));
    print(s.slice(-3));
    print(s.indexOf("l"));
    print(s.lastIndexOf("l"));
    print(s.indexOf("l",3));
    print(s.split(", "));
    print(s.replace("h","H"));
    print(s.toUpperCase());
}

//RegExp
function regexpTest(){
    var text = "testing: 1, 2, 3";
    var pattern = /\d+/g
    print(pattern.test(text));
    print(text.search(pattern));
    print(text.match(pattern));
    print(text.replace(pattern,"#"));
    print(text.split(/\D+/));
}

regexpTest();
