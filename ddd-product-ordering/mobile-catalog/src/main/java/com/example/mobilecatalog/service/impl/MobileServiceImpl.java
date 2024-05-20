package com.example.mobilecatalog.service.impl;

import com.example.mobilecatalog.domain.models.MobilePhone;
import com.example.mobilecatalog.domain.models.MobilePhoneID;
import com.example.mobilecatalog.domain.repository.MobileRepository;
import com.example.mobilecatalog.service.MobileService;
import com.example.mobilecatalog.service.form.MobilePhoneForm;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MobileServiceImpl implements MobileService {

    private final MobileRepository mobileRepository;



    @Override
    public MobilePhone findById(MobilePhoneID id) {
        return mobileRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public MobilePhone createProduct(MobilePhoneForm form) {
        MobilePhone m = MobilePhone.build(form.getMobileName(),form.getQuantity(),form.getPrice(),form.getModel(),form.getBrand());
        mobileRepository.save(m);
        return m;

    }

    @Override
    public MobilePhone orderItemCreated(MobilePhoneID mobilePhoneID, int quantity) {
        MobilePhone m = mobileRepository.findById(mobilePhoneID).orElseThrow(RuntimeException::new);
        mobileRepository.saveAndFlush(m);
        return m;

    }

    @Override
    public MobilePhone orderItemRemoved(MobilePhoneID mobilePhoneID, int quantity) {
        MobilePhone m = mobileRepository.findById(mobilePhoneID).orElseThrow(RuntimeException::new);
        mobileRepository.saveAndFlush(m);
        return m;
    }

    @Override
    public List<MobilePhone> findAll() {
        return mobileRepository.findAll();
    }
}
