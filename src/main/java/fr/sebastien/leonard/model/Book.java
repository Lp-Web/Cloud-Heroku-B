package fr.sebastien.leonard.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {

    private Long id;
    private Long numberOfBook;
    private String author;
    private String title;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getNumberOfBook() { return numberOfBook; }
    public void setNumberOfBook(Long numberOfBook) { this.numberOfBook = numberOfBook; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

}
