package de.jug_gr.modelviewstar.mvc;

import de.jug_gr.modelviewstar.business.*;
import de.jug_gr.modelviewstar.business.Error;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Singleton
public class Model {

    private List<Book> books = new ArrayList<>();

    private List<Runnable> booksObservers = new ArrayList<>();

    private List<Consumer<Error>> errorObservers = new ArrayList<>();

    private List<Consumer<Book>> selectedBookObservers = new ArrayList<>();

    public List<Book> getBooks(){
        return books;
    }

    public void selectBook(Book book){
        selectedBookObservers.forEach(observer -> observer.accept(book));
    }

    public void setBooks(List<Book> books){
        this.books = books;
        booksObservers.forEach(Runnable::run);
    }

    public void error(Error error){
        errorObservers.forEach(observer -> observer.accept(error));
    }

    public void addBooksChangeObserver(Runnable observer){
        booksObservers.add(observer);
    }

    public void removeBooksChangeObserver(Runnable observer){
        booksObservers.remove(observer);
    }

    public void addErrorObserver(Consumer<Error> observer){
        errorObservers.add(observer);
    }

    public void removeErrorObserver(Consumer<Error> observer){
        errorObservers.remove(observer);
    }


    public void addSelectedBookObserver(Consumer<Book> observer){
        selectedBookObservers.add(observer);
    }

    public void removeSelectedBookObserver(Consumer<Book> observer){
        selectedBookObservers.remove(observer);
    }

}