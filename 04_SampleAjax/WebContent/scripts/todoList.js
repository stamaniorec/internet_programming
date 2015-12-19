$(document).ready(function() {
	"use strict";
	var ENDPOINT = "http://localhost:3000/tasks";

	function taskEndpoint(taskId) {
		return ENDPOINT + "/" + taskId;
	}
	
	function showPanel(panelName) {
		var ALL_PANELS = ["emptyPanel", "readPanel", "updatePanel", "createPanel"]
		_.forEach(ALL_PANELS, function(panel) {
			$("#"+panel).hide();
		});
		$("#"+panelName).show();
	}
	
	function listTasks() {
		return $.ajax(ENDPOINT, {
			method: "GET",
			dataType: "json"
		});
	}
	
	function readTask(taskId) {
		return $.ajax(taskEndpoint(taskId), {
			method: "GET",
			dataType: "json"
		});
	}
	
	function updateTask(taskId) {
		return $.ajax(taskEndpoint(taskId), {
			method: "PUT",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify({
				title: $("#updatePanel input[name='title']").val(),
				description: $("#updatePanel textarea[name='description']").val()
			}),
			dataType: "json"
		});		
	}

	function deleteTask(taskId) {
		$.ajax(taskEndpoint(taskId), {
			method: "DELETE"
		});
	}
	
	var title;
	var description;
	
	function showTaskView(response) {
		title = response.title;
		description = response.description;
		$("#readPanel .task-title").text(title);
		$("#readPanel .task-description").text(description);
		showPanel("readPanel");
	}
	
	function updateTaskView(response) {
		showPanel("updatePanel");
		$("#updatePanel input[name='title']").val(title);
		$("#updatePanel textarea[name='description']").val(description);
	}

	function createTask() {
		var new_task = {
			title: $("#createPanel [name='title']").val(),
			description: $("#createPanel [name='description']").val()
		};
		$.ajax(ENDPOINT, {
			method: "POST",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(new_task),
			dataType: "json"
		});
	}
	
	function reloadTasks() {
		listTasks().then(function(response) {
			function addTaskToList(task) {
				var newItem = $("<li />");
				newItem.text(task.title);
				newItem.addClass("list-group-item");
				newItem.attr("data-task-id", task.id);

				$("#tasksList").append(newItem);
			}
			
			$("#tasksList").html("");
			_.forEach(response, addTaskToList);
		});
	}
	
	var taskId;
	
	function attachHandlers() {
		$(document).on("click", "#tasksList [data-task-id]", function() {
			taskId = $(this).attr("data-task-id");
			readTask(taskId).then(showTaskView);
		});
		$(".task-action-cancel").click(function() {
			showPanel("emptyPanel");
		});
		$("#readPanel .task-action-ok").click(function() {
			updateTaskView();
		});
		$(document).on("click", "#updatePanel button", function() {
			updateTask(taskId);
			location.reload(true);
		});
		$(document).on("click", "#readPanel .task-action-remove", function() {
			deleteTask(taskId);
			location.reload(true);
		});
		$(document).on("click", "#addTaskButton", function() {
			showPanel("createPanel");
		});
		$(document).on("click", "#createPanel .task-action-ok", function() {
			createTask();
			location.reload(true);
		});
	}
	
	attachHandlers();
	reloadTasks();
});