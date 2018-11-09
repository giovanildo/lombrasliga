package model;

/**
 * 
 * @author giovanildo classe grava informações do jogador de videogame
 */
public class EAtleta {
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EAtleta other = (EAtleta) obj;
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
	 * Nome do Jogador de Vídeo Game
	 */
	private String nome;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return nome;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return nome do tipo String
	 */
	public String getNome() {
		return nome;
	}

	public EAtleta(String nome) {
		super();
		this.nome = nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
