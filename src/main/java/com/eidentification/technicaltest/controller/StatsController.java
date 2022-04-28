package com.eidentification.technicaltest.controller;

import com.eidentification.technicaltest.dto.StatDTO;
import com.eidentification.technicaltest.dto.StatRequestDTO;
import com.eidentification.technicaltest.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StatsController {

    @Autowired
    private StatService statService;

    @PostMapping(value = "/api/v2/stats/compute", produces = { "application/json" }, consumes = { "application/json" })
    public ResponseEntity<StatDTO> compute(@Valid @RequestBody StatRequestDTO statRequestDTO) {
        if(statRequestDTO == null || statRequestDTO.getReadings() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        final Integer maximumIncrement = this.statService.compute(statRequestDTO.getReadings());
        final StatDTO statDTO = StatDTO.builder().maximumIncrement(maximumIncrement).build();
        return ResponseEntity.ok(statDTO);
    }
}
