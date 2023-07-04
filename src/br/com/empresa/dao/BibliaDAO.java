package br.com.empresa.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.empresa.exception.BOException;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivroVO;

public class BibliaDAO implements IBibliaDAO {

	@Override
	public List<BibliaVO> consultarBiblia(Integer first, Integer pageSize, BigInteger vIni, BigInteger vFim,
			Map<String, Object> filters, LivroVO livrof) throws BOException {

		System.out.println("Consultando com tupla");

		EntityManager em = HibernateUtil.getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteria = cb.createQuery(Tuple.class);

		Root<BibliaVO> bibliaFrom = criteria.from(BibliaVO.class);
		Join<BibliaVO, LivroVO> livroFrom = bibliaFrom.join("livroVO");

		criteria.multiselect(bibliaFrom, livroFrom);

		Predicate bibliaWhere = cb.equal(livroFrom, livrof);

		if (filters != null) {

			for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {

				String filterProperty = it.next();
				String filterValue = filters.get(filterProperty).toString();

				if (filterProperty.equals("capitulo")) {
					bibliaWhere = cb.and(bibliaWhere, cb.equal(bibliaFrom.get(filterProperty), filterValue));
				}
				if(vIni != null && vFim != null) {
					bibliaWhere = cb.and(bibliaWhere, cb.between(bibliaFrom.get("versiculo"), vIni, vFim));
				}
				
				if (filterProperty.equals("texto")) {
					bibliaWhere = cb.and(bibliaWhere,
							cb.like(cb.lower(bibliaFrom.get(filterProperty)), "%" + filterValue.toLowerCase() + "%"));
				}
			}
		}

		criteria.where(bibliaWhere);

		TypedQuery<Tuple> query = em.createQuery(criteria);

		query.setFirstResult(first);
		if (pageSize != 0) {
			query.setMaxResults(pageSize);
		}

		List<Tuple> tuples = query.getResultList();

		List<BibliaVO> ret = new ArrayList<BibliaVO>();
		if (tuples != null) {

			for (Tuple tuple : tuples) {

				LivroVO livroAux = tuple.get(livroFrom);

				BibliaVO bibliaVO = tuple.get(bibliaFrom);
				bibliaVO.setLivroVO(livroAux);
				ret.add(bibliaVO);
			}
		}

		em.close();

		System.out.println("Término da consulta com tupla");
		return ret;
	}
}
