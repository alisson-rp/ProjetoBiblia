package br.com.empresa.bo;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import br.com.empresa.dao.BibliaDAO;
import br.com.empresa.dao.IBibliaDAO;
import br.com.empresa.exception.BOException;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivroVO;

public class BibliaBO implements IBibliaBO{

	@Override
	public BibliaVO buscarBibliaPorId(BigInteger id) throws BOException {
		IBibliaDAO bibliaDAO = new BibliaDAO();
		
		if (id == null) {
			throw new BOException("O id da Biblia não deveria ser nulo.");
		}
		
		return bibliaDAO.buscarBibliaPorId(id);
	}

	@Override
	public List<BibliaVO> consultarBiblia(Integer first, Integer pageSize, String sortField, String sortOrder,
			Map<String, Object> filters, LivroVO livro) throws BOException {
		IBibliaDAO bibliaDAO = new BibliaDAO();
		return bibliaDAO.consultarBiblia(first, pageSize, sortField, sortOrder, filters, livro);
	}

	@Override
	public Integer consultarBibliaCount(Map<String, Object> filters, LivroVO livro) throws BOException {
		IBibliaDAO bibliaDAO = new BibliaDAO();
		return bibliaDAO.consultarBibliaCount(filters, livro);
	}
}
