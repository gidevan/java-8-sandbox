package chapter6;


public class Transaction {
    private String id;
    private String city;
    private String currency;
    private Double value;

    public Transaction(String id, String city, String currency, Double value) {
        this.id = id;
        this.city = city;
        this.currency = currency;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", currency='" + currency + '\'' +
                ", value=" + value +
                '}';
    }
}
