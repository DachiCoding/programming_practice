var obj = {};

obj.changeAllColor = function(){
    var buttons = document.getElementsByClassName('changeAllColor');
    for(var i = 0; i < buttons.length; i++){
        buttons[i].onclick = function(e){
            document.body.style.color = e.target.value;
        }
    }
}

obj.changeVisbility = function(){
    var element = document.getElementById('p13');
    var buttons = document.getElementsByClassName('changeVis');
    for(var i = 0; i < buttons.length; i++){
        buttons[i].onclick = function(e){
            element.style.visibility = e.target.innerHTML;
        }
    }
}

module.exports = obj;