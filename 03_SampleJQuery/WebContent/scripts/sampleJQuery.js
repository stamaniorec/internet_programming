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
	
	var nextFreeMountainId = 1;

	$("#add-mountain").click(function() {
		var newMountainElement = $("<li />");
		var mountainName = $("#mountain-name-input").val();
		newMountainElement.text(mountainName);
		$("#mountain-name-input").val("");
		newMountainElement.text(mountainName);
		newMountainElement.attr("nextFreeMountainId", "mountain"+(nextFreeMountainId++));
		$("ul").append(newMountainElement);
	});
	
	$(document).on("click", "ul li", function() {
		alert($(this).attr("id"));
	});
	
	$("#hiking").click(function() {
		var allMountains = $("ul li");
//		for(var i = 0; i < allMountains.length; ++i) {
//			var next = $(allMountains[i]);
//			alert(next.text());
//		}
		$.each(allMountains, function(index, value) {
			var next = $(value);
			alert(next.text());
		});
//		_.forEach(allMountains, function() {}; // lodash
	});
	
	// add new row to the table
	$("table").append("<tr><td>3</td><td>Gosho</td></tr>");

//	$("table tbody").remove();
	
});