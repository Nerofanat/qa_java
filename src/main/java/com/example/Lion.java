package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    //Словно бы надо вот его мокировать (или мок или стаб, подумаем)
    private Feline feline;


    public Lion (String sex, Feline feline) throws Exception {
        this.feline = feline;
        //Наверное вот эту развилку надо проерить как раз параметризированным тестом
        //Проверяем параметризацией
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    // Вызов этого метода Lion.getKittens() должен вызвать метод feline.getKittens() (там можно вызвать этот метод с аргументами  так что надо понять или тут это проверить или в классе feline)

    public int getKittens() {
        return feline.getKittens();
    }

    // (Грива?) вызов этого метода возвращает true/ false в зависимости от того какой пол передали в конструктор
    //Пооверяем параметризщацией
    public boolean doesHaveMane() {
        return hasMane;
    }

    //
    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}

