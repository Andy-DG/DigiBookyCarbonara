package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.books.Book;
import com.carbonaracode.digibookycarbonara.members.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LendingRepository {
    private Map<Member, List<LentBook>> lendingMap;

    public LendingRepository() {
        this.lendingMap = new HashMap<>();
    }

    public Map<Member, List<LentBook>> getLendingMap() {
        return lendingMap;
    }

    public LentBook addLentBook(Member member, LentBook lentBook){
        if(this.lendingMap.containsKey(member)){
            this.lendingMap.get(member).add(lentBook);
        } else {
            this.lendingMap.put(member, new ArrayList<>());
            this.lendingMap.get(member).add(lentBook);
        }
        return lentBook;
    }

    public List<LentBook> getAllLentBooks() {
        return lendingMap.values().stream().flatMap(Collection::stream).toList();
    }

    public boolean isLent(Book book) {
        return this.getAllLentBooks().stream().map(Book::getIsbn).anyMatch(lentBookIsbn -> lentBookIsbn.equals(book.getIsbn()));
    }

    public List<LentBook> getLentBookList(Member member) {
        if (lendingMap.get(member) == null) return new ArrayList<>();
        return lendingMap.get(member);
    }
}
