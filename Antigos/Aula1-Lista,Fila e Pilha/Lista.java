public class Lista <T>{
    No<T> primeiro;
    No<T> ultimo;
    int tamanho;

    public Lista(){
        primeiro = null;
        tamanho = 0;
    }

    public static void main(String[] args) {
        System.out.println("teste");
        Lista<Integer> l = new Lista<Integer>();
        l.adiciona(1);
    }

    private void adiciona(int i) {
        No<Integer> n = new No<Integer>(i);
        if(this.tamanho == 0){
            primeiro = (No<T>) n;
            ultimo = (No<T>) n;
        }else{
            this.ultimo.proximo = (No<T>) n;
            this.ultimo = (No<T>)  n;

            // n.proximo = (No<Integer>) primeiro;
            // primeiro = (No<T>) n;
        }
        this.tamanho++;
    }

    public No buscar(int numero){
        No noAtual = this.primeiro;
        while(noAtual != null){
            if(noAtual.info.equals(numero)){
                return noAtual;
            }else{
                noAtual = noAtual.proximo;
            }
        }
        return null;
    }

    public No buscarRec(int numero){
        return buscarRec(numero, primeiro);
    }

    public No buscarRec(int valor, No noAtual){
        if (noAtual.info.equals(valor)){
            return noAtual;
        }
        if (noAtual.proximo == null){
            return null;
        }
        return buscarRec(valor, noAtual.proximo);
    }

    public void remove(int valor){
        if(primeiro.info.equals(valor)){
            primeiro = primeiro.proximo;
            this.tamanho--;
            return;
        }
        No noAtual = this.primeiro;
        while(noAtual != null){
            if(noAtual.proximo.info.equals(valor)){
                noAtual.proximo = noAtual.proximo.proximo;
                this.tamanho--;
                return;
            }else{
                noAtual = noAtual.proximo;
            }
        }
    }
    
}