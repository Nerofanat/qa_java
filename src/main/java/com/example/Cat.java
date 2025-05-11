package com.example;

import java.util.List;

//Класс кошка
public class Cat {

    //Хищник ?
    Predator predator;

    // конструктор класса Кошка с передачей объекта класса кошачий
    public Cat(Feline feline) {
        this.predator = feline;
    }

    // Кошка говорит мяу (просто проверить что результат вызова == мяу)
    public String getSound() {
        return "Мяу";
    }

    // Вызов этого метода должен вызвать метод .eatMeat() класса Filine (Это надо проерить моковым объектом filine)
    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

}
