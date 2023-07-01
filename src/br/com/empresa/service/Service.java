package br.com.empresa.service;

import java.io.File;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import br.com.empresa.bo.BibliaBO;
import br.com.empresa.bo.IBibliaBO;
import br.com.empresa.bo.ILivroBO;
import br.com.empresa.bo.LivroBO;
import br.com.empresa.exception.BOException;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivroVO;


public class Service {
	
	public List<BibliaVO> consultarBiblia(Integer first, Integer pageSize, BigInteger vIni, BigInteger vFim, Map<String, Object> filters, LivroVO livrof) throws BOException {

		IBibliaBO BibliaBO = new BibliaBO();

		return BibliaBO.consultarBiblia(first, pageSize, vIni, vFim, filters, livrof);
	}

	public List<LivroVO> buscaLivros() throws BOException{
		ILivroBO livroBO = new LivroBO();
		return livroBO.buscaLivros();
	}

}
