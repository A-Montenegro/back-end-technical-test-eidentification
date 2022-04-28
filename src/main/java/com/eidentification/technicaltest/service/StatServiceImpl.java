package com.eidentification.technicaltest.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StatServiceImpl implements StatService {

    @Override
    public Integer compute(final List<Integer> readings) {
        int maximumIncrement = 0;
        int minimumValue = readings.isEmpty() ? 0 : readings.remove(0);

        for (Integer reading : readings) {
            if (reading < minimumValue) {
                minimumValue = reading;
            } else {
                final int increment = reading - minimumValue;
                if (increment > maximumIncrement) {
                    maximumIncrement = increment;
                }
            }
        }

        return maximumIncrement;
    }
}
