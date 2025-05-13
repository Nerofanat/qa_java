package com.exampleTest;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParametrized {
    private Lion lion;
    private String sex;
    private Feline feline;
    private final Boolean hasMane;
    private final Boolean expectException; //Ожидаем ли мы исключение в тесте

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true, false},
                {"Самка", false, false},
                {"Сумка", false, true},
        });

    }

    public LionTestParametrized(String sex, Boolean hasMane, Boolean expectException) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.expectException = expectException;
    }

    //Проверили например, что если  Lion sex = "Man" то Lion.hasMane = true + проверили появление исключения в случае чего
    @Test
    public void doesHaveManeTest() throws Exception {
        try {
            lion = new Lion(sex, feline);
            if (!expectException) {
                boolean actual = lion.doesHaveMane();
                assertEquals(hasMane, actual);
            }else {
                Assert.fail("Исключение не возникло, хотя ожидалось.");

            }
        }catch (Exception e) {
            if (!expectException){
                Assert.fail("Исключение возникло, хотя не ожидалось.");
            }
        }
    }
}
