package com.numbers.random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RandomNumberController {

    private RandomNumberRepository randomNumberRepository;
    private Random random;
    private final AtomicLong counter = new AtomicLong();

    public RandomNumberController(final RandomNumberRepository setRepository) {
        randomNumberRepository = setRepository;
        random = new Random();
    }

    @GetMapping("/random")
    public RandomNumber generateRandomNum() {

        var rn = new RandomNumber();
        rn.setNum(random.nextInt(1000));

        return randomNumberRepository.save(rn);
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<RandomNumber> getAllNumbers() {
        return randomNumberRepository.findAll();
    }

}
