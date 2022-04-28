package com.eidentification.technicaltest.service;

import java.util.List;

public interface StatService {

    /**
     *
     * @param readings Temperature readings.
     * @return Maximum increment of temperature.
     */
    Integer compute(final List<Integer> readings);
}
