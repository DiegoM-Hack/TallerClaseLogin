import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JPanel contentPane;
    private JButton buttonAcceder;
    private JButton buttonCancel;
    private JTextField usuario;
    private JPasswordField passwordField1;
    private JTextField textField1;

    public Login() {
        setTitle("LOGIN");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setVisible(true);

        buttonAcceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificar();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });



        JLabel lblUsuario = new JLabel("Jugadores");

        lblUsuario.setBounds(30,40,200,25);
        //lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsuario.setLocale(null);
        contentPane.add(lblUsuario);

        JLabel lblApellido = new JLabel("Apellidos");
        lblApellido.setBounds(30,60,200,25);
        contentPane.add(lblApellido);
    }

    private void verificar() {
        String u = usuario.getText();
        char[] pass = passwordField1.getPassword();
        if (u.isEmpty() || pass.length == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (u.equals("administrador") && String.valueOf(pass).equals("clave")) {
            Bienvenido banco = new Bienvenido();
            buttonAcceder.addActionListener(e -> verificar());

        }else if (u.equals("jugador") && String.valueOf(pass).equals("clave")) {
            Datos jugador = new Datos();
            buttonAcceder.addActionListener(e -> verificar());
        } else{
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new Login());
    }
}
