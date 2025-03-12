package prApp;

import java.io.*;

public class FileDao<T> implements Dao<T> {

    @Override
    public void write(String name, T o) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"))) {
            writer.write(o.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T read(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(name + ".txt"))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            System.out.println("Odczytane dane:\n" + sb);
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void close() {

    }

}
