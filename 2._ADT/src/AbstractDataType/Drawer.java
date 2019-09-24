package AbstractDataType;

public class Drawer<T> {

    private T type;

    public void setType(T type) {
        this.type = type;
    }

    public T getType(){
        return type;
    }
}
