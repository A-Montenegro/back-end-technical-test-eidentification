package com.eidentification.technicaltest.controller;

import com.eidentification.technicaltest.dto.StatRequestDTO;
import com.eidentification.technicaltest.service.StatService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StatsControllerTest {

    @Mock
    private StatService statService;

    @InjectMocks
    private StatsController statsController;

    @Nested
    class Compute {

        private final List<Integer> READINGS = new ArrayList<>(Arrays.asList(7, 17, 27));

        @Test
        void expect_callComputeWithGivenReadings() {
            StatsControllerTest.this.statsController.compute(this.getDefaultStatRequestDTO());

            Mockito.verify(statService).compute(READINGS);
        }

        private StatRequestDTO getDefaultStatRequestDTO() {
            final StatRequestDTO statRequestDTO = new StatRequestDTO();
            statRequestDTO.setReadings(READINGS);

            return statRequestDTO;
        }
    }

}
