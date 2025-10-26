package com.jdc.mkt.repo;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class BaseRepoImpl<T,ID> extends SimpleJpaRepository<T, ID> implements BaseRepo<T, ID>{

	private EntityManager em;
	
	public BaseRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager em) {
		super(entityInformation, em);
		this.em = em;
	}

	@Override
	public <R> List<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFun) {
		return em.createQuery(queryFun.apply(em.getCriteriaBuilder())).getResultList();
	}

}
