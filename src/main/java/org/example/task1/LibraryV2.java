package org.example.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryV2 {

    public static void main(String[] args) {

        Book book1 = new Book("Война и мир","Лев Толстой", 1869);
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание","Фёдор Достоевский", 1866));
        books.add(new Book("Улисс","Джеймс Джойс", 1922));
        books.add(book1);
        books.add(new Book("Идиот","Фёдор Достоевский", 1869));

        // Поиск книг написанных определенным автором
        /*List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if ("Лев Толстой".equals(book.getAuthor())) {
                authorBooks.add(book);
            }
        }*/
        List<Book> authorBooks = books.stream()
                        .filter(book -> "Лев Толстой".equals(book.getAuthor())).toList();
        System.out.println("Лев Толстой: " + authorBooks);

        Book book2 = authorBooks.get(0);
        System.out.println(book1.equals(book2));

        // Поиск книг изданных после 1866 года
        /*List<Book> booksAfterYear= new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > 1866) {
                booksAfterYear.add(book);
            }
        }*/
        List<Book> booksAfterYear = books.stream()
                        .filter(book -> book.getYear() > 1866).toList();
        System.out.println("Книги после 1866 года: " + booksAfterYear);

        // Поиск уникальных названий книг
        /*List<String> uniqueTitles= new ArrayList<>();
        for (Book book : books) {
            if (!uniqueTitles.contains(book.getTitle())) {
                uniqueTitles.add(book.getTitle());
            }
        }*/
        List<String> uniqueTitles = books.stream()
                        .map(Book::getTitle).distinct().toList();

        System.out.println("Уникальные названия книг: " + uniqueTitles);
    }
}
