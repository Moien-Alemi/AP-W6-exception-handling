package library;

import exceptions.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) throws InvalidBookException {
        if(book == null){
            throw new InvalidBookException("Book should not be null.");
        }
        else {
            books.add(book);
        }
    }

    private Book findBook(String title){
        for(Book book : books){
            if(title.equals(book.getTitle())){
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title) throws BookNotFoundException, EmptyLibraryException {
        if(books.size() == 0){
            throw new EmptyLibraryException("Library is empty, no books to borrow.");
        }
        else {
            Book requestedBook = findBook(title);
            if(requestedBook == null){
                throw new BookNotFoundException("Book with title \"" + title + "\" was not found.");
            }
            else {
                System.out.println(requestedBook.toString() + " is available.");
                System.out.println("You successfully borrowed \"" + requestedBook.toString() + "\"");
            }
        }
    }

    public void returnBook(String title) throws BookNotFoundException {
        Book requestedBook = findBook(title);
        if(requestedBook == null){
            throw new BookNotFoundException("Cannot return. Book with title \"" + title + "\" was not found.");
        }
        else {
            System.out.println("You successfully returned \"" + requestedBook.toString() + "\"");
        }
    }

    public void listBooks() throws EmptyLibraryException {
        if(books.size() == 0){
            throw new EmptyLibraryException("Library is empty.");
        }
        else {
            System.out.println("Books in the library:");
            int counter = 1;
            for(Book book : books){
                System.out.println("Book " + counter + ":   \"" + book.toString() + "\"");
                counter++;
            }
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
