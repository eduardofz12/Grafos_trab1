import busca.BuscaEmLargura;
import model.Grafo;
import model.Vertice;

/**
 *
 * @author Hugo Marcel Larsen e Murilo Bartel
 */

public class Main {

	public static void main(String[] args) {

		Vertice vEnt = new Vertice("Entrada");
		Vertice vSai = new Vertice("Saida");
		Vertice vA = new Vertice("A");
		Vertice vB = new Vertice("B");
		Vertice vC = new Vertice("C");
		Vertice vD = new Vertice("D");
		Vertice vE = new Vertice("E");
		Vertice vF = new Vertice("F");
		Vertice vG = new Vertice("G");
		Vertice vH = new Vertice("H");
		Vertice vI = new Vertice("I");
		Vertice vJ = new Vertice("J");
		Vertice vK = new Vertice("K");
		Vertice vL = new Vertice("L");
		Vertice vM = new Vertice("M");
		Vertice vQ = new Vertice("*");

		vEnt.addAdjacencia(vA);
		vA.addAdjacencia(vF);
		vF.addAdjacencia(vC);
		vC.addAdjacencia(vB);
		vB.addAdjacencia(vD);
		vC.addAdjacencia(vD);
		vF.addAdjacencia(vJ);
		vJ.addAdjacencia(vH);
		vH.addAdjacencia(vG);
		vJ.addAdjacencia(vG);
		vJ.addAdjacencia(vQ);
		vQ.addAdjacencia(vI);
		vI.addAdjacencia(vL);
		vL.addAdjacencia(vM);
		vM.addAdjacencia(vK);
		vK.addAdjacencia(vSai);
		vA.addAdjacencia(vK);
		vC.addAdjacencia(vE);
		vE.addAdjacencia(vI);
		vI.addAdjacencia(vM);

		Grafo grafo = new Grafo();
		grafo.addVertice(vEnt);
		grafo.addVertice(vSai);
		grafo.addVertice(vA);
		grafo.addVertice(vB);
		grafo.addVertice(vC);
		grafo.addVertice(vD);
		grafo.addVertice(vE);
		grafo.addVertice(vF);
		grafo.addVertice(vG);
		grafo.addVertice(vH);
		grafo.addVertice(vI);
		grafo.addVertice(vJ);
		grafo.addVertice(vK);
		grafo.addVertice(vL);
		grafo.addVertice(vM);
		grafo.addVertice(vQ);

		BuscaEmLargura buscaLargura = new BuscaEmLargura();

		try {
			System.out.println(buscaLargura.buscar(grafo, "Entrada", "*"));
			System.out.println(buscaLargura.buscar(grafo, "*", "Saida"));

		} catch (IllegalArgumentException I) {
			System.out.println(I.getMessage());
		}

	}

}
