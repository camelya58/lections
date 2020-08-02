package collections.queue.example;

/**
 * Class DescriptionQueue contains all information about PriorityQueue.
 *
 * @author Kamila Meshcheryakova
 * created by 24.07.2020
 */
public class DescriptionQueue {
    /**
     Очереди работают по следующей модели: FIFO (First In First Out — «первым пришёл — первым ушёл»).

     Приоритетная очередь:
     - класс введен в Java 1.5;
     - по умолчанию поддерживает натуральный порядок (наименьший элемент в начале,
       если наименьших несколько, любой из них);
     - порядок может быть изменен при создании в конструкторе с помощью Comparator;
     - не позволяет располагать  null элементы, а также non-comparable объекты (должны имплементировать Comparable);
     - с добавление элементов размер увеличивается автоматически, изначально равен 11;
     - не синхронизована, в многопоточности использовать class PriorityBlockingQueue;

     Сложность:
     - вставка/удаление первого элемента (offer, poll, remove() and add) - O(log(n));
     - удаление любого элемента/поиск (remove(Object) and contains(Object)) - О(n);
     - возвращение элемента (peek, element, and size) - О(1).
     (с) https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/PriorityQueue.html

     - вставка/извлечение для массивов и связных списков - О(n);
     - вставка/извлечение для биноминальныхх, фибоначчи и др. куч - O(log(n)).
     (с) https://en.wikipedia.org/wiki/Priority_queue

     Пример использования PriorityQueue (обработка объектов в очереди, основанной на приоритете):

     Когда клиенты посылают запросы к нашему приложению, то образуется очередь,
     но мы хотим обработать премиум клиентов первыми, а обычных клиентов уже после них.
     */

    /** приватные методы, настраивающие реализацию поведения приоритетной очереди

     * private static Object[] ensureNonEmpty(Object[] es) - позволяет убедиться, что очередь не пустая;

     * private void initFromPriorityQueue(PriorityQueue<? extends E> c) - инициализация элементов в коллекции;
     * private void initElementsFromCollection(Collection<? extends E> c)
     * private void initFromCollection(Collection<? extends E> c)

     * private void grow(int minCapacity) {} - автоматическое увеличение размера;

     * private int indexOf(Object o) {} - возвращает индекс элемента по размеру очереди;

     * private void siftUp(int k, E x) - вставляет элемент x в позицию k согласно произведенным сравнениям;

     * private static <T> void siftUpComparable(int k, T x, Object[] es) - сравнивает элементы в естественном порядке
       по возрастанию;

     * private static <T> void siftUpUsingComparator(int k, T x, Object[] es, Comparator<? super T> cmp) - сравнивает
       элементы по заданному порядку по возрастанию;

     * private void siftDown(int k, E x) - вставляет элемент x в позицию k согласно произведенным сравнениям;

     * private static <T> void siftDownComparable(int k, T x, Object[] es, int n) сравнивает элементы в естественном
       порядке по убыванию;

     * private static <T> void siftDownUsingComparator(int k, T x, Object[] es, int n, Comparator<? super T> cmp) -
       сравнивает элементы по заданному порядку по убыванию;

     * private void heapify() - устанавливает инвариантность в дереве вне зависимости от порядка до вызова метода;

     * private void writeObject(java.io.ObjectOutputStream s) throws IOException - сохраняет эту очередь в поток,
       сериализует ее;

     * private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException - восстанавливает
       очередь из потока, дессериализует ее;

     * private boolean bulkRemove(Predicate<? super E> filter) - реализует методы массового удаления объектов.

     */

    /** методы с доступом по умолчанию:
     * void removeEq(Object o) - удаляет элемент по индексу;
     *
     * E removeAt(int i) - удаляет элемент по индексу и возвращает его;
     */

    /** унаследованные методы:
    Methods declared in class java.util.AbstractQueue
            addAll, element, remove

            * boolean addAll(Collection<? extends E> c) - добавляет все элементы другой коллекции в очередь;

            * E element() - возвращает элемент из головы очереди,
              похож на peek(), но выбрасывает исключение, если очередь пуста;

            * E remove() - возвращает элемент из головы очереди и удаляет его,
              похож на poll(), но выбрасывает исключение, если очередь пуста;


    Methods declared in interface java.util.Queue
            peek, poll

            * E peek() - возвращает элемент из головы очереди или null, если очередь пуста;

            * E poll() - возвращает элемент из головы очереди и удаляет его, или null, если очередь пуста.

    Methods declared in class java.util.AbstractCollection
            containsAll, isEmpty, toString

    Methods declared in class java.lang.Object
            clone, equals, finalize, getClass, hashCode, notify, notifyAll, wait, wait, wait

    Methods declared in interface java.util.Collection
            containsAll, equals, hashCode, isEmpty, parallelStream, size, stream, toArray

    */

    /** общие методы:
     * boolean	add​(E e) - вставляет элемент согласно приоритету в очередь;

     * void	clear() - удаляет все элементы в очереди;

     * Comparator<? super E>	comparator() - возвращает компаратор, использованный для упорядочения элементов
       в этой очереди, или ноль, если эта очередь отсортирована в естественном порядке;

     * boolean	contains​(Object o) - возвращает true, если очередь содержит такой элемент;

     * void	forEach​(Consumer<? super E> action) - выполняет данное действие для каждого элемента очереди,
       пока все элементы не будут обработаны или действие не вызовет исключение;

     * Iterator<E>	iterator() - возвращает итератор для элементов в этой очереди;

     * boolean	offer​(E e) - вставляет элемент согласно приоритету в очередь, аналогично с add​(E e);

     * boolean	remove​(Object o) - удаляет элемент из очереди, если он существует;

     * boolean	removeAll​(Collection<?> c) - удаляет все элементы из очереди, принадлежащие переданной коллекции;

     * boolean	removeIf​(Predicate<? super E> filter) - удаляет все элементы из коллекции, удовлетворяющии требованию;

     * boolean	retainAll​(Collection<?> c) - удаляет все элементы из очереди, НЕ принадлежащие переданной коллекции;

     * Spliterator<E>	spliterator() - создает отказоустойчивый Spliterator для элементов в этой очереди;

     * Object[]	toArray() - возращает массив из элементов очереди;

     * <T> T[]	toArray​(T[] a) - возвращает массив, содержащий все элементы в этой очереди по указанному типу;
     */
}
