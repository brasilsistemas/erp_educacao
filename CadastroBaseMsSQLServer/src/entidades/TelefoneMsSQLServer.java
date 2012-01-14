package entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class TelefoneMsSQLServer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column (name="PessoaID")
	private int pessoaID;
	@Column (name="Telefone")
	private String telefone;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.PERSIST, CascadeType.REFRESH})
	private PessoaMsSQLServer pessoa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPessoaID() {
		return pessoaID;
	}
	public void setPessoaID(int pessoaID) {
		this.pessoaID = pessoaID;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public PessoaMsSQLServer getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaMsSQLServer pessoa) {
		this.pessoa = pessoa;
	}
}
