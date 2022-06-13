package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.books.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LendingRepository {
    private Map<String, LentBook> lendingMap;

    public LendingRepository() {
        this.lendingMap = new HashMap<>();
    }

    public Map<String, LentBook> getLendingMap() {
        return lendingMap;
    }

    public LentBook addLentBook(String lendingId, LentBook lentBook){
        this.lendingMap.put(lendingId, lentBook);
        return lentBook;
    }

    public List<LentBook> getAllLentBooks() {
        return lendingMap.values().stream().toList();
    }

    public boolean isLent(Book book) {
        return this.getAllLentBooks().stream().map(Book::getIsbn).anyMatch(lentBookIsbn -> lentBookIsbn.equals(book.getIsbn()));
    }

    public void returnBook(String lendingId) {

        lendingMap.remove(lendingId);
    }
}
