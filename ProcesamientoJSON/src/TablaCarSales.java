
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TablaCarSales {

    public static void main(String[] args) throws IOException {

        File file = new File("car_sales.json");
        List<CarSale> carSales = CarSale.fromJson(file);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"id", "first name", "last name", "car", "Price", "state"});

        for (CarSale carSale : carSales) {
            tableModel.addRow(new Object[]{carSale.getId(),carSale.getFirst_name(), carSale.getLast_name(), carSale.getcar(), carSale.getPrice(),carSale.getState()});
        }

        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JFrame frame = new JFrame();
        frame.setBounds(500,200,0,0);
        frame.setContentPane(panel);
        frame.setTitle("Ventas de autos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}