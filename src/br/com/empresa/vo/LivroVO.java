package br.com.empresa.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;

@Entity
@Table(name = "livro") 
public class LivroVO implements Serializable{

	/**Classe Value Object do livro
	 * 
	 */
	private static final long serialVersionUID = 8703201536278648121L;
	
	//Campo código do livro
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "livro", nullable = false)
	private BigInteger id;
	
	//Campo escritor
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "escritor", nullable = false, length = 200)
	private String escritor;
	
	//Campo de sigla
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 5)
	@Column(name = "sigla", nullable = false, length = 5)
	private String sigla;
	
	//Campo quantidade de capitulos
	@Basic(optional = false)
	@NotNull
	@Column(name = "qtd_capitulos", nullable = false)
	private BigInteger qtdCapitulos;
	
	

	public LivroVO() {
		super();
	}
	
	
	public LivroVO( BigInteger id, String escritor, String sigla, BigInteger qtdCapitulo) {
		super();
		this.id = id;
		this.escritor = escritor;
		this.sigla = sigla;
		this.qtdCapitulos = qtdCapitulo;
	}


	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getEscritor() {
		return escritor;
	}

	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public BigInteger getQtdCapitulo() {
		return qtdCapitulos;
	}

	public void setQtdCapitulo(BigInteger qtdCapitulo) {
		this.qtdCapitulos = qtdCapitulo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "LivroVO [id=" + id + 
				", escritor=" + escritor + 
				", sigla=" + sigla + 
				", qtdCapitulos=" + qtdCapitulos +
				"]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroVO other = (LivroVO) obj;
		return Objects.equals(id, other.id);
	}
	

}