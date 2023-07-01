package br.com.empresa.bo;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import br.com.empresa.dao.ILivroDAO;
import br.com.empresa.dao.LivroDAO;
import br.com.empresa.exception.BOException;
import br.com.empresa.vo.LivroVO;

public class LivroBO implements ILivroBO{

	@Override
	public List<LivroVO> consultarLivro(Integer first, Integer pageSize, String sortField, String sortOrder,
			Map<String, Object> filters) throws BOException {
		
		ILivroDAO livroDAO = new LivroDAO();
		
		return livroDAO.consultarLivro(first, pageSize, sortField, sortOrder, filters);
	}

	public List<LivroVO> buscaLivros() throws BOException {
		ILivroDAO livroDAO = new LivroDAO();
		return livroDAO.buscaLivros();
	}


}
