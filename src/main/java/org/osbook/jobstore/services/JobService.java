package org.osbook.jobstore.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.osbook.jobstore.domain.Job;

@Stateless
public class JobService {

	@PersistenceContext(unitName = "jobstore")
	private EntityManager entityManager;

	public Job save(Job job) {
		entityManager.persist(job);
		return job;
	}

	public List<Job> findAll() {
		return entityManager
				.createQuery("SELECT j from org.osbook.jobstore.domain.Job j order by j.postedAt desc", Job.class)
				.getResultList();
	}

}