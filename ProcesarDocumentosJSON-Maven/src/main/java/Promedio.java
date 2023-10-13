import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Promedio {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Double>> Prices = new HashMap<>();

        try{
            FileReader reader = new FileReader("src\\main\\java\\car_sales.json");

            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            //Gson gson = new Gson();
            //BufferedReader br = new BufferedReader(reader);
            //String linea;
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject carObject = jsonArray.get(i).getAsJsonObject();

                String marca = carObject.get("car").getAsString();
                String strPrecio = carObject.get("price").getAsString();
                double precio = Double.parseDouble(strPrecio.replace("$", ""));
                if (!Prices.containsKey(marca)) {
                    ArrayList<Double> precioList = new ArrayList<>();
                    precioList.add(precio);
                    Prices.put(marca, precioList);
                } else {
                    Prices.get(marca).add(precio);
                }
            }

            for (String car:Prices.keySet()){
                //System.out.println("Marca: "+car+" Precios: "+Prices.get(car));
                double sumatoria = 0;
                int tamanio = Prices.get(car).size();
                double promedio = 0;
                for (Double price: Prices.get(car)) {
                    sumatoria+=price;
                    promedio = (sumatoria/tamanio);
                }
                System.out.println("\nMarca: "+car);
                System.out.println("Sumatoria: "+ sumatoria);
                System.out.println("Promedio: "+ promedio);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
