package org.example;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XMLtoJSON {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("car_sales.xml");
            XmlMapper xmlMapper = new XmlMapper();
            JsonNode jsonNode = xmlMapper.readTree(xmlFile);
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            System.out.println(json);

            File jsonFile = new File("car_sales.json");
            jsonMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, jsonNode);
            System.out.println("El archivo JSON a sido guardado exitosamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
