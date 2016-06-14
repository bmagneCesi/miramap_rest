$(document).ready(function() {
  
  // $('.expanded').click(function(){

  //     $(this).removeClass('fa-close expanded').addClass('fa-bars not-expanded');
  //     $('#nav-container').animate({height : 120}, 'slow');
  //     console.log('tt');
  // });

  $('#nav-container a').on('click', function(){

      $(this).children('i').removeClass('fa-bars').addClass('fa-close');
      $('#nav-container').animate({height : 300}, 'slow');
      console.log('ee');

  });  
 

});