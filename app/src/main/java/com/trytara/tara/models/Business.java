package com.trytara.tara.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Business")
public class Business extends ParseObject {

    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String ADDRESS = "address";

    public Business() {
    }

    public String getName() {
        return getString(NAME);
    }

    public void setName(String name) {
        put(NAME, name);
    }

    public String getDescription() {
        return getString(DESCRIPTION);
    }

    public void setDescription(String description) {
        put(DESCRIPTION, description);
    }

    public String getAddress() {
        return getString(ADDRESS);
    }

    public void setAddress(String address) {
        put(ADDRESS , address);
    }

    @Override
    public String toString() {
        return "Business{" + getName()  + "}";
    }
}
