package com.example.mobilecatalog.service;

import com.example.mobilecatalog.domain.models.MobilePhone;
import com.example.mobilecatalog.domain.models.MobilePhoneID;
import com.example.mobilecatalog.service.form.MobilePhoneForm;

import java.util.List;

public interface MobileService {


    MobilePhone findById(MobilePhoneID id);
    MobilePhone createProduct(MobilePhoneForm form);
    MobilePhone orderItemCreated(MobilePhoneID mobilePhoneID, int quantity);
    MobilePhone orderItemRemoved(MobilePhoneID mobilePhoneID, int quantity);
    List<MobilePhone> findAll();


}
