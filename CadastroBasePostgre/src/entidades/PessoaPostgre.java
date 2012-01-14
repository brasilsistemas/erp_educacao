package entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PessoaPostgre {
	
	@Id
	@javax.persistence.SequenceGenerator(name="SEQ_PESSOA_ID", sequenceName="seq_pess_id", initialValue=1, allocationSize=9)
	@GeneratedValue(generator="SEQ_PESSOA_ID")
	private int pessoaID;
	@Column (name="Nome")
	private String nome;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pessoa", fetch=FetchType.EAGER)
	private Set<TelefonePostgre> telefones = new HashSet<TelefonePostgre>();

	public int getPessoaID() {
		return pessoaID;
	}
	public void setPessoaID(int pessoaID) {
		this.pessoaID = pessoaID;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<TelefonePostgre> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<TelefonePostgre> telefones) {
		this.telefones = telefones;
	}	
}
