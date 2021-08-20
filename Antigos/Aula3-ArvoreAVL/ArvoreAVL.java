public class ArvoreAVL extends AbstractArvoreBinariaDePesquisa<NoAVL> {
    @Override
    public NoAVL novoNode(int key) {
        return new NoAVL(key);
    }

    @Override
    public NoAVL inserir(int key) {
        No n =  inserirNoHelper(raiz, key);
        verificaBalanceia(n);
        //alteração
        return n;
    }

    private void verificaBalanceia(No n) {
        // recalcula o fator de balanceamento n
        //if (n.fator > 1){
        //    if (n.direita.fator < -1){
                // rotacaoDireita (n.direita);
        //    }
        //  rotacaoEsquerda(n);
        //}
        // vejo os outros casos
        if (n != raiz){
            verificaBalanceia(n.pai);
        }
    }

    @Override
    public NoAVL procurar(int key) {
        return procurarNoHelper(raiz, key);
    }

    @Override
    public NoAVL deletar(int key) {
        No n =  inserirNoHelper(raiz, key);
        //alteracao
        return n;
    }

    public static void main(String[] args) {
        ArvoreAVL a = new ArvoreAVL();
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
        
        BinaryTreePrinter<NoAVL> p = new BinaryTreePrinter<NoAVL>(a);
        p.imprimir(System.out);
    }
}