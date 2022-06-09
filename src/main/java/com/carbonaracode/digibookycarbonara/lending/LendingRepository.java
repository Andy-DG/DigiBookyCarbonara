package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.members.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public LentBook addLentBook(Member member, LentBook lentBook){
        if(this.lendingMap.containsKey(member)){
            this.lendingMap.get(member).add(lentBook);
        } else {
            this.lendingMap.put(member, new ArrayList<>());
            this.lendingMap.get(member).add(lentBook);
        }
        return lentBook;
    }
}
