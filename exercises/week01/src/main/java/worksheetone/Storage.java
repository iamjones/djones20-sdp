package main.java.worksheetone;

public class Storage<T> {

    private T x;

    public void setValue(T value) {
        x = value;
    }

    public T getValue() {
        return x;
    }
}
