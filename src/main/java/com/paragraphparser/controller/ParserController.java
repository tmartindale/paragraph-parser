package com.paragraphparser.controller;

import com.paragraphparser.service.ParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ParserController {

    private final Logger LOG = LoggerFactory.getLogger(ParserController.class);

    @Autowired
    ParserService parserService;

    @RequestMapping(path = "/parse", method = RequestMethod.POST,
            consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public ResponseEntity<String> parse(@RequestBody String input) {
        String result = parserService.parse(input);
        LOG.info("Result: {}", result);
        return ResponseEntity.ok(result);
    }
}
