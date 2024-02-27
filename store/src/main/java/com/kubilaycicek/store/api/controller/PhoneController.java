package com.kubilaycicek.store.api.controller;

import com.kubilaycicek.store.api.dto.PhoneDTO;
import com.kubilaycicek.store.api.request.AddPhoneRequest;
import com.kubilaycicek.store.api.request.GetPhoneListByBrandRequest;
import com.kubilaycicek.store.api.request.SearchPhoneListRequest;
import com.kubilaycicek.store.service.phone.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/phone/")
@RestController
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping("list")
    public ResponseEntity<List<PhoneDTO>> getPhoneList() {
        return ResponseEntity.ok(phoneService.findAllPhoneList());
    }

    @GetMapping("filterWithParams")
    public ResponseEntity<List<PhoneDTO>> getPhoneListFilterWithParams(@RequestBody GetPhoneListByBrandRequest request) {
        return ResponseEntity.ok(phoneService.findAllPhoneByBrand(request.getBrand()));
    }

    @GetMapping("search")
    public ResponseEntity<List<PhoneDTO>> searchPhoneList(@RequestBody SearchPhoneListRequest request) {
        return ResponseEntity.ok(phoneService.searchPhoneList(request.getSearch()));
    }

    @PostMapping("")
    public ResponseEntity<PhoneDTO> createPhone(@RequestBody AddPhoneRequest request) {
        return ResponseEntity.ok(phoneService.createPhone(request.getPhoneDTO()));
    }

    @DeleteMapping("delete/{phoneId}")
    public ResponseEntity<?> deletePhone(@PathVariable int phoneId) {
        phoneService.removeById(phoneId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}