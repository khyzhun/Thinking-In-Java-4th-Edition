package Problems.Chapter17_DetailsAboutContainers.d_FunctionalityOfCollection;

import Problems.Chapter17_DetailsAboutContainers.c_Abstract.Countries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author SashaKhyzhun on 5/12/17. Page 652.
 * Операции, которые могут выполняться со всеми разновидностями Collection.
 */
public class CollectionMethods {

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");
        System.out.println(c);






        // Создание массива на базе List:
        Object[] array = c.toArray();
        // Создание массива String на базе List:
        String[] str = c.toArray(new String[0]);

        // Поиск наибольшего и наименьшего элементов смысл может
        // зависеть от того, как реализован интерфейс Comparable:
        System.out.println("Collections.max(c) = " + Collections.max(c));
        System.out.println("Collections.min(c) = " + Collections.min(c));

        // Добавление Collections в другой объект Collection:
        Collection<String> c2 = new ArrayList<>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        System.out.println(c);

        c.remove(Countries.DATA[0][0]);
        System.out.println(c);
        c.remove(Countries.DATA[1][0]);
        System.out.println(c);

        // Удаление всех компонентов, присутствующих в коллекции-аргумете:
        c.removeAll(c2);
        System.out.println(c);
        c.addAll(c2);
        System.out.println(c);

        // Элемент присутствует в Collection?
        String val = Countries.DATA[3][0];
        System.out.println("c.contains(" + val + ") = " + c.contains(val));

        // Содержимое Collection входит в другой объект Collection?
        System.out.println("c.containsAll(c2) = " + c.containsAll(c2));

        Collection<String> c3 = ((List<String>)c).subList(3, 5);

        // Оставить все элементы, присутствующие в c2 и c3 (пересечение множеств):
        c2.retainAll(c3);
        System.out.println(c2);

        // Удалить из с2 все элементы, также присутствующие в с3:
        c2.removeAll(c3);
        System.out.println("c2.isEmpty() = " + c2.isEmpty());

        c = new ArrayList<>();
        c.addAll(Countries.names(6));
        System.out.println(c);

        c.clear(); // Удаление всех элементов
        System.out.println("after c.clear(): " + c);


    }

}
