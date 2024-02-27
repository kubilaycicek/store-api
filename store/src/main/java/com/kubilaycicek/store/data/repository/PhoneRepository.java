package com.kubilaycicek.store.data.repository;

import com.kubilaycicek.store.data.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer>, JpaSpecificationExecutor<Phone> {
    Phone findById(int id);
}
