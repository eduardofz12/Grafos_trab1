package busca;

import java.util.ArrayList;

import fila.FilaVetor;
import model.Grafo;
import model.Vertice;

public class BuscaEmLargura {

	private enum Cor {
		BRANCO, CINZA, PRETO;
	}

	public String buscar(Grafo g, String nomeVerticeInicial, String nomeVerticeFinal) {
		// buscar as informa��es do v�rtice inicial
		Vertice s = g.getVerticePorNome(nomeVerticeInicial);
		int posVerticeInicial = g.getVertices().indexOf(s);

		if (s == null) {
			throw new IllegalArgumentException("V�rtice inicial '" + nomeVerticeInicial + "' n�o encontrado!");
		}

		// buscar as informa��es do v�rtice final
		Vertice f = g.getVerticePorNome(nomeVerticeFinal);
		int posVerticeFinal = g.getVertices().indexOf(f);

		if (f == null) {
			throw new IllegalArgumentException("V�rtice final '" + nomeVerticeFinal + "' n�o encontrado!");
		}

		// pegar o total de v�rtices do grafo
		int totalVertices = g.getVertices().size();

		// iniciar as vari�veis de controle
		Cor[] cor = new Cor[totalVertices];
		Vertice[] pi = new Vertice[totalVertices];
		int[] d = new int[totalVertices];

		// iniciar as informa��es dos v�rtices
		for (int i = 0; i < totalVertices; i++) {
			cor[i] = Cor.BRANCO;
			pi[i] = null;
			d[i] = -1;
		}

		// inicia as informa��es do v�rtice inicial
		cor[posVerticeInicial] = Cor.CINZA;
		d[posVerticeInicial] = 0;

		FilaVetor<Vertice> q = new FilaVetor<>(totalVertices);
		q.inserir(s);

		Vertice u;
		int posVerticeFila;
		int posVerticeAdj;

		// enquanto n�o est� vazia, desempilha e empilha suas adjac�ncias
		while (!q.estaVazia()) {
			u = q.retirar();
			posVerticeFila = g.getVertices().indexOf(u);

			for (Vertice v : u.getAdjacencias()) {
				posVerticeAdj = g.getVertices().indexOf(v);

				if (cor[posVerticeAdj] == Cor.BRANCO) {
					// se o adj for branco ent�o o adiciona na fila e percorre suas adj
					q.inserir(v);
					cor[posVerticeAdj] = Cor.CINZA;
					pi[posVerticeAdj] = u;
					d[posVerticeAdj] = d[posVerticeFila] + 1;
				}
			}

			cor[posVerticeFila] = Cor.PRETO;
		}

		// retornar o caminho solicitado a partir de um array
		// ele ser� incrementado de forma que o filho fique primeiro e depois o pai
		ArrayList<Vertice> caminhoVertices = new ArrayList<>();
		caminhoVertices.add(f); // come�ar pelo �ltimo
		u = pi[posVerticeFinal];

		while (u != null) {
			caminhoVertices.add(u);
			u = pi[g.getVertices().indexOf(u)];
		}

		// montar a formata��o do caminho
		StringBuilder caminhoExtenso = new StringBuilder();
		caminhoExtenso.append("Caminho de '" + s.getNome() + "' at� '" + f.getNome() + "':\n");

		int j = 0;

		for (int i = caminhoVertices.size() - 1; i >= 0; i--) {
			if (i > 0) {
				caminhoExtenso.append(caminhoVertices.get(i).getNome()).append(" -> ");
				j++;
			} else {
				caminhoExtenso.append(caminhoVertices.get(i).getNome());
			}
		}

		return caminhoExtenso.append("\nTotal de " + j + " etapas.\n").toString();
	}

}
