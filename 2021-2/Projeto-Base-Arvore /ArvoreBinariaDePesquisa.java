public class ArvoreBinariaDePesquisa extends AbstractArvoreBinariaDePesquisa<No> {
    @Override
    public No novoNode(int key) {
        //Altera
        return new No(key);
    }

    @Override
    public No inserir(int key) {
        No n =  inserirNoHelper(raiz, key);
        //Altera
        return n;
    }

    @Override
    public No procurar(int key) {
        return procurarNoHelper(raiz, key);
    }

    @Override
    public No deletar(int key) {
        No n =  inserirNoHelper(raiz, key);
        //alteracao
        return n;
    }

    public static void main(String[] args) {
        ArvoreBinariaDePesquisa a = new ArvoreBinariaDePesquisa();
        a.inserir(52);
        a.inserir(22);
        a.inserir(85);
        a.inserir(8);
        a.inserir(43);
        a.inserir(81);
        a.inserir(96);
        a.inserir(11);
        a.inserir(26);
        a.inserir(69);
        a.inserir(74);
        a.inserir(5);
        
        BinaryTreePrinter<No> p = new BinaryTreePrinter<No>(a);
        p.imprimir(System.out);
    }
}