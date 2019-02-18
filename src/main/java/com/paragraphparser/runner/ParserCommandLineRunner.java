package com.paragraphparser.runner;

import com.paragraphparser.service.ParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class ParserCommandLineRunner implements CommandLineRunner {

    private final Logger LOG = LoggerFactory.getLogger(ParserCommandLineRunner.class);

    @Autowired
    private ParserService parserService;

    @Override
    public void run(String... args) {
        if (args != null && args.length > 0) {
            String resourcePath = args[0];

            try {
                FileInputStream inputStream = new FileInputStream(resourcePath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String input = reader.lines().collect(Collectors.joining("\n"));

                String result = parserService.parse(input);
                LOG.info("Result: {}", result);
            } catch (FileNotFoundException e) {
                LOG.error("File {} not found.", resourcePath);
            }
        }
    }

}