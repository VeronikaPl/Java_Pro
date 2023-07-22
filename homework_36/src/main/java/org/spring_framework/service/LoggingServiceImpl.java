package org.spring_framework.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LoggingServiceImpl implements LoggingService {
    private static final Logger LOGGER = Logger.getLogger(LoggingServiceImpl.class.getName());

    @Override
    public void log(String message) {
        LOGGER.info(message);
    }
}
