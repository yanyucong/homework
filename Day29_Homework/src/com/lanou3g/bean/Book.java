package com.lanou3g.bean;

public class Book {
    private String bookname;
    private String author;
    private double price;

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book() {

    }
}
