import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Datos extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton agregarButton;
    private JButton mostrarButton;
    private JButton limpiarButton;
    private JPanel TablaDatos;
    private JTable table1;
    private JPanel principal2;

    // Lista para almacenar los datos agregados
    private ArrayList<String[]> listaDatos = new ArrayList<>();

    // Modelo de tabla
    private DefaultTableModel tableModel;

    public Datos() {
        setTitle("Interfaz de Banco");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(principal2);
        setLocationRelativeTo(null);

        // Inicializar la tabla con encabezados
        String[] columnas = {"NOMBRE", "APELLIDO", "EDAD", "ESTATURA", "NOMBRE DE EQUIPO"};
        tableModel = new DefaultTableModel(columnas, 0);
        table1.setModel(tableModel);

        setVisible(true);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregar();
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrar();
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }

    private void agregar() {
        // Obtener datos de los campos de texto
        String[] fila = new String[5];
        fila[0] = textField1.getText();
        fila[1] = textField2.getText();
        fila[2] = textField3.getText();
        fila[3] = textField4.getText();
        fila[4] = textField5.getText();

        // Verificación simple para no guardar filas vacías
        boolean vacia = true;
        for (String s : fila) {
            if (!s.trim().isEmpty()) {
                vacia = false;
                break;
            }
        }

        if (!vacia) {
            listaDatos.add(fila);
            JOptionPane.showMessageDialog(this, "Datos agregados correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Todos los campos están vacíos.");
        }

        limpiar(); // Limpiar después de agregar
    }

    private void mostrar() {
        // Limpiar la tabla antes de mostrar
        tableModel.setRowCount(0);

        // Agregar cada fila almacenada al modelo de tabla
        for (String[] fila : listaDatos) {
            tableModel.addRow(fila);
        }
    }

    private void limpiar() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
    }

    public static void main(String[] args) {
        new Datos();
    }
}
