package week7.labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

enum Status{
    AVAILABLE, CHECKED_OUT, RESERVED
}
class Library {
    private List<Book> books;

    public Library(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public Optional<Book> findBookByISBN(String ISBN) {
        for(Book book : books) {
            if(book.getISBN().equals(ISBN)){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }
}

class Book{
    private String title;
    private String author;
    private String ISBN;
    private Status status;

    public Book(String title, String author, String ISBN, Status status){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.status = status;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }

    public Status getStatus(){
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Status: " + status;
    }
}

class CustomException extends RuntimeException{
    public CustomException(String message, String ISBN){
        super(message + " ISBN: " + ISBN);
    }
}

class LibraryLocator {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Book 1", "Author 1", "ISBN1", Status.AVAILABLE));
        library.addBook(new Book("Book 2", "Author 2", "ISBN2", Status.CHECKED_OUT));
        library.addBook(new Book("Book 3", "Author 3", "ISBN3", Status.RESERVED));

        //orElse
        Optional<Book> book1 = library.findBookByISBN("ISBN1");
        Optional<Book> book2 = library.findBookByISBN("ISBN4");
        Book defaultBook = new Book("Default Book", "Default Author", "ISBN0", Status.AVAILABLE);
        System.out.println(book1.orElse(defaultBook));
        System.out.println(book2.orElse(defaultBook));

        //orElseGet
        Optional<Book> book3 = library.findBookByISBN("ISBN2");
        Optional<Book> book4 = library.findBookByISBN("ISBN4");
        Book defaultBook2 = new Book("Default Book", "Default Author", "ISBN0", Status.AVAILABLE);
        System.out.println(book3.orElseGet(() -> defaultBook2));
        System.out.println(book4.orElseGet(() -> defaultBook2));

        //orElseThrow
        try {
            String isbnToFind = "ISBN3";
            Optional<Book> book5 = library.findBookByISBN(isbnToFind);
            Optional<Book> book6 = library.findBookByISBN("ISBN4");
            System.out.println(book5.orElseThrow(() -> new CustomException("Book not found!", isbnToFind)));
            System.out.println(book6.orElseThrow(() -> new CustomException("Book not found!", "ISBN4")));

        } catch (CustomException e) {
            System.err.println(e.getMessage());
        }

    }
}
