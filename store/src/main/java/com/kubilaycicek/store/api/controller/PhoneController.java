package com.kubilaycicek.store.api.controller;

import com.kubilaycicek.store.api.dto.PhoneDTO;
import com.kubilaycicek.store.api.request.AddPhoneRequest;
import com.kubilaycicek.store.api.request.GetPhoneListByBrandRequest;
import com.kubilaycicek.store.api.request.SearchPhoneListRequest;
import com.kubilaycicek.store.service.phone.PhoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Phone Rest Controller",description = "Phone API")
@RequiredArgsConstructor
@RequestMapping("/api/v1/phone/")
@RestController
public class PhoneController {

    private final PhoneService phoneService;

    @Operation(summary = "Get All Phone Entities", description = "This operation for fetch all Phone Entities.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("list")
    public ResponseEntity<List<PhoneDTO>> getPhoneList() {
        return ResponseEntity.ok(phoneService.findAllPhoneList());
    }

    @Operation(summary = "Get All Phone Entities", description = "This operation for fetch all Phone Entities by brands")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("filterWithParams")
    public ResponseEntity<List<PhoneDTO>> getPhoneListFilterWithParams(@RequestBody GetPhoneListByBrandRequest request) {
        return ResponseEntity.ok(phoneService.findAllPhoneByBrand(request.getBrand()));
    }

    @Operation(summary = "Get All Phone Entities", description = "This operation for fetch all Phone Entities by name or brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("search")
    public ResponseEntity<List<PhoneDTO>> searchPhoneList(@RequestBody SearchPhoneListRequest request) {
        return ResponseEntity.ok(phoneService.searchPhoneList(request.getSearch()));
    }

    @Operation(summary = "Create a new Phone", description = "This operation for create a new Phone Entity.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping("")
    public ResponseEntity<PhoneDTO> createPhone(@RequestBody AddPhoneRequest request) {
        return ResponseEntity.ok(phoneService.createPhone(request.getPhoneDTO()));
    }

    @Operation(summary = "Delete By Id", description = "This operation for delete Phone Entity.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @DeleteMapping("delete/{phoneId}")
    public ResponseEntity<?> deletePhone(@PathVariable int phoneId) {
        phoneService.removeById(phoneId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}