package com.kubilaycicek.store.api.response;

import com.kubilaycicek.store.api.dto.PhoneDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetPhoneListResponse {
    List<PhoneDTO> phoneDTOList;
}
