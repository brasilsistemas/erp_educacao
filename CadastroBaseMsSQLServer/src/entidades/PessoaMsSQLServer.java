package entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PessoaMsSQLServer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "Nome")
	private String nome;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pessoa", fetch=FetchType.EAGER)
	private Set<TelefoneMsSQLServer> telefones = new HashSet<TelefoneMsSQLServer>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<TelefoneMsSQLServer> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<TelefoneMsSQLServer> telefones) {
		this.telefones = telefones;
	}
}
