package entidades;

import java.util.ArrayList;

import entidades.Telefone;

public class Telefones {
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();

	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	public void addTelefone(Telefone telefone){
		this.telefones.add(telefone);		
	}
	
	public int quantidade(){
		return this.telefones.size();
	}
	
	public Telefone obterTelefone(int index){
		return telefones.get(index);
	}

}
