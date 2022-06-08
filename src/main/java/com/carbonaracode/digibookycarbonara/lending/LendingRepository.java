package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.books.LentBook;
import com.carbonaracode.digibookycarbonara.members.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LendingRepository {
    private Map<Member, List<LentBook>> lendingMap;

    public LendingRepository() {
        this.lendingMap = new HashMap<>();
    }


    public Map<Member, List<LentBook>> getLendingMap() {
        return lendingMap;
    }
}
