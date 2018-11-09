package model;

/**
 * 
 * @author giovanildo
 *
 *         Essa classe grava informações referente ao Clube de Futebol
 */
public class Clube {
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clube other = (Clube) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	private int id;
	/**
	 * nome do clube
	 */
	private String nome;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Clube(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	/**
	 * 
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome permite colocar o nome do clube
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
