$(document).ready(function() {
	"use strict"
	
	function removeByClassName() {
		$(".name-column").remove();
	}
	
	function removeById() {
		$("#students-table").remove();
	}
	
	function removeByType() {
		$("ol").remove();
	}
	
	function removeByDescendant() {
		$("ol li").remove();
	}
	
	function removeByFind(parent) {
		parent.find("li").remove();
	}
	
//	removeByClassName();
//	removeByType();
//	removeById();
	removeByFind($("ol"));
	
	// add new row to the table
	$("table").append("<tr><td>3</td><td>Gosho</td></tr>");

//	$("table tbody").remove();
	
});