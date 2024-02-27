package com.kubilaycicek.store.api.request;

import com.kubilaycicek.store.api.dto.PhoneDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPhoneRequest {
    private PhoneDTO phoneDTO;
}
