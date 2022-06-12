package day10;

public class Tool<E>{
    private E e;

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}

interface GenericsInterface<E>{
    public void show(E e);
}