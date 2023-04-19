package collection.mission;

public interface SimpleList<T> {

    static <T> SimpleList<T> fromArrayToList(T[] values) {
        SimpleArrayList<T> simpleArrayList = new SimpleArrayList<>();
        for (T value : values) {
            simpleArrayList.add(value);
        }
        return simpleArrayList;
    };

    static <T extends Number> double sum(SimpleList<T> intValues) {
        double sum = 0;
        for (int i = 0; i < intValues.size(); i++) {
            sum += intValues.get(i).doubleValue();
        }
        return sum;
    }

    static <T extends Number> SimpleList<T> filterNegative(SimpleList<T> values) {
        SimpleList<T> simpleList = new SimpleArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).doubleValue() >= 0) {
                simpleList.add(values.get(i));
            }
        }
        return simpleList;
    }

    static <T> void copy(SimpleList<? extends T> listToBeCopied, SimpleList<T> listToCopy) {
        for (int i = 0; i < listToBeCopied.size(); i++) {
            listToCopy.add(listToBeCopied.get(i));
        }
    }

    boolean add(T value);

    void add(int index, T value);

    T set(int index, T value);

    T get(int index);

    boolean contains(T value);

    int indexOf(T value);

    int size();

    boolean isEmpty();

    boolean remove(T value);

    T remove(int index);

    void clear();
}
