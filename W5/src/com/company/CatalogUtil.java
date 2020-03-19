package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) {

        Catalog cat = new Catalog(null, null); //pus aici ca nu il vede la return daca nu

        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            cat = (Catalog) ois.readObject();
        }
        catch (FileNotFoundException e) {
            System.out.println("exception");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("exception");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("exception");
            e.printStackTrace();
        }
        finally {
            return cat;
        }
    }

    public static Desktop view(String path) {
        Desktop desktop = Desktop.getDesktop();

        try {
            if (path.contains("http")) {
                URI uri = new URI(path);
                desktop.browse(uri);
            }
            else {
                File file = new File(path);
                desktop.open(file);
            }
        }

        catch(URISyntaxException e) {
            System.out.println("invalid link");
            e.printStackTrace();
        }
        catch(IOException e) {
            System.out.println("invalid path");
            e.printStackTrace();
        }
        finally {
            return desktop;
        }
    }
}
