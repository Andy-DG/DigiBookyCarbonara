package com.carbonaracode.digibookycarbonara.security;

import com.google.common.collect.Lists;

import java.util.List;

import static com.carbonaracode.digibookycarbonara.security.Feature.*;


public enum Role {
    ADMIN("admin", ADD_BOOKS, LEND_BOOK, REGISTER_NEW_LIBRARIAN, RETURN_BOOK, VIEW_ALL_BOOKS),
    MEMBER("member", LEND_BOOK, RETURN_BOOK, VIEW_ALL_BOOKS),
    LIBRARIAN("librarian", ADD_BOOKS, VIEW_ALL_BOOKS);

    private final String label;
    private final List<Feature> featureList;

    Role(String label, Feature... featureList) {
        this.label = label;
        this.featureList = Lists.newArrayList(featureList);
    }

    public String getLabel() {
        return label;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }
}
