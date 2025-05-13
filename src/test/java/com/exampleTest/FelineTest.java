package com.exampleTest;

import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
public class FelineTest{

    private Feline feline;
    private Animal animal;


    @Before
    public void creatingAnObject (){
        feline = new Feline();
    }

    //ПРоверяем что метод feline.eatMeat() вернет нам корректный рацион хищника
    @Test
    public void eatMeatTest() throws Exception {
        animal = Mockito.mock(Animal.class);
        when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = feline.eatMeat();
        assertEquals("Некорректный список потребляемой еды", List.of("Животные", "Птицы", "Рыба"), actual);

    }

    //ПРоверили что метод feline.getFamily() вернет нам "Кошачьи"
    @Test
    public void getFamilyTest() {
        String actual = feline.getFamily();
        assertEquals("Ожидаемое семейство не соответствует фактическому","Кошачьи", actual);
    }

    @Test
    public void testGetKittens() {
        feline = Mockito.spy(feline);
        int actual = feline.getKittens();
        Mockito.verify(feline).getKittens(1);
        assertEquals("Некорректное количество котят",1, actual);
    }

    @Test
    public void testGetKittens1 (){
        feline = Mockito.spy(feline);
        int actual = feline.getKittens(5);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        assertEquals("Некорректное количество котят",5, actual);
    }



}
