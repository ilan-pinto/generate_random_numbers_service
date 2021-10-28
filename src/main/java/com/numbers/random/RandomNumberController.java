package com.numbers.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RandomNumberController {
    @Autowired
    private RandomNumberRepository RandomNumberRepository;
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/random")
    public RandomNumber generateRandomNum() {

        Random rand = new Random();
        int randNum = rand.nextInt(1000);

        RandomNumber rn = new RandomNumber();
        rn.setId(counter.incrementAndGet());
        rn.setNum(randNum);
        RandomNumberRepository.save(rn);

        return rn;
    }
}
