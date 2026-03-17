package org.example.view;

import org.example.controller.UsuarioController;
import org.example.model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UsuarioView extends JFrame {

    private UsuarioController controller;

    private JTextField txtId, txtNombre, txtCedula, txtTipo;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public UsuarioView() {
        controller = new UsuarioController();

        setTitle("Sistema de Biblioteca - Gestión de Usuarios");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
        cargarTabla();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        // 🔹 Panel formulario
        JPanel panelForm = new JPanel(new GridLayout(4, 2));

        panelForm.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelForm.add(txtId);

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        panelForm.add(txtCedula);

        panelForm.add(new JLabel("Tipo:"));
        txtTipo = new JTextField();
        panelForm.add(txtTipo);

        panel.add(panelForm, BorderLayout.NORTH);

        // 🔹 Tabla
        modeloTabla = new DefaultTableModel(new String[]{
                "ID", "Nombre", "Cédula", "Tipo"
        }, 0);

        tabla = new JTable(modeloTabla);
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

        // 🔹 Botones
        JPanel panelBotones = new JPanel();

        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnBuscar = new JButton("Buscar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnBuscar);

        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel);

        // 🔥 EVENTOS
        btnAgregar.addActionListener(e -> {
            boolean ok = controller.agregarUsuario(
                    txtNombre.getText(),
                    txtCedula.getText(),
                    txtTipo.getText()
            );

            if (ok) {
                JOptionPane.showMessageDialog(this, "Usuario agregado correctamente");
                limpiarCampos();
                cargarTabla();
            }
        });

        btnActualizar.addActionListener(e -> {
            boolean ok = controller.actualizarUsuario(
                    Integer.parseInt(txtId.getText()),
                    txtNombre.getText(),
                    txtCedula.getText(),
                    txtTipo.getText()
            );

            if (ok) {
                JOptionPane.showMessageDialog(this, "Usuario actualizado");
                limpiarCampos();
                cargarTabla();
            }
        });

        btnEliminar.addActionListener(e -> {
            boolean ok = controller.eliminarUsuario(
                    Integer.parseInt(txtId.getText())
            );

            if (ok) {
                JOptionPane.showMessageDialog(this, "Usuario eliminado");
                limpiarCampos();
                cargarTabla();
            }
        });

        btnBuscar.addActionListener(e -> {
            Usuario usuario = controller.buscarUsuario(
                    Integer.parseInt(txtId.getText())
            );

            if (usuario != null) {
                txtNombre.setText(usuario.getNombre());
                txtCedula.setText(usuario.getCedula());
                txtTipo.setText(usuario.getTipo());
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado");
            }
        });

        // Click en tabla
        tabla.getSelectionModel().addListSelectionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtId.setText(modeloTabla.getValueAt(fila, 0).toString());
                txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
                txtCedula.setText(modeloTabla.getValueAt(fila, 2).toString());
                txtTipo.setText(modeloTabla.getValueAt(fila, 3).toString());
            }
        });
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        List<Usuario> lista = controller.obtenerUsuarios();

        for (Usuario u : lista) {
            modeloTabla.addRow(new Object[]{
                    u.getId(),
                    u.getNombre(),
                    u.getCedula(),
                    u.getTipo()
            });
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtCedula.setText("");
        txtTipo.setText("");
    }
}
