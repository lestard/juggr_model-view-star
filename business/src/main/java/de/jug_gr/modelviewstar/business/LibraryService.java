package de.jug_gr.modelviewstar.business;

import java.util.List;
import java.util.function.Consumer;

public interface LibraryService {
    List<Book> search(String query, Consumer<Error> errorCallback);

    Book showDetails(Book book, Consumer<Error> errorCallback);
}
