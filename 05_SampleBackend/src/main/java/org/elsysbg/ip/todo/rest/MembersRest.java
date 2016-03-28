package org.elsysbg.ip.todo.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.elsysbg.ip.todo.entities.Member;
import org.elsysbg.ip.todo.entities.Task;
import org.elsysbg.ip.todo.services.MembersService;
import org.elsysbg.ip.todo.services.TasksService;

@Path("/members")
public class MembersRest {
	private final MembersService membersService;
	private final TasksService tasksService;
	
	@Inject
	public MembersRest(MembersService membersService, TasksService tasksService) {
		this.membersService = membersService;
		this.tasksService = tasksService;
	}
	
	@GET
	@Path("/{MemberId}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Member getMember(@PathParam("MemberId") long MemberId) {
		return membersService.getMember(MemberId);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Member createMember(Member Member) {
		return membersService.createMember(Member);
	}
	
	@GET
	@Path("/{memberId}/tasks")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Task> getMemberTask(@PathParam("memberId") long memberId) {
		final Member author = membersService.getMember(memberId);
		tasksService.getTasksByAuthor(author);
	}
}
