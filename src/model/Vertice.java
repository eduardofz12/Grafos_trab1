package model;

import java.util.ArrayList;

/**
 *
 * @author Hugo Marcel Larsen e Murilo Bartel
 */

public class Vertice {

	private String nome;
	private ArrayList<Vertice> adjacencias;

	public Vertice(String nome) {
		this.setNome(nome);
		this.adjacencias = new ArrayList<>();
	}

	public void addAdjacencia(Vertice v) {
		adjacencias.add(v);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Vertice> getAdjacencias() {
		return adjacencias;
	}

	public void setAdjacencias(ArrayList<Vertice> adjacencias) {
		this.adjacencias = adjacencias;
	}

}
