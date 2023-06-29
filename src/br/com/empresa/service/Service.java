package br.com.empresa.service;

import java.io.File;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import br.com.empresa.bo.BibliaBO;
import br.com.empresa.bo.IBibliaBO;
import br.com.empresa.exception.BOException;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivroVO;


public class Service {
	
	public List<BibliaVO> consultarBiblia(Integer first, Integer pageSize, String sortField, String sortOrder, Map<String, Object> filters, LivroVO livro) throws BOException {

		IBibliaBO BibliaBO = new BibliaBO();

		return BibliaBO.consultarBiblia(first, pageSize, sortField, sortOrder, filters, livro);
	}

	public Integer consultarBibliaCount(Map<String, Object> filters, LivroVO livro) throws BOException {

		IBibliaBO BibliaBO = new BibliaBO();

		return BibliaBO.consultarBibliaCount(filters, livro);

	}
	
	public BibliaVO buscarBibliaPorId(BigInteger id) throws BOException {
		IBibliaBO BibliaBO = new BibliaBO();
		return BibliaBO.buscarBibliaPorId(id);
	}

}
