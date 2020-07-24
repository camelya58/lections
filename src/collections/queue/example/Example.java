package collections.queue.example;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Class Example demonstrates the use of different constructors of PriorityQueue and
 * different comparison ways of elements in queue.
 *
 * @author Kamila Meshcheryakova
 * created by 24.07.2020
 */
public class Example {
    public static void main(String[] args) {

        //пример естественного добавления элементов в приоритетную очередь
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            integerPriorityQueue.add(rand.nextInt(100));
        }
        for (int i = 0; i < 7; i++) {
            Integer in = integerPriorityQueue.poll();
            System.out.println("Обрабатываем Integer:" + in);
        }
        System.out.println("________________________");

        //Пример PriorityQueue с компаратором по id
        PriorityQueue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
        addDataToQueue(customerPriorityQueue);

        pollDataFromQueue(customerPriorityQueue);
        System.out.println("________________________");


        //Пример PriorityQueue с компаратором по status
        PriorityQueue<Customer> customerPriorityQueueStatus = new PriorityQueue<>(7, statusComparator);

        addDataToQueue(customerPriorityQueueStatus);
        pollDataFromQueue(customerPriorityQueueStatus);
    }

    //Анонимный класс компаратора  по id
    public static Comparator<Customer> idComparator = new Comparator<Customer>() {

        @Override
        public int compare(Customer c1, Customer c2) {
            return (int) (c1.getId() - c2.getId());
        }
    };

    //Анонимный класс компаратора по status
    public static Comparator<Customer> statusComparator = new Comparator<Customer>() {

        @Override
        public int compare(Customer c1, Customer c2) {
            return c1.getStatus().compareTo(c2.getStatus());
        }
    };

    // служебный метод добавления элементов в очередь
    private static void addDataToQueue(Queue<Customer> queue) {
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            int id = rand.nextInt(100);
            if (id < 30) queue.add(new Customer(id, "Pankaj " + id, Status.VIP));
            else queue.add(new Customer(id, "Pankaj " + id, Status.USUAL));
        }
    }

    //служебный метод для обработки данных очереди
    private static void pollDataFromQueue(Queue<Customer> queue) {
        while (true) {
            Customer customer = queue.poll();
            if (customer == null) break;
            System.out.println("Обработка клиента с id = " + customer.getId() + ", status = " + customer.getStatus());
        }
    }
}
