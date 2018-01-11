package bookStore.cart.domain;

import bookStore.book.domain.Book;

public class Cartltem {
    private Book book;
    private int count;

    public Cartltem(Book book, int count) {
        this.book = book;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Cartltem{" +
                "book=" + book +
                ", amount=" + count +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Cartltem() {

    }
}
