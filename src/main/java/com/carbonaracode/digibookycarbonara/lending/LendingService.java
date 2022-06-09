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

    public LentBookDTO lendBook(String inss, String isbn) {
        LentBook lentBook = lendingSystem.lend(inss, isbn);
        return lentBookMapper.toDTO(lentBook);
    }


}
