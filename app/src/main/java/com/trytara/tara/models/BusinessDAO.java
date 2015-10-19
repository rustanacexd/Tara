package com.trytara.tara.models;

import java.util.List;
import java.util.UUID;

public interface BusinessDAO {
    public List<Business> getAllBusinesses();
    public Business getBusiness(int position);
    public void updateBusiness(Business business);
    public void deleteBusiness(Business business);

}
