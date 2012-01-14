package entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TelefonePostgre {
	
	@Id
	@javax.persistence.SequenceGenerator(name="SEQ_TELEFONE_ID", sequenceName="seq_tel_id", initialValue=1, allocationSize=9)
	@GeneratedValue(generator="SEQ_TELEFONE_ID")
	private int telefoneID;
	@Column (name="PessoaID")
	private int pessoaID;
	@Column (name="Telefone")
	private String telefone;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.PERSIST, CascadeType.REFRESH})
	private PessoaPostgre pessoa;

	public int getTelefoneID() {
		return telefoneID;
	}
	public void setTelefoneID(int telefoneID) {
		this.telefoneID = telefoneID;
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

	public PessoaPostgre getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaPostgre pessoa) {
		this.pessoa = pessoa;
	}
}
