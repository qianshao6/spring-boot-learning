package top.jiejie.boot.config;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class PersonTest {
    @Resource
    private Dog dog;

    @Resource
    private Person person;

    @Test
    void name() {
        System.out.println(dog);
        System.out.println(person);
    }

}