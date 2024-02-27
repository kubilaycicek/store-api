package com.kubilaycicek.store.service.phone;

import com.kubilaycicek.store.api.dto.PhoneDTO;
import com.kubilaycicek.store.data.model.Phone;

import java.util.List;

public interface PhoneService {

    List<PhoneDTO> findAllPhoneList();

    List<PhoneDTO> findAllPhoneByBrand(String brand);

    List<PhoneDTO> searchPhoneList(String value);

    PhoneDTO createPhone(PhoneDTO phoneDTO);

    void removeById(int id);

    PhoneDTO updatePhone(PhoneDTO phoneDTO);
}
