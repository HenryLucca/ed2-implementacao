package avl;

import base.No;

public class NoAVL extends No{

    public NoAVL(int chave) {
        super(chave);
    }

    public int getAltura(){
        int alturaEsquerda = getEsquerda() == null ? 0 : ((NoAVL) getEsquerda()).getAltura();
        int alturaDireita = getDireita() == null ? 0 : ((NoAVL) getDireita()).getAltura();  
        int altura = Math.max(alturaDireita, alturaEsquerda) + 1;
        return altura;
    }

    public int getBalance() {
        int alturaDireita = getDireita() == null ? 0 : ((NoAVL) getDireita()).getAltura(); 
        int alturaEsquerda = getEsquerda() == null ? 0 : ((NoAVL) getEsquerda()).getAltura(); 
        return alturaDireita - alturaEsquerda;
    }

    @Override
    public String toString(){
        return "No AVL de chave "+ getChave();
    }
    
}
