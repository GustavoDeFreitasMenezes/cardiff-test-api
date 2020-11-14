package com.cardiff.api.repository.query.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.cardiff.api.model.Departamento;
import com.cardiff.api.model.FuncionarioDepartamento;
import com.cardiff.api.repository.filter.FuncionarioDepartamentoFilter;
import com.cardiff.api.repository.query.FuncionarioDepartamentoRepositoryQuery;

public class FuncionarioDepartamentoRepositoryImpl implements FuncionarioDepartamentoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FuncionarioDepartamento> pesquisar(FuncionarioDepartamentoFilter dff) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<FuncionarioDepartamento> criteria = builder.createQuery(FuncionarioDepartamento.class);
		
		Root<FuncionarioDepartamento> root = criteria.from(FuncionarioDepartamento.class);
		
		
		List<Predicate> lp = new ArrayList<>();
		
		if (!StringUtils.isEmpty(dff.getDepartamentoId())) {
			Join<FuncionarioDepartamento, Departamento> joinDepto = root.join("departamentoId");
			
			lp.add(
				builder.equal(
					joinDepto.get("departamentoId"), 
					dff.getDepartamentoId()
				)
			);			
		}
		
		if(lp.size() > 0) {
			Predicate[] predicates = lp.toArray(new Predicate[lp.size()]);
			criteria.where(predicates);
		}		
		
		TypedQuery<FuncionarioDepartamento> query = manager.createQuery(criteria);
		return query.getResultList();
	}

}
