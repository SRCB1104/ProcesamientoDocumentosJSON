import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CarSale {

    private int id;
    private String first_name;
    private String last_name;

    private String car;
    private String price;

    private String state;

    public CarSale() {
    }

    public CarSale(String model, String brand, int year, double price) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.car = car;
        this.price = String.valueOf(price);
        this.state = state;
    }

    public int getId(){
        return id;
    }
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getcar() {
        return car;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = String.valueOf(price);
    }

    public String getState() {
        return state;
    }


    @Override
    public String toString() {
        return "CarSale{" +
                "id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", car=" + car + '\''+
                ", price=" + price + '\''+
                ", State=" + state +
                '}';
    }

    public static List<CarSale> fromJson(File file) throws IOException {
        // Leer el archivo JSON
        String json = new String(Files.readAllBytes(file.toPath()));

        // Convertir el JSON en una lista de ventas de autos
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<List<CarSale>>(){});
    }
}
