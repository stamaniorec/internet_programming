$(document).ready(function() {
	"use strict"
	
	function removeByClassName() {
		$(".name-column").remove();
	}
	
	removeByClassName();
	
	// add new row to the table
	$("table").append("<tr><td>3</td><td>Gosho</td></tr>");

//	$("table tbody").remove();
	
});