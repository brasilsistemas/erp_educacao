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
public class PessoaFirebird {
	
	@Id
	@javax.persistence.SequenceGenerator(name="SEQ_PESSOA_ID", sequenceName="seq_pess_id", initialValue=1, allocationSize=9)
	@GeneratedValue(generator="SEQ_PESSOA_ID")
	private int pessoaID;
	@Column (name="Nome")
	private String nome;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pessoa", fetch=FetchType.EAGER)
	private Set<TelefoneFirebird> telefones = new HashSet<TelefoneFirebird>();

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

	public Set<TelefoneFirebird> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<TelefoneFirebird> telefones) {
		this.telefones = telefones;
	}	
}
