package br.com.empresa.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
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
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.hibernate.Session;

import br.biblia.Principal;
import br.com.empresa.exception.BOException;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivroVO;

public class BibliaDAO implements IBibliaDAO{

	@Override
	public BibliaVO buscarBibliaPorId(BigInteger id) throws BOException {
		System.out.println("Começando filtro completo");

		EntityManager em = HibernateUtil.getEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Tuple> criteria = cb.createQuery(Tuple.class);

		//Cláusula From
		Root<BibliaVO> bibliaFrom = criteria.from(BibliaVO.class);
		Join<BibliaVO, LivroVO> livroFrom = bibliaFrom.join("client");

		criteria.multiselect(bibliaFrom, livroFrom);

		Predicate bibliaWhere = cb.equal(livroFrom, cliente);

		if (filters != null) {

			for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {

				String filterProperty = it.next();
				String filterValue = filters.get(filterProperty).toString();

				if (filterProperty.equals("id")) {

					bibliaWhere = cb.and(bibliaWhere, cb.equal(bibliaFrom.get(filterProperty), filterValue));

				} else if (filterProperty.equals("client")) {

					bibliaWhere = cb.and(bibliaWhere, cb.like(cb.lower(livroFrom.get("descri")), "%" + filterValue.toLowerCase() + "%"));

				} else {
					bibliaWhere = cb.and(bibliaWhere, cb.like(cb.lower(bibliaFrom.get(filterProperty)), "%" + filterValue.toLowerCase() + "%"));
				}
			}
		}

		Order bibliaOrderBy = cb.asc(bibliaFrom.get("descri"));

		if (sortField != null) {

			if (sortOrder.equals(Principal.ASCENDING)) {
				bibliaOrderBy = cb.asc(bibliaFrom.get(sortField));
			} else if (sortOrder.equals(Principal.DESCENDING)) {
				bibliaOrderBy = cb.desc(bibliaFrom.get(sortField));
			}
		}

		//Where
		criteria.where(bibliaWhere);
		//Order by
		criteria.orderBy(bibliaOrderBy);

		TypedQuery<Tuple> query = em.createQuery(criteria);

		//Seta a quantidade máxima de elementos a serem retornados e primeiro.
		query.setFirstResult(first);
		if (pageSize != 0) {
			query.setMaxResults(pageSize);
		}

		List<Tuple> tuples = query.getResultList();

		//Monta o retorno da função.
		List<BibliaVO> ret = new ArrayList<BibliaVO>();
		if (tuples != null) {

			for (Tuple tuple : tuples) {

				LivroVO livroAux = tuple.get(livroFrom);

				BibliaVO BibliaVO = tuple.get(bibliaFrom);
				BibliaVO.setLivroVO(livroAux);

				ret.add(BibliaVO);

			}
		}

		em.close();

		System.out.println("Terminando filtro completo");

		return ret;
	}

	@Override
	public List<BibliaVO> consultarBiblia(Integer first, Integer pageSize, String sortField, String sortOrder,
			Map<String, Object> filters, LivroVO livro) throws BOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer consultarBibliaCount(Map<String, Object> filters, LivroVO cliente) throws BOException {
		// TODO Auto-generated method stub
		return null;
	}

}
