package base;

public class No {
    private int chave;

    public No esquerda;
    public No direita;
    public No pai;

    public No(int chave) {
        this.chave = chave;
    }

    public int getChave() {
        return chave;
    }

    @SuppressWarnings("unchecked")
    public <T extends No> T getPai() {
        return (T) pai;
    }

    @SuppressWarnings("unchecked")
    public <T extends No> T getEsquerda() {
        return (T) esquerda;
    }

    @SuppressWarnings("unchecked")
    public <T extends No> T getDireita() {
        return (T) direita;
    }

    public <T extends No> void setEsquerda(T no) {
        esquerda = no;
        if (no != null){
            no.pai = this;
        }
    }

    public <T extends No> void setDireita(T no) {
        direita = no;
        if (no !=  null){
            no.pai = this;
        }
    }

    public <T extends No> void setPai(T novoPai) {
        pai = novoPai;
        if (pai !=  null){
            if (this.getChave() > pai.getChave() ){
                pai.setDireita(this);
            } else {
                pai.setEsquerda(this);
            }
        }
    }

    public void setChave(int chave) {
        this.chave = chave;
    }
}