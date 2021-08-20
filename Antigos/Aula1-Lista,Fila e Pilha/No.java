public class No <T> {
    public No(T info) {
        this.info = info;
	}
	T info;
    No<T> proximo;
}
