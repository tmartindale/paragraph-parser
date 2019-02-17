package com.paragraphparser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ParserServiceImpl implements ParserService {

    private static Logger LOG = LoggerFactory.getLogger(ParserServiceImpl.class);

    @Override
    public String parse(String line) {
        LOG.info("parsing: {}", line);

        return null;
    }
}
