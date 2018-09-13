package model;

import java.util.ArrayList;

/**
 *
 * @author Hugo Marcel Larsen e Murilo Bartel
 */

public class Grafo {

	private ArrayList<Vertice> vertices;

	public Grafo() {
		vertices = new ArrayList<>();
	}

	public void addVertice(Vertice v) {
		vertices.add(v);
	}

	public Vertice getVerticePorNome(String nome) {
		for (Vertice v : vertices) {
			if (v.getNome().equals(nome)) {
				return v;
			}
		}

		return null;
	}

	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

}
