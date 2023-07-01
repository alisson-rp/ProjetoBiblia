package br.com.empresa.bo;

import java.math.BigInteger;

import java.util.List;
import java.util.Map;

import br.com.empresa.exception.BOException;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivroVO;

public interface IBibliaBO {
	
	public abstract List<BibliaVO> consultarBiblia(Integer first, Integer pageSize, BigInteger vIni, BigInteger vFim, Map<String, Object> filters, LivroVO livrof) throws BOException;

}
