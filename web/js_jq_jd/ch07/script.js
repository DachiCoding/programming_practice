$(':header').addClass('headline');
/*
$('li:lt(3)').hide().fadeIn(1500);
$('li').on('click',function() {
 $(this).remove();
});
*/

//chaining
//$('li[id!="one"]').hide().delay(500).fadeIn(1400);

//get HTML
/*
var $listHTML = $('ul').html();
var $listHTMLText = $('ul').text();
$('ul').append($listHTML);
$('ul').append($listHTMLText);
*/

//Change context
/*
$(function(){
 $('li:contains("pine")').text('almonds');
 $('li.hot').html(function(){
  return '<em>' + $(this).text() + '</em>';
 });
 $('li#one').remove();
});
*/

//Changing CSS
/*
$(function(){
 var backgroundColor = $('li').css('background-color');
 $('ul').append('<p>Color was: ' + backgroundColor + '</p>');
 $('li').css({
  'background-color':'#c5a996',
  'border':'1px solid #fff',
  'color': '#000',
  'font-family':'Georgia',
  'padding-left': '+=75'
 });
});
*/

//Using "each"
/*
$('li').each(function(){
 var ids = this.id;
 $(this).append(' <em class="order">' + ids + '</em>');
});
*/

//Event
/*
$(function(){
 var ids = '';
 var $listItems = $('li');

 $listItems.on('mouseover click',function(){
  ids = this.id;
  $listItems.children('span').remove();
  $(this).append(' <span class="priority">' + ids + '</span>');
 });

 $listItems.on('mouseout',function(){
  $(this).children('span').remove();
 });
});
*/

//Event Object
/*
$(function(){
 $('li').on('click',function(e){
  $('li span').remove();
  var date = new Date();
  date.setTime(e.timeStamp);
  var clicked = date.toDateString();
  $(this).append('<span class="date"> ' + clicked + ' ' + e.type + '</span>');
 });
});
*/

//Event Delagation
$(function(){
 var listItem, itemStatus, eventType;

 $('ul').on(
  'click mouseover',
  ':not(#four)',
  {status: 'important'},
  function(e){
    listItem = 'Item: ' + e.target.textContent + '<br/>';
    itemStatus = 'Status: ' + e.data.status + '<br/>';
    eventType = 'Event: ' + e.type;
    $('#notes').html(listItem + itemStatus + eventType);
   }
  );
});

//Effects
/*
$(function(){
 $('h2').hide().slideDown();
 var $li = $('li');
 $li.hide().each(function(index){
  $(this).delay(700*index).fadeIn(700);
  });
  $li.on('click',function(){
  $(this).fadeOut(700);
  });
});
*/

//Animation
$(function(){
 $('li').on('click',function(){
  $(this).animate({
   opacity: 0.0,
   paddingLeft: '+=80'
   },500,function(){
   $(this).remove();
  });
 });
});

$(function(){
 var $newItemButton = $('#newItemButton');
 var $newItemForm = $('#newItemForm');
 var $textInput = $('input:text');

 $newItemButton.show();
 $newItemForm.hide();

 $('#showForm').on('click',function(){
  $newItemButton.hide();
  $newItemForm.show();
 });

 $newItemForm.on('submit',function(e){
  e.preventDefault();
  var newText = $('input:text').val();
  $('li:last').after('<li>' + newText + '</li>');
  $newItemForm.hide();
  $newItemButton.show();
  $textInput.val(' ');
 });
});

$(function(){
 var listHeight = $('#page').height();
 $('ul').append('<p>Height: ' + listHeight + 'px</p>');
 $('li').width('50%');
 $('li#one').width(125);
 $('li#two').width('75%');
});

var offset = $('#newItemButton').offset();
document.write('Left: ' + offset.left + ' Right: ' + offset.right);
