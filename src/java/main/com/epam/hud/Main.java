package com.epam.hud;


import com.epam.hud.entity.AnimeToy;
import com.epam.hud.exception.GeneralException;

import com.epam.hud.entity.AnimeShop;
import com.epam.hud.logic.ShopContainer;

/**
 * 1. В текущей программе заменить массивы на ArrayList
 * 2. Создать свой класс исключений, добавить обработку
 * ошибок(с помощью исключений) в методы
 * 4. Создать ветку task, сделать commit и push в эту ветку.
 * Добавить меня в contributors и сделать pull request
 * 3. Продемонтрировать вариант с некоректными наднными для проверки работы исключений
 * (Пример: цена отрицательная - вырбрасываем exception)
 * 5. Добавить структуру пакетов. (java/main/com.....)
 * logic, entity
 * 6. Удалить пакет example
 */

/**
 * 1. Исправить пакеты(первая строчка программы)
 * 2. Разложить по пакетам. logic и entity поменять местами.
 * 3. Создать пакет exception  для класса GeneralException.
 * 4. Проверить что программа работает корректно.
 * 5. Удалить комментарии
 * 6. git add, git commit -'comment', git push, pull request. Добавить меня в колабораторы.
 */

public class Main {
    public static void main(String[] args) {
        //Ниже приведён код, выводящий вначале новый эелемент, а потом сам массив. (Размер массива равен 10. Метод
        //по расширению массива ещё не прописан.)Здесь в массив добавлено 2 элемента.
        System.out.println("Ниже приведён код, выводящий вначале новый эелемент, а потом сам массив. Здесь в массив добавлено 2 элемента.");

        //Здесь создаётся объект магазин и объекты игрушки. Операции над магазином прописаны в классе AnimeShop, потому
        //необходимо создать объект данного класса. В игрушке лишь задаются параметры, а посему для описания параметров хватит объектра
        //класса AnimeToy.
        //Создание объекта игрушки

        AnimeToy animeToy = new AnimeToy();
        animeToy.setToyFandom("Naruto");
        animeToy.setToyName("Uzumaki");
        animeToy.setToyType("Action figure");
        System.out.println(animeToy);
        System.out.println();

        //Создание объекта магазин для использования метода класса AnimeToy.
        AnimeShop animeShop = new AnimeShop();

        //Игрушка записывается в массив, созданный в классе AnimeShop:
        animeShop.addToy(animeToy);
        animeShop.printToyArray();
        System.out.println();
        AnimeToy animeToy1 = new AnimeToy();
        animeToy1.setToyType("Nendoroid");
        animeToy1.setToyName("Name1");
        animeToy1.setToyFandom("One piece");
        animeShop.addToy(animeToy1);
        System.out.println(animeToy1);
        System.out.println();
        animeShop.printToyArray();
        System.out.println();


        //Далее приведён код, создающий и выводящий магазины аниме-игрушек. Здесь задаются лишь
        //названия магазинов и их адреса. Всего взято 2 магазина.
        System.out.println("Далее приведён код, создающий и выводящий магазины аниме-игрушек.");
        //Создание магазина:
        AnimeShop shop0 = new AnimeShop();
        //Задание всех параметров магазина
        shop0.setNumberOfToys(1);
        shop0.setShopAddress("Московская 4");
        shop0.setShopName("Anime");
        shop0.setToyPrice(10);
        shop0.addToy(animeToy);
        shop0.addToy(animeToy);
        shop0.addToy(animeToy);
        shop0.addToy(animeToy);
        shop0.addToy(animeToy1);
        shop0.addToy(animeToy);
        shop0.addToy(animeToy);
        shop0.addToy(animeToy);
        shop0.addToy(animeToy);
        shop0.addToy(animeToy1);
        System.out.println(shop0);
        System.out.println();


        //В классе ShopContainer создан массив магазинов и прописан метод заполнения этого массива.
        //Для того, чтобы использовать метод заполнения массива, необходимо создать элемент класса ShopContainer.
        //Именно это и происходит далее:
        ShopContainer shopShop = new ShopContainer();


        //Далее применён метод, прописанный в классе ShopContainer для заполнения массива магазинов, созданных в
        //том же классе.
        System.out.println("Далее применён метод, прописанный в классе ShopContainer для заполнения массива магазинов, созданных//том же классе.");
        shopShop.addShop(shop0);
        System.out.println(shopShop.getTempShopNumber());
        shopShop.printShopArray();
        try {
            shopShop.getShop(4);
        } catch (GeneralException e) {
            e.printStackTrace();
        }


        //Теперь создадим новый магазин с целью использования метода, который заменяет магазин из массива магазинов на указанный новый.
        AnimeShop shop2 = new AnimeShop();
        shop2.setToyPrice(20);
        shop2.setShopAddress("Washington avenu");
        shop2.setShopName("Japanese");
        shop2.setNumberOfToys(200);
        shop2.addToy(animeToy1);
        System.out.println("Сейчас программа вылетит");
        try {
            shopShop.editShopByIndex(0, shop2);
        } catch (GeneralException e) {
            e.printStackTrace();
        }
        shopShop.addShop(shop2);
        try {
            shopShop.editShopByIndex(112, shop0);
        } catch (GeneralException e) {
            e.printStackTrace();
        }
        shopShop.printShopArray();

        System.out.println("Теперь выведем название и адрес выбранного магазина по его номеру в массиве.");
        try {
            shopShop.printShopNameByIndex(6);
        } catch (GeneralException e) {
            e.printStackTrace();
        }
        try {
            shopShop.printShopAddressByIndex(0);
        } catch (GeneralException e) {
            e.printStackTrace();
        }
        System.out.println("Теперь выведем список всех игрушек во всех магазинах.");
        shopShop.printToyList();


        System.out.println("Теперь воспользуемся методом, который выводит фигурки из магазин, где их стоимость наибольшая");
        shopShop.printToyWithMaxPrice();
        System.out.println(shopShop.getTempShopNumber());


        System.out.println("Теперь воспользуемся методом, который выводит фигурки из магазин, где их стоимость наименьшая");
        shopShop.printToyWithMinPrice();

        System.out.println("Теперь выведем общую стоимость всего игрового ассортимента:");
        System.out.println(shopShop.printGeneralPriceOfToys());

        System.out.println("Теперь выведем имена и фэндомы фигурок определённых типов:");
        String editTypeString1 = "Nendoroid";
        String editTypeString2 = "Action figure";
        shopShop.printNamesAndFnadomsOfCertainTypeOfToys(editTypeString1);
        shopShop.printNamesAndFnadomsOfCertainTypeOfToys(editTypeString2);

        System.out.println("Теперь выведем имена фигурок определённого фэендома, количество которых в магазинах больше двух:");
        String editFandomString1 = "One piece";
        String editFandomString2 = "Naruto";
        shopShop.printNamesOfCertainFandomOfToys(editFandomString1);
        shopShop.printNamesOfCertainFandomOfToys(editFandomString2);

        System.out.println("Теперь выведем на экран среднюю стоимость фигурок определённого типа без учёта их количества:");
        System.out.println("Тип " + editTypeString1 + " " + shopShop.calculatingAveragePriceOfCertainTypeOfToy(editTypeString1));
        System.out.println("Тип " + editTypeString2 + " " + shopShop.calculatingAveragePriceOfCertainTypeOfToy(editTypeString2));

        System.out.println("Теперь воспользуемся методом определения магазинов, в которых продаются определённые фигурки");
        shopShop.printCertainFigure(animeToy);
        shopShop.printCertainFigure(animeToy1);
    }
}