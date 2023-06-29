package br.com.empresa.bo;

import java.math.BigInteger;

import java.util.List;
import java.util.Map;

import br.com.empresa.exception.BOException;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivroVO;

public interface IBibliaBO {
	/**
	 * 
	 * @param id
	 * @return
	 * @throws BOException
	 */
	public abstract BibliaVO buscarBibliaPorId(BigInteger id) throws BOException;
	
	/**
	 * 
	 * @param first
	 * @param pageSize
	 * @param sortField
	 * @param sortOrder
	 * @param filters
	 * @param livro
	 * @return
	 * @throws BOException
	 */
	public abstract List<BibliaVO> consultarBiblia(Integer first, Integer pageSize, String sortField, String sortOrder, Map<String, Object> filters, LivroVO livro) throws BOException;
	
	/**
	 * 
	 * @param filters
	 * @param livro
	 * @return
	 * @throws BOException
	 */
	public abstract Integer consultarBibliaCount(Map<String, Object> filters, LivroVO livro) throws BOException;

}
