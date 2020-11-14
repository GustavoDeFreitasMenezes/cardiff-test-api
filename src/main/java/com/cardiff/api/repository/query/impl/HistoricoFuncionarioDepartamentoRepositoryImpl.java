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
import com.cardiff.api.model.Funcionario;
import com.cardiff.api.model.FuncionarioDepartamento;
import com.cardiff.api.model.HistoricoFuncionarioDepartamento;
import com.cardiff.api.repository.filter.HistoricoFuncionarioDepartamentoFilter;
import com.cardiff.api.repository.query.HistoricoFuncionarioDepartamentoRepositoryQuery;

public class HistoricoFuncionarioDepartamentoRepositoryImpl implements HistoricoFuncionarioDepartamentoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<HistoricoFuncionarioDepartamento> pesquisar(HistoricoFuncionarioDepartamentoFilter h) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<HistoricoFuncionarioDepartamento> criteria = builder.createQuery(HistoricoFuncionarioDepartamento.class);
		
		Root<HistoricoFuncionarioDepartamento> root = criteria.from(HistoricoFuncionarioDepartamento.class);
		
		List<Predicate> lp = new ArrayList<>();
		
		if (!StringUtils.isEmpty(h.getFuncionarioId())) {
			Join<HistoricoFuncionarioDepartamento, Funcionario> joinDepto = root.join("funcionarioId");
			
			lp.add(
				builder.equal(
					joinDepto.get("funcionarioId"), 
					h.getFuncionarioId()
				)
			);			
		}
		
		if(lp.size() > 0) {
			Predicate[] predicates = lp.toArray(new Predicate[lp.size()]);
			criteria.where(predicates);
		}		
		
		TypedQuery<HistoricoFuncionarioDepartamento> query = manager.createQuery(criteria);
		return query.getResultList();
	}

}
