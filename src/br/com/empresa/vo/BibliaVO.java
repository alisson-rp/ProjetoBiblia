package br.com.empresa.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;

@Entity
@Table(name = "biblia")
public class BibliaVO implements Serializable{

	/**Classe object value Biblia
	 * 
	 */
	private static final long serialVersionUID = -8072398248268673188L;
	
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "sequencia", nullable = false)
	private BigInteger id;
	
	@NotNull
	@JoinColumn(name = "livro", referencedColumnName = "livro", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private LivroVO livroVO;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "capitulo", nullable = false)
	private BigInteger capitulo;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "versiculo", nullable = false)
	private BigInteger versiculo;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 504)
	@Column(name = "texto", nullable = false, length = 504)
	private String texto;

	public BibliaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BibliaVO( BigInteger id, LivroVO livroVO,
			 BigInteger capitulo, BigInteger versiculo,
			 String texto) {
		super();
		this.id = id;
		this.livroVO = livroVO;
		this.capitulo = capitulo;
		this.versiculo = versiculo;
		this.texto = texto;
	}

	public BigInteger getSequencia() {
		return id;
	}

	public void setSequencia(BigInteger id) {
		this.id = id;
	}

	public LivroVO getLivroVO() {
		return livroVO;
	}

	public void setLivroVO(LivroVO livroVO) {
		this.livroVO = livroVO;
	}

	public BigInteger getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(BigInteger capitulo) {
		this.capitulo = capitulo;
	}

	public BigInteger getVersiculo() {
		return versiculo;
	}

	public void setVersiculo(BigInteger versiculo) {
		this.versiculo = versiculo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BibliaVO [sequencia=" + id + ", "
				+ "livroVO=" + livroVO + 
				", capitulo=" + capitulo + 
				", versiculo="
				+ versiculo + 
				", texto=" + texto + 
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
		BibliaVO other = (BibliaVO) obj;
		return Objects.equals(id, other.id);
	}

}
