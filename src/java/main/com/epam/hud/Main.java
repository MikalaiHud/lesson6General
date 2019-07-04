package com.epam.hud;



import com.epam.hud.entity.AnimeShop;
import com.epam.hud.entity.AnimeToy;
import com.epam.hud.exception.AnimeException;
import com.epam.hud.file.FileWorker;
import com.epam.hud.logic.ShopContainer;

import java.io.IOException;
import java.util.ArrayList;

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
        ShopContainer shopContainer = new ShopContainer();


        //Далее применён метод, прописанный в классе ShopContainer для заполнения массива магазинов, созданных в
        //том же классе.
        System.out.println("Далее применён метод, прописанный в классе ShopContainer для заполнения массива магазинов, созданных//том же классе.");
        shopContainer.addShop(shop0);
        System.out.println(shopContainer.getTempShopNumber());
        shopContainer.printShopArray();
        try {
            shopContainer.getShop(4);
        } catch (AnimeException e) {
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
            shopContainer.editShopByIndex(0, shop2);
        } catch (AnimeException e) {
            e.printStackTrace();
        }
        shopContainer.addShop(shop2);
        try {
            shopContainer.editShopByIndex(112, shop0);
        } catch (AnimeException e) {
            e.printStackTrace();
        }
        shopContainer.printShopArray();

        System.out.println("Теперь выведем название и адрес выбранного магазина по его номеру в массиве.");
        try {
            shopContainer.printShopNameByIndex(6);
        } catch (AnimeException e) {
            e.printStackTrace();
        }
        try {
            shopContainer.printShopAddressByIndex(0);
        } catch (AnimeException e) {
            e.printStackTrace();
        }
        System.out.println("Теперь выведем список всех игрушек во всех магазинах.");
        shopContainer.printToyList();


        System.out.println("Теперь воспользуемся методом, который выводит фигурки из магазин, где их стоимость наибольшая");
        shopContainer.printToyWithMaxPrice();
        System.out.println(shopContainer.getTempShopNumber());


        System.out.println("Теперь воспользуемся методом, который выводит фигурки из магазин, где их стоимость наименьшая");
        shopContainer.printToyWithMinPrice();

        System.out.println("Теперь выведем общую стоимость всего игрового ассортимента:");
        System.out.println(shopContainer.printGeneralPriceOfToys());

        System.out.println("Теперь выведем имена и фэндомы фигурок определённых типов:");
        String editTypeString1 = "Nendoroid";
        String editTypeString2 = "Action figure";
        shopContainer.printNamesAndFnadomsOfCertainTypeOfToys(editTypeString1);
        shopContainer.printNamesAndFnadomsOfCertainTypeOfToys(editTypeString2);

        System.out.println("Теперь выведем имена фигурок определённого фэендома, количество которых в магазинах больше двух:");
        String editFandomString1 = "One piece";
        String editFandomString2 = "Naruto";
        shopContainer.printNamesOfCertainFandomOfToys(editFandomString1);
        shopContainer.printNamesOfCertainFandomOfToys(editFandomString2);

        System.out.println("Теперь выведем на экран среднюю стоимость фигурок определённого типа без учёта их количества:");
        System.out.println("Тип " + editTypeString1 + " " + shopContainer.calculatingAveragePriceOfCertainTypeOfToy(editTypeString1));
        System.out.println("Тип " + editTypeString2 + " " + shopContainer.calculatingAveragePriceOfCertainTypeOfToy(editTypeString2));

        System.out.println("Теперь воспользуемся методом определения магазинов, в которых продаются определённые фигурки");
        shopContainer.printCertainFigure(animeToy);
        shopContainer.printCertainFigure(animeToy1);


        //Теперь попробуем сериализовать-десериализовать объект класса ShopContainer
        System.out.println("Теперь попробуем сериализовать объект класса ShopContainer");
        FileWorker fileWorker = new FileWorker();
        try {
            fileWorker.writeShops("shopContainer1.txt", shopContainer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<AnimeShop> arrayList = new ArrayList<AnimeShop>();
        System.out.println("Теперь попробуем десериализовать объект класса ShopContainer");
        try {
            arrayList.addAll(fileWorker.readShops("shopContainer1.txt"));
            System.out.println(arrayList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}