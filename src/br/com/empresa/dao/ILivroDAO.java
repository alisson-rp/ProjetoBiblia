package br.com.empresa.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import br.com.empresa.exception.BOException;
import br.com.empresa.vo.LivroVO;

public interface ILivroDAO {
	
	public abstract List<LivroVO> consultarLivro(Integer first, 
			Integer pageSize, String sortField, String sortOrder, 
			Map<String, Object> filters) 
				throws BOException;
	public abstract List<LivroVO> buscaLivros() throws BOException;
}
