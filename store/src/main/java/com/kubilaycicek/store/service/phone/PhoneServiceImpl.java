package com.kubilaycicek.store.service.phone;

import com.kubilaycicek.store.api.dto.PhoneDTO;
import com.kubilaycicek.store.data.model.Phone;
import com.kubilaycicek.store.data.repository.PhoneRepository;
import com.kubilaycicek.store.data.specification.PhoneSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Override
    public List<PhoneDTO> findAllPhoneList() {
        return convertToPhoneDTOList(phoneRepository.findAll());
    }

    @Override
    public List<PhoneDTO> findAllPhoneByBrand(String brand) {

        final Specification<Phone> specification = PhoneSpecification.hasBrand(brand);
        return convertToPhoneDTOList(phoneRepository.findAll(specification));
    }

    @Override
    public List<PhoneDTO> searchPhoneList(String value) {
        final Specification<Phone> specification = PhoneSpecification.searchPhone(value);
        return convertToPhoneDTOList(phoneRepository.findAll(specification));
    }

    @Override
    public PhoneDTO createPhone(PhoneDTO phoneDTO) {
        Phone phoneDb = phoneRepository.save(converToPhone(phoneDTO));
        return convertToPhoneDTO(phoneDb);
    }

    @Override
    public void removeById(int id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public PhoneDTO updatePhone(PhoneDTO phoneDTO) {
        Optional<Phone> phoneDb = phoneRepository.findById(phoneDTO.getId());
        if (phoneDb.isPresent()) {
            Phone updatePhone = phoneDb.get();
            updatePhone.setPhoneName(phoneDTO.getPhoneName());
            updatePhone.setPhoneBrand(phoneDTO.getPhoneBrand());
            return convertToPhoneDTO(phoneRepository.save(updatePhone));
        }
        return null;
    }

    public PhoneDTO convertToPhoneDTO(Phone phone) {
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setId(phone.getId());
        phoneDTO.setPhoneBrand(phone.getPhoneBrand());
        phoneDTO.setPhoneName(phone.getPhoneName());
        return phoneDTO;
    }

    public Phone converToPhone(PhoneDTO phoneDTO) {
        Phone phone = new Phone();
        phone.setId(phoneDTO.getId());
        phone.setPhoneName(phoneDTO.getPhoneName());
        phone.setPhoneBrand(phoneDTO.getPhoneBrand());
        return phone;
    }

    public List<PhoneDTO> convertToPhoneDTOList(List<Phone> phoneList) {
        List<PhoneDTO> phoneDTOList = new ArrayList<>();
        phoneList.forEach(item -> phoneDTOList.add(convertToPhoneDTO(item)));
        return phoneDTOList;
    }

}