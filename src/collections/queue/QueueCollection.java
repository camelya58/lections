package collections.queue;

import java.util.*;

/**
 * Class QueueCollection demonstrates Queue using class PriorityQueue and contains all methods of class PriorityQueue.
 * extends AbstractQueue<E> implements Serializable
 *
 * @author Kamila Meshcheryakova
 * created by 24.07.2020
 */
public class QueueCollection {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // Виды конструкторов
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(20);
        PriorityQueue<Integer> priorityQueue3 = new PriorityQueue<>(priorityQueue); // or class implements SortedSet<T>

        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            priorityQueue.add(rand.nextInt(100));
        }

        for (int i = 0; i < 20; i++) {
            priorityQueue2.offer(rand.nextInt(100));
        }

        System.out.println("Все элементы priorityQueue " + Arrays.toString(priorityQueue.toArray()));
        System.out.println("priorityQueue содержит 34? " + priorityQueue.contains(34));

        Integer number = priorityQueue.peek();
        System.out.println("Первый элемент priorityQueue - "+ number);
        Integer number2 = priorityQueue.element();
        assert number != null;
        System.out.println("Результат работы метода peek() соответствует результату работы метода element() - " +
                number.equals(number2));

        System.out.println("Все элементы priorityQueue2 " + Arrays.toString(priorityQueue2.toArray()));
        priorityQueue2.poll();
        System.out.println("Все элементы priorityQueue2 после работы метода poll()"
                + Arrays.toString(priorityQueue2.toArray()));
        priorityQueue2.remove();
        System.out.println("Все элементы priorityQueue2 после работы метода remove()"
                + Arrays.toString(priorityQueue2.toArray()));


        priorityQueue3.addAll(priorityQueue2);
        System.out.println("priorityQueue3 после добавления в нее всех элементов priorityQueue2 "
                + Arrays.toString(priorityQueue3.toArray()));

        System.out.println("Все элементы priorityQueue " + Arrays.toString(priorityQueue.toArray()));
        priorityQueue.forEach(integer -> {
            if (integer > 40)
            System.out.println("Элемент " + integer + " больше 20.");
        });

        priorityQueue3.removeAll(priorityQueue);
        System.out.println("priorityQueue3 после удаления из нее всех элементов priorityQueue "
                + Arrays.toString(priorityQueue3.toArray()));

        System.out.println("Результат удаления элемента 45 из priorityQueue3 " + priorityQueue3.remove(45));

        priorityQueue3.removeIf(e -> e > 60);
        System.out.println("Удаление всех элементов больше 60 из priorityQueue3 "
                + Arrays.toString(priorityQueue3.toArray()));

        priorityQueue2.retainAll(priorityQueue);
        System.out.println("Все элементы priorityQueue2 после удаления всех элементов не из коллекции  priorityQueue"
                + Arrays.toString(priorityQueue2.toArray()));

        priorityQueue.clear();
        System.out.println("priorityQueue после удаления всех элементов " + Arrays.toString(priorityQueue.toArray()));

        while (priorityQueue3.iterator().hasNext()) {
            System.out.println("Каждый элемент priorityQueue3 " + priorityQueue3.iterator().next());
            priorityQueue3.remove();
        }

        Comparator<Integer> comparator = (Comparator<Integer>) priorityQueue2.comparator();
        if (comparator == null) System.out.println("Элементы priorityQueue2 находятся в естественном порядке.");
        else System.out.println("priorityQueue2 имеет comparator - " + comparator);

        System.out.println("Все элементы priorityQueue2 " + Arrays.toString(priorityQueue2.toArray()));
        Spliterator<Integer> spliterator= priorityQueue2.spliterator();
        if (spliterator.trySplit() == null)
            System.out.println("Spliterator для очереди priorityQueue2 не может быть использован.");
        else System.out.println(spliterator.trySplit().characteristics());

        PriorityQueue<String> queueString = new PriorityQueue<>();
        queueString.add("Goodbye");
        queueString.add("World");
        queueString.offer("Welcome ");
        queueString.offer("Hello");

        Spliterator<String> stringSpliterator = queueString.spliterator();
        stringSpliterator.trySplit().forEachRemaining(System.out::println);

        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int len = array1.length;
        int[] reverse = new int[len];
        for (int i = 0; i < len; i++) {
            reverse[i] = array1[len - 1 - i];
        }
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(reverse));

    }
}