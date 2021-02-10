import java.util.Deque;
import java.util.LinkedList;

public abstract class AbstractArvoreBinariaDePesquisa<T extends No> {
    protected T raiz;
	
	// find the node with the minimum key
	public T minimum(T node) {
		while (node.esquerda != null) {
			node = node.getEsquerda();
		}
		return node;
	}

	public int altura() {
        return altura(this.raiz);
    }
    
    private int altura(No node) {
        if(node == null) return -1;
        else return 1 + Math.max(altura(node.esquerda), altura(node.direita));
    }

	public void preOrder() {
		preOrder(this.raiz);
	}
	
	private void preOrder(T node) {
		if (node != null) {
			System.out.println(node.getChave());
			preOrder(node.getEsquerda());
			preOrder(node.getDireita());
		}
	}

	public void inOrder() {
		inOrder(this.raiz);
	}
	
	public void imprimir() {
		Deque<T> queue = new LinkedList<T>();
			
		if (!isEmpty()) {
			queue.addLast(this.raiz);
			while (!queue.isEmpty()) {
				T current = queue.removeFirst();
					
				System.out.println(current.getChave());
					
				if(current.esquerda != null) 
					queue.addLast(current.getEsquerda());
				if(current.direita != null) 
					queue.addLast(current.getDireita());   
			}
		}
	}

	private boolean isEmpty() {
		return raiz == null;
	}

	private void inOrder(T node) {
		if (node != null) {
			inOrder(node.getEsquerda());
			System.out.println(node.getChave());
			inOrder(node.getDireita());
		}
	}

	public void posOrder() {
		posOrder(this.raiz);
	}
	
	private void posOrder(T node) {
		if (node != null) {
			posOrder(node.getEsquerda());
			posOrder(node.getDireita());
			System.out.println(node.getChave());
		}
	}

	protected T procurarNoHelper(T aux, int element) {
		while (aux != null) {   
			if (aux.getChave() == element) return aux;
			if (element < aux.getChave())
				aux = aux.getEsquerda();
			if (element > aux.getChave())
				aux = aux.getDireita();
		}
		return null;
	}

	protected T deletarNoHelper(T node, int key) {
		// search the key
		if (node == null) return node;
		else if (key < node.getChave()) node.esquerda = deletarNoHelper(node.getEsquerda(), key);
		else if (key > node.getChave()) node.direita = deletarNoHelper(node.getDireita(), key);
		else {
			// the key has been found, now delete it

			// case 1: node is a leaf node
			if (node.esquerda == null && node.direita == null) {
				node = null;
			}

			// case 2: node has only one child
			else if (node.esquerda == null) {
				node = node.getDireita();
			}

			else if (node.direita == null) {
				node = node.getEsquerda();
			}

			// case 3: has both children
			else {
				T temp = minimum(node.getDireita());
				node.setChave(temp.getChave());
				node.direita = deletarNoHelper(node.getDireita(), temp.getChave());
			}

		} 
		return node;
	}

    protected T inserirNoHelper(No atual, int chave) {
        T node = newNode(chave);
		node.setChave(chave);

		No folhaCorreta = null;
		//No atual = this.raiz;

		while (atual != null) {
			folhaCorreta = atual;
			if (node.getChave() < atual.getChave()) {
				atual = atual.esquerda;
			} else {
				atual = atual.direita;
			}
		}

		// <<folhaCorreta>> é pai de <<node>>
		node.pai = folhaCorreta;
		if (folhaCorreta == null) {
			raiz = node;
		} else if (node.getChave() < folhaCorreta.getChave()) {
			folhaCorreta.esquerda = node;
		} else {
			folhaCorreta.direita = node;
		}

        return node;
    }

    public abstract T newNode(int key);
	public abstract T inserir(int key);
	public abstract T procurar(int key);
	public abstract T deletar(int key);
}