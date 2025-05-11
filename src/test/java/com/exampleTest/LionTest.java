package com.exampleTest;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    String MAN = "Самец";
    Lion lion;

    @Mock
    Feline feline;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        lion = new Lion(MAN, feline);
    }

    //Проверяем что при вызове метода  lion.getKittens() вызывается метод feline.getKittens()
    @Test
    public void getKittensTest (){
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    //Проверяем что при вызове метода lion.getFood() вызывается метод feline.getFood() с аргументом строкой
    @Test
    public void getFoodTest () throws Exception {
        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }

}

