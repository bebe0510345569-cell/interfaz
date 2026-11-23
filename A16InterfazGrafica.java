import javax.swing.*;
import java.awt.*;

public class A16InterfazGrafica extends JFrame {
    private final JTextField txtNombre;
    private final JTextField txtMatricula;
    private final JComboBox<String> cmbCarrera;

    public A16InterfazGrafica() {
        setTitle("A16 - Registro de estudiante");
        setSize(430, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Nombre completo:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Matrícula:"));
        txtMatricula = new JTextField();
        panel.add(txtMatricula);

        panel.add(new JLabel("Carrera:"));
        cmbCarrera = new JComboBox<>(new String[] {
            "Ingeniería en Computación",
            "Ingeniería Electrónica",
            "Licenciatura en Informática",
            "Otra"
        });
        panel.add(cmbCarrera);

        JButton btnRegistrar = new JButton("Registrar");
        JButton btnLimpiar = new JButton("Limpiar");
        panel.add(btnRegistrar);
        panel.add(btnLimpiar);

        btnRegistrar.addActionListener(e -> registrarEstudiante());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        add(panel);
    }

    private void registrarEstudiante() {
        String nombre = txtNombre.getText().trim();
        String matricula = txtMatricula.getText().trim();
        String carrera = (String) cmbCarrera.getSelectedItem();

        if (nombre.isEmpty() || matricula.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Completa el nombre y la matrícula.",
                "Datos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String mensaje = "Registro realizado correctamente.\n\n"
                + "Nombre: " + nombre + "\n"
                + "Matrícula: " + matricula + "\n"
                + "Carrera: " + carrera;

        JOptionPane.showMessageDialog(this, mensaje,
                "Registro de estudiante", JOptionPane.INFORMATION_MESSAGE);
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtMatricula.setText("");
        cmbCarrera.setSelectedIndex(0);
        txtNombre.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new A16InterfazGrafica().setVisible(true));
    }
}
