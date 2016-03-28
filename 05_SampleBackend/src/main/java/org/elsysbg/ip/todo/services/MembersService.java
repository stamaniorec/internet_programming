package org.elsysbg.ip.todo.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.elsysbg.ip.todo.entities.Member;

@Singleton
public class MembersService {
	private final EntityManagerService entityManagerService;
	
	@Inject
	public MembersService(EntityManagerService entityManagerService) {
		this.entityManagerService = entityManagerService;
		
	}
	
	public Member createMember(Member Member) {
		final EntityManager em = entityManagerService.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(Member);
			em.getTransaction().commit();
			return Member;
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
	
	public List<Member> getMembers() {
		final EntityManager em = entityManagerService.createEntityManager();
		try {
			final TypedQuery<Member> query = 
					em.createNamedQuery(Member.QUERY_ALL, Member.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public Member getMember(long MemberId) {
		final EntityManager em = entityManagerService.createEntityManager();
		try {
			final Member result = em.find(Member.class, MemberId);
			if(result == null) {
				throw new IllegalArgumentException("No Member with id: " + MemberId);
			}
			return result;
		} finally {
			em.close();
		}
	}
	
	public Member updateMember(Member Member) {
		final EntityManager em = entityManagerService.createEntityManager();
		try {
			em.getTransaction().begin();
			final Member result = em.merge(Member);
			em.getTransaction().commit();
			return result;
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
	
	public void deleteMember(long MemberId) {
		final EntityManager em = entityManagerService.createEntityManager();
		try {
			em.getTransaction().begin();
			final Member fromDb = em.find(Member.class, MemberId);
			if(fromDb == null) {
				throw new IllegalArgumentException("No Member with id: " + MemberId);
			}
			em.remove(fromDb);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
