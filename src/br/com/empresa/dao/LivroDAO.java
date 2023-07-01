package br.com.empresa.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.com.empresa.exception.BOException;
import br.com.empresa.vo.LivroVO;

public class LivroDAO implements ILivroDAO{

	@Override
	public List<LivroVO> consultarLivro(Integer first, Integer pageSize, String sortField, String sortOrder,
			Map<String, Object> filters) throws BOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LivroVO> buscaLivros() throws BOException {
		System.out.println("----------------começando----------------");

		EntityManager em = HibernateUtil.getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<LivroVO> criteria = cb.createQuery(LivroVO.class);

		//Cláusula From
		Root<LivroVO> livroFrom = criteria.from(LivroVO.class);

		//Cláusula orderBy
		Order livroOrderBy = cb.asc(livroFrom.get("id"));

		//Atribuindo as cláusulas à consulta
		criteria.select(livroFrom);
		criteria.orderBy(livroOrderBy);

		TypedQuery<LivroVO> query = em.createQuery(criteria);

		List<LivroVO> listaLivro = query.getResultList();

		em.close();

		System.out.println("----------------terminou----------------");
		return listaLivro;
	}
}
