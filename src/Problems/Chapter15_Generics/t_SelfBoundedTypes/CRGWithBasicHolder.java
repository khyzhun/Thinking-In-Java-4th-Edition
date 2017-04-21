package Problems.Chapter15_Generics.t_SelfBoundedTypes;

/**
 * @author SashaKhyzhun on 3/16/17. Page 568.
 * Это вполне рядовой обобщенный тип с методами, которые получают
 * и позвращают объект параметра-типа, а также методом, который работает
 * с полем (хотя и выполняет с ним только операции Object).
 *
 * BasicHolder можно использовать в необычном рекурсивном обобщении:
 */

class Subtype extends BasicHolder<Subtype> {}

public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype();
        Subtype st2 = new Subtype();

        st1.set(st2);
        st1.f();

        Subtype st3 = st1.get(); // работает

    }

    /**
     * Обратите внимание на важную подробность: новый класс Subtype получает аргументы
     * и возвращает значения типа Subtype, а не базового класса BasicHolder. В этом
     * проявляется сущность необычных рекурсивных обобщений:
     *
     * -->> базовый класс (BaseHolder) заменяет свои параметры <T> производным классом (Subtype).
     *
     *
     * Это означает, что обобщенный базовый класс становится своего рода шаблоном общей
     * функциональности для всех производных классов, но эта функциональность будет использовать
     * производный тип для всех своих аргументов и возвращаемых значений. Иначе говоря,
     * в полученном классе будет использоваться точный тип вместо базового типа.
     * Таким образом, в Subtype и аргументы set(), и возвращаемое значение get()
     * относятся к точному типу Subtype.
     */
}