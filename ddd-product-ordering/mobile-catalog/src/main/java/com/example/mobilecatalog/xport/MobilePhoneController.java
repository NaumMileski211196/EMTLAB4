package com.example.mobilecatalog.xport;

import com.example.mobilecatalog.domain.models.MobilePhone;
import com.example.mobilecatalog.service.MobileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mobile")
public class MobilePhoneController  {
    private final MobileService mobileService;

    public MobilePhoneController(MobileService mobileService) {
        this.mobileService = mobileService;
    }


    @GetMapping
    public List<MobilePhone> getAllPhones() {
        return mobileService.findAll();
    }
}
