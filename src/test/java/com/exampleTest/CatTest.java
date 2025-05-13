package com.exampleTest;

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void creatingAnObject (){
        cat = new Cat(feline);
    }

    //Проверили что метод getSound объекста класса Cat вернет строку "Мяу"
    @Test
    public void getSoundTest (){
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    //Проверяем что если был вызван  cat.getFood() то вызвалися также feline.eatMeat()
    @Test
    public void getFoodTest () throws Exception {
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }

}
