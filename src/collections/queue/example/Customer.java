package collections.queue.example;

import java.util.Objects;

/**
 * Class Customer
 *
 * @author Kamila Meshcheryakova
 * created by 24.07.2020
 */
public class Customer {

    private int id;
    private String name;
    private Status status;

    public Customer(int i, String n) {
        this(i, n, null);
    }

    public Customer(int i, String n, Status status) {
        this.id = i;
        this.name = n;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(name, customer.name) &&
                status == customer.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status);
    }
}

enum Status{
    VIP, USUAL
}
