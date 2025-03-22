package prapp;

import java.io.*;

public class FileDao<T> implements Dao<T> {
    private final String type;

    public FileDao(Class<T> c) {
        this.type = "." + c.getSimpleName();
    }

    @Override
    public void write(String name, T o) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name + type))) {
            oos.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T read(String name) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name + type))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void close() {

    }

}
