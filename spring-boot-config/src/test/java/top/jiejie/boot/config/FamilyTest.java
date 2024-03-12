package top.jiejie.boot.config;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class FamilyTest {
    @Resource
    private Family family;

    @Test
    public void testFamily(){
        System.out.println(family);
    }



}