	import java.lang.reflect.Array;
	import java.util.*;
	import java.io.*;
	import java.io.FileReader;

	class Validas{
		String nome;
		int quantidade;
		int invalidas;
		Validas prox;

		public int getInvalidas() {
			return invalidas;
		}

		public void setInvalidas(int invalidas) {
			this.invalidas = invalidas;
		}

		public Validas getProx() {
			return prox;
		}

		public void setProx(Validas prox) {
			this.prox = prox;
		}

		public Validas(String nome, int quantidade, int invalidas) {
			this.nome = nome;
			this.quantidade = quantidade;
			this.invalidas = invalidas;
			this.prox=null;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
	}
	class ListaX{
		Validas topo;

		public void insereInicio(String nome, int quantidade, int invalidade){
			Validas aux = new Validas(nome,quantidade, invalidade);
			aux.setProx(topo);
			topo = aux;

		}
		public void imprimeListaX(){
			Validas aux = topo;
			System.out.println("Respostas válidas:");

			while (aux!=null){
				if (aux.getNome()!=null){
				System.out.println(aux.getNome()+": "+aux.getQuantidade());
				}
				aux=aux.prox;
			}
			System.out.println();

		}
		public void imprimeListaInvalidades(){
			Validas aux = topo;
			System.out.println("Respostas Inválidas");

			while (aux!=null){
				if (aux.getNome()!=null){
					System.out.println(aux.getNome()+": "+aux.getInvalidas());
				}
				aux=aux.prox;
			}
		}

	}

	class NoValidados{
		int id;
		String nome;
		int porcentagem;
		NoValidados prox;


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

		public int getPorcentagem() {
			return porcentagem;
		}

		public void setPorcentagem(int porcentagem) {
			this.porcentagem = porcentagem;
		}

		public NoValidados(int id, String nome, int porcentagem) {
			this.id = id;
			this.nome = nome;
			this.porcentagem = porcentagem;
		}

		public NoValidados getProx() {
			return prox;
		}

		public void setProx(NoValidados prox) {
			this.prox = prox;
		}
	}
	class NovaLista{
		NoValidados topo2;
		int id;

		public void insereInicio(int id, String nome, int porcentagem){
			NoValidados aux = new NoValidados(id, nome, porcentagem);
			aux.setProx(topo2);
			topo2 = aux;

		}
		public void imprimeNova(NovaLista nova){
			NoValidados aux = nova.topo2;
			System.out.print(+aux.getId()+": ");
			while (aux!=null){
				System.out.print(aux.getNome()+" "+aux.getPorcentagem()+"% fav"+", ");
				aux = aux.prox;
			  //  break;
			}
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}
	class VetorLista {
		NovaLista vetor[];

		public VetorLista(int tamanho) {
			vetor = new NovaLista[tamanho];
			for (int i = 0; i < vetor.length; i++) {
				vetor[i] = new NovaLista();
			}
		}

		public void imprimeTabela() {
			int i;
			NovaLista atual;
			System.out.println("Fav responde por perguntas:");

			for (i = 0; i < vetor.length; i++) {
				atual = vetor[i];
				atual.imprimeNova(atual);
				System.out.println();
			}
			System.out.println();
		}

		public void insere(int id, String nome, int porcentagem) {
			int resultado = id % vetor.length;
			vetor[resultado].insereInicio(id, nome, porcentagem);
		}
	}
	class No {
		int id;
		int dado01=0;
		int dado2=0;
		int dado4=0;
		int dadoInv=0;
		int total=0;
		int contador=0;

		No prox;

		public int getDado01() {
			return dado01;
		}

		public void setDado01(int dado01) {
			this.dado01 = dado01;
		}

		public int getDado2() {
			return dado2;
		}

		public void setDado2(int dado2) {
			this.dado2 = dado2;
		}

		public int getDado4() {
			return dado4;
		}

		public void setDado4(int dado4) {
			this.dado4 = dado4;
		}

		public int getDadoInv() {
			return dadoInv;
		}

		public void setDadoInv(int dadoInv) {
			this.dadoInv = dadoInv;
		}

		public No getProx() {
			return prox;
		}

		public void setProx(No prox) {
			this.prox = prox;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public No(int id, int dado) {
			this.id = id;
			if(dado == 0 || dado == 1){
				this.dado01 = getDado01()+1;
			}
			if(dado == 2){
				this.dado2 = getDado2()+1;
			}
			if(dado == 3 || dado == 4){
				this.dado4 = getDado4()+1;
			}
			if(dado !=  0 && dado !=  1 && dado !=  2 && dado !=  3 && dado != 4){
				this.dadoInv = getDadoInv()+1;
			}

			this.prox = null;
			this.contador=0;
		}

		public int getContador() {
			return contador;
		}

		public void setContador(int contador) {
			this.contador = contador;
		}
	}

	class ListaEncadeada {
		No topo;
		String nome;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public ListaEncadeada() {
			topo = null;
		}

		public No buscaId(int id, ListaEncadeada lista) {
			No aux = lista.topo;

			while (aux != null) {
				if (aux.getId() == id) {
					return aux;
				}
				aux = aux.getProx();
			}
			return null;
		}


		public void Insere(int id, int dado, ListaEncadeada lista) {
			if(buscaId(id, lista)!=null){

				if(buscaId(id,lista)!=null){

				No aux = buscaId(id, lista);
				if(dado == 0 || dado == 1){
					aux.setDado01(aux.getDado01()+1);

					aux.setTotal(aux.getTotal()+1);
				}
				if(dado == 2){
					aux.setDado2(aux.getDado2()+1);

					aux.setTotal(aux.getTotal()+1);
				}
				if(dado == 3 || dado == 4 && aux.getId()==id){
					aux.setDado4(aux.getDado4()+1);
					aux.setTotal(aux.getTotal()+1);
				}
				if(dado !=  0 && dado !=  1 && dado !=  2 && dado !=  3 && dado != 4){
					aux.setDadoInv(aux.getDadoInv()+1);

				}}
			}else{
				No aux = new No(id,dado);
				aux.setProx(topo);
				topo = aux;

				if(dado == 0 || dado == 1){
					aux.setTotal(aux.getTotal()+1);
				}
				if(dado == 2){
					aux.setTotal(aux.getTotal()+1);
				}
				if(dado == 3 || dado == 4){
					aux.setTotal(aux.getTotal()+1);
				}
				if(dado !=  0 && dado !=  1 && dado !=  2 && dado !=  3 && dado != 4){
					aux.setDadoInv(aux.getDadoInv()+1);
				}

			}

		}


		public void Porcentagem(ListaEncadeada lista, No auxi) {
			No aux = auxi;
			int resultado = 0;
			int total = 0;
						total = aux.getTotal();

						resultado = ((aux.getDado01() * 100) / total);
						aux.setDado01(resultado);

						int resultado2 = ((aux.getDado2()*100)/total);
						aux.setDado2(resultado2);

						int resultado3 = ((aux.getDado4()*100)/total);
						aux.setDado4(resultado3);
		}

		public void OrdenaDesc(){

			No aux = topo;
			while(aux != null){
				No prox = aux.prox;
				while(prox != null){
					if (aux.getDado01() < prox.getDado01()) {
						int s = aux.getDado01();
						int tipo2 = aux.getDado2();
						int tipo4 = aux.getDado4();
						int tipoInva = aux.getDadoInv();
						int id = aux.getId();

						aux.setId(prox.getId());
						aux.setDado01(prox.getDado01());
						aux.setDado2(prox.getDado2());
						aux.setDado4(prox.getDado4());
						aux.setDadoInv(prox.getDadoInv());


						prox.setId(id);
						prox.setDado01(s);
						prox.setDado2(tipo2);
						prox.setDado4(tipo4);
						prox.setDadoInv(tipoInva);
					}
					prox = prox.prox;
				}
				aux = aux.prox;
			}
		}
		public void zerar(ListaEncadeada lista){
			lista.topo=null;
		}
		public void CalculaPorcentagem(ListaEncadeada lista){
			No aux = lista.topo;
			while(aux!=null){
				lista.Porcentagem(lista,aux);
				aux = aux.prox;
			}
		}
		public void imprimelista(ListaEncadeada lista){
			No aux = lista.topo;
			if (lista.getNome()!=null) {
				System.out.println(lista.getNome());
				while (aux != null) {
					System.out.println(aux.getId() + ": " + aux.getDado01() + "% " + "fav" + "," + " " + aux.getDado2() + "%" + " neutro" + ", " + aux.getDado4() + "% " + "unfav");
					aux = aux.getProx();
				}
			}
		}
	}

	public class Pesquisa {
		public static void main(String args[]) throws IOException {
			int soma=0;
			int soma2=0;
			VetorLista lista2 = new VetorLista(5);
			ListaX listaX = new ListaX();

			File dir = new File(new File(".").getCanonicalPath());
			String[] stringDir = dir.list();

			for (int i = 0; i < stringDir[i].length(); i++) {

				ListaEncadeada lista = new ListaEncadeada();
				String nova = null;
			   if (stringDir[i].contains("txt")){

					try {
						BufferedReader br = new BufferedReader(new FileReader(stringDir[i]));

						 String line=null;
						 line = br.readLine();
						 nova= line;
						 lista.setNome(nova);
						 while (br.ready()){
							 if(line!=null){
								line = br.readLine();
								String[]  array = line.split(" ");
								lista.Insere(Integer.parseInt(array[0]),Integer.parseInt(array[1]),lista);
								array=null;
							 }
						}
						br.close();
					} catch (IOException ioe) {
					}
				}


						lista.CalculaPorcentagem(lista);
						lista.OrdenaDesc();
						soma=0;
						soma2=0;
						No aux = lista.topo;
						while(aux!=null){
							lista2.insere(aux.getId(),lista.getNome(),aux.getDado01());
							soma = soma+aux.getTotal();
							soma2 = soma2+aux.getDadoInv();
							aux=aux.prox;
						}

					    listaX.insereInicio(lista.getNome(),soma,soma2);
						lista.imprimelista(lista);;
						lista.zerar(lista);
						System.out.println();


			}
            lista2.imprimeTabela();
            listaX.imprimeListaX();
            listaX.imprimeListaInvalidades();
		}
	}
