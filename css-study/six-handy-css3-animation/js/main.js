$(function(){
    $('.hamburger-button').on('click',function(event){
        event.preventDefault();
        $(this).toggleClass('active');
    })
})