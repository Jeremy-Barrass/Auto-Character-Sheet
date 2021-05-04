package interfaces;

public interface iModel<T> {
    void setData(String label, T data);
    T getData(String label);
}
