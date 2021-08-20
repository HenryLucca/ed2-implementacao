package avl;

import base.AbstractArvoreBinariaDePesquisa;
import base.BinaryTreePrinter;

public class ArvoreAVL extends AbstractArvoreBinariaDePesquisa<NoAVL> {

    @Override
    public NoAVL novoNode(int key) {
        return new NoAVL(key);
    }

    @Override
    public NoAVL inserir(int key) {
        NoAVL n = inserirNoHelper(raiz, key);
		raiz = balance(n,key);
        return n;
    }

    @Override
    public NoAVL procurar(int key) {
        return procurarNoHelper(raiz, key);
    } 

    @Override
    public NoAVL deletar(int key) {
        NoAVL n =  deletarNoHelper(raiz, key);
        //alteracao
        return n;
    }

    private NoAVL balance(NoAVL refenrencia, int chave) {
        int bal = refenrencia.getBalance();
        NoAVL result = refenrencia;
        if (bal == -2) {
            NoAVL left = (NoAVL)refenrencia.esquerda;
            if (left.getBalance() == +1){
                left = rotateLeft(left);
                refenrencia.setEsquerda(left);
            }
            result = rotateRight(refenrencia);
        } else if (bal == +2) {
            NoAVL right = (NoAVL)refenrencia.getDireita();
            if (right.getBalance() == -1){
                right = rotateRight(right);
                refenrencia.setDireita(right);
            }
            result = rotateLeft(refenrencia);
        }
        if (result.getPai() != null){    
            return balance(result.getPai(), chave);
        }
        return result;
    }

    //Considerar o Pai
    private NoAVL rotateLeft(NoAVL no) {
        NoAVL root = (NoAVL) no.getDireita();
        root.setPai(no.getPai());
        no.setDireita(root.getEsquerda());
        root.setEsquerda(no);
        return root;
    }

    private NoAVL rotateRight(NoAVL no) {
        NoAVL root = (NoAVL) no.getEsquerda();
        root.setPai(no.getPai());
        no.setEsquerda(root.getDireita());
        root.setDireita(no);
        return root;
    }

    //Considerar o Pai
    // private NoAVL rotateRight(NoAVL no) {
    //     NoAVL root = (NoAVL) no.esquerda;
    //     no.esquerda = root.direita;
    //     root.direita = no;
    //     return root;
    // }

    public static void main(String[] args) {
        ArvoreAVL a = new ArvoreAVL();
        // a.inserir(10);
        // a.inserir(20);
        // a.inserir(30);

        // a.inserir(30);
        // a.inserir(40);
        // a.inserir(35);
        
        // a.inserir(30);
        // a.inserir(20);
        // a.inserir(10);

        // a.inserir(30);
        // a.inserir(20);
        // a.inserir(25);


        a.inserir(1);
        a.inserir(2);
        a.inserir(3);
        a.inserir(4);
        a.inserir(5);
        a.inserir(6);
        a.inserir(7);
        a.inserir(8);
        a.inserir(9);
        a.inserir(10);
        a.inserir(11);

        
        BinaryTreePrinter<NoAVL> p = new BinaryTreePrinter<NoAVL>(a);
        p.imprimir(System.out);
    }
}
