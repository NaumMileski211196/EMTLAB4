package com.example.mobilecatalog.domain.repository;

import com.example.mobilecatalog.domain.models.MobilePhone;
import com.example.mobilecatalog.domain.models.MobilePhoneID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<MobilePhone, MobilePhoneID> {

}
