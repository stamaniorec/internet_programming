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
	
	$("#remove-mountain").on("click", function() {
		alert("removing mountain");
	});
	
	$("#remove-mountain").on("mouseover", function() {
		alert("hovering over remove mountain");
	});
	
	$("#add-mountain").click(function() {
		var newMountainElement = $("<li />");
		var mountainName = $("#mountain-name-input").val();
		newMountainElement.text(mountainName);
		$("#mountain-name-input").val("");
		newMountainElement.text(mountainName);
		$("ul").append(newMountainElement);
	});
	
	// add new row to the table
	$("table").append("<tr><td>3</td><td>Gosho</td></tr>");

//	$("table tbody").remove();
	
});