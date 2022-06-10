package com.carbonaracode.digibookycarbonara.lending;

import org.springframework.stereotype.Service;

@Service
public class LendingService {
    private final LendingRepository lendingRepository;
    private final LendingSystem lendingSystem;
    private final LentBookMapper lentBookMapper;

    public LendingService(LendingRepository lendingRepository, LentBookMapper lentBookMapper, LendingSystem lendingSystem) {
        this.lendingRepository = lendingRepository;
        this.lentBookMapper = lentBookMapper;
        this.lendingSystem = lendingSystem;
    }

    public LentBookDTO lendBook(String isbn, String inss) {
        LentBook lentBook = lendingSystem.lend(isbn, inss);
        return lentBookMapper.toDTO(lentBook);
    }

    public void returnBook(String isbn) {
        String lendingId = getLendingIdByIsbn(isbn);
        lendingSystem.returnBook(lendingId);
    }

    public String getLendingIdByIsbn(String lentBookIsbn){
        return lendingRepository.getLendingMap().values().stream()
                .filter(lentBook -> lentBook.getIsbn().equals(lentBookIsbn)).findFirst().get().getLendingID();
    }



}
