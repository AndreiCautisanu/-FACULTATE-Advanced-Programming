package com.company;

import java.awt.*;
import java.io.*;

public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws IOException, ClassNotFoundException {
        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            Catalog cat = (Catalog) ois.readObject();
            return cat;
        }
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
    }


}
