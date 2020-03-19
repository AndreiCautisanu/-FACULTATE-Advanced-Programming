package com.company;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        app.cr
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("Java Resources", "d:/java/catalog.ser");
        Document doc = new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        CatalogUtil.save(catalog);
    }
}
