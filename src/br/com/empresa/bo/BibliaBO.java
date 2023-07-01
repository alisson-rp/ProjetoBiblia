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
	public List<BibliaVO> consultarBiblia(Integer first, Integer pageSize, BigInteger vIni, BigInteger vFim,
			Map<String, Object> filters, LivroVO livrof) throws BOException {
		IBibliaDAO bibliaDAO = new BibliaDAO();
		return bibliaDAO.consultarBiblia(first, pageSize, vIni, vFim, filters, livrof);
	}
}
