package org.osbook.jobstore.rest;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.osbook.jobstore.domain.Job;
import org.osbook.jobstore.services.JobService;

@Path("/jobs")
public class JobResource {

	@Inject
	private JobService jobService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewJob(@Valid Job job) {
		job = jobService.save(job);
		return Response.status(Status.CREATED).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Job> showAll() {
		return jobService.findAll();
	}
}