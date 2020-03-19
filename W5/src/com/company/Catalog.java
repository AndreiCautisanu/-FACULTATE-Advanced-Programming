package com.company;

import java.io.Serializable;
import java.util.*;

public class Catalog implements Serializable {
    private String id;
    private String path;

    private List<Document> documents = new ArrayList<>();

    public Catalog(String id, String path) {
        this.id = id;
        this.path = path;
    }

    public void add (Document doc) {
        documents.add(doc);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Document findByID(String id) {
        return documents.stream().filter(d -> d.getId().equals(id)).findAny().orElse(null);
    }



    @Override
    public String toString() {
        return "Catalog{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", documents=" + documents +
                '}';
    }
}
