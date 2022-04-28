package com.eidentification.technicaltest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StartServiceImplTest {

    private final StatService statService = new StatServiceImpl();

    @Nested
    class Compute {

        private final List<Integer> EMPTY_READINGS = Collections.emptyList();

        private final List<Integer> SAME_VALUE_READINGS = new ArrayList<>(Arrays.asList(7, 7, 7, 7));

        private final List<Integer> NOT_INCREMENT_READINGS = new ArrayList<>(Arrays.asList(7, 6, 5, 4));

        private final List<Integer> ORDINARY_READINGS_1 = new ArrayList<>(Arrays.asList(78, 6, 15, 38, 24));

        private final List<Integer> ORDINARY_READINGS_2 = new ArrayList<>(Arrays.asList(47, 54, 58, 4));

        private final List<Integer> ORDINARY_READINGS_3 = new ArrayList<>(Arrays.asList(48, 6, 5, 4, 5));

        private final List<Integer> ORDINARY_READINGS_4 = new ArrayList<>(Arrays.asList(7, 21, 5, 4, 2, 7, 1, 18));

        private final List<Integer> ORDINARY_READINGS_5 = new ArrayList<>(Arrays.asList(7, 21, 5, 24, 22, 7, 18, 1));

        @Test
        void when_readingsHasOrdinaryValues_expect_correctIncrement() {
            final Integer maximumIncrement1 = StartServiceImplTest.this.statService.compute(ORDINARY_READINGS_1);
            final Integer maximumIncrement2 = StartServiceImplTest.this.statService.compute(ORDINARY_READINGS_2);
            final Integer maximumIncrement3 = StartServiceImplTest.this.statService.compute(ORDINARY_READINGS_3);
            final Integer maximumIncrement4 = StartServiceImplTest.this.statService.compute(ORDINARY_READINGS_4);
            final Integer maximumIncrement5 = StartServiceImplTest.this.statService.compute(ORDINARY_READINGS_5);

            Assertions.assertEquals(32, maximumIncrement1);
            Assertions.assertEquals(11, maximumIncrement2);
            Assertions.assertEquals(1, maximumIncrement3);
            Assertions.assertEquals(17, maximumIncrement4);
            Assertions.assertEquals(19, maximumIncrement5);
        }

        @Test
        void when_readingsIsEmpty_expect_zero() {
            final Integer maximumIncrement = StartServiceImplTest.this.statService.compute(EMPTY_READINGS);

            Assertions.assertEquals(0, maximumIncrement);
        }

        @Test
        void when_readingsHasSameValue_expect_zero() {
            final Integer maximumIncrement = StartServiceImplTest.this.statService.compute(SAME_VALUE_READINGS);

            Assertions.assertEquals(0, maximumIncrement);
        }

        @Test
        void when_readingsHasNotIncrement_expect_zero() {
            final Integer maximumIncrement = StartServiceImplTest.this.statService.compute(NOT_INCREMENT_READINGS);

            Assertions.assertEquals(0, maximumIncrement);
        }
    }
}
