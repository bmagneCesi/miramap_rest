$(document).ready(function() {


	///////////////////////////  MENU  ////////////////////////////////////

	$('#nav-expand').click(function(){
		var noExp = false;
		expand();

	});  

	$('#nav-container ul li a').click(function(event) {
		var noExp = true;
		expand(noExp);

	});
 

	$('#nav-container a#logo').click(function(event) {
  		var noExp = true;
  		expand(noExp);

	});
 
 	$('#center_column').click(function(event) {
		var noExp = true;
 		expand(noExp);
 	});

	function expand(noExp)
	{
		if ($('#nav-expand').hasClass('expanded')) {

		     $('#nav-expand').removeClass('fa-close expanded').addClass('fa-bars not-expanded');
		     $('#nav-container ul#nav').hide();
		     $('#nav-container').delay('fast').animate({height : 130}, 200,function(){
		     	$('.darken').animate({opacity : 0}, 200);
	    	});

	  	}else if ($('#nav-expand').hasClass('not-expanded') && !noExp ) {

		     $('#nav-expand').removeClass('fa-bars not-expanded').addClass('fa-close expanded');
		     $('#nav-container').animate({height : 200}, 200, function(){
		     $('#nav-container ul#nav').show();
		     $('.darken').css('height', $(window).height()+'px').animate({opacity : 1}, 200);
	   		});

	  	};
	}

	///////////////////////////  FIN MENU  ////////////////////////////////////

	///////////////////////////  DEBUT HOME  ////////////////////////////////////


	
	///////////////////////////  FIN HOME  ////////////////////////////////////

	///////////////////////////  LOGIN & INSCRIPTION  ////////////////////////////////////

	$('#btn-login').click(function(event) {
		$.fancybox('#login');
	});

	$('#btn-inscription').click(function(event) {
		$.fancybox('#inscription');
	});

	///////////////////////////  FIN LOGIN & INSCRIPTION  ////////////////////////////////////


});
