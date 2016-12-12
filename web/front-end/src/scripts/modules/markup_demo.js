var obj = {};

obj.progressBar = function(){
    var buttons = document.getElementsByClassName('progBtn');
    var progress = document.getElementById('myprogress');
    for(var i = 0; i < buttons.length; i++){
        buttons[i].onclick = function(e){
            progress.value = e.target.value;
        }
    }
};

module.exports = obj;