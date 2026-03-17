package org.example.view;

import org.example.controller.LibroController;
import org.example.model.Libro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class LibroView extends JFrame {

    private LibroController controller;

    private JTextField txtId, txtTitulo, txtAutor, txtCategoria;
    private JCheckBox chkDisponible;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public LibroView() {
        controller = new LibroController();

        setTitle("Sistema de Biblioteca - Gestión de Libros");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
        cargarTabla();
    }

    private void initComponents() {

        JPanel panel = new JPanel(new BorderLayout());

        // 🔹 Panel formulario
        JPanel panelForm = new JPanel(new GridLayout(5, 2));

        panelForm.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelForm.add(txtId);

        panelForm.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panelForm.add(txtTitulo);

        panelForm.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        panelForm.add(txtAutor);

        panelForm.add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        panelForm.add(txtCategoria);

        panelForm.add(new JLabel("Disponible:"));
        chkDisponible = new JCheckBox();
        chkDisponible.setSelected(true);
        panelForm.add(chkDisponible);

        panel.add(panelForm, BorderLayout.NORTH);

        // 🔹 Tabla
        modeloTabla = new DefaultTableModel(new String[]{
                "ID", "Título", "Autor", "Categoría", "Disponible"
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
            boolean ok = controller.agregarLibro(
                    txtTitulo.getText(),
                    txtAutor.getText(),
                    txtCategoria.getText()
            );

            if (ok) {
                JOptionPane.showMessageDialog(this, "Libro agregado correctamente");
                limpiarCampos();
                cargarTabla();
            }
        });

        btnActualizar.addActionListener(e -> {
            boolean ok = controller.actualizarLibro(
                    Integer.parseInt(txtId.getText()),
                    txtTitulo.getText(),
                    txtAutor.getText(),
                    txtCategoria.getText(),
                    chkDisponible.isSelected()
            );

            if (ok) {
                JOptionPane.showMessageDialog(this, "Libro actualizado");
                limpiarCampos();
                cargarTabla();
            }
        });

        btnEliminar.addActionListener(e -> {
            boolean ok = controller.eliminarLibro(
                    Integer.parseInt(txtId.getText())
            );

            if (ok) {
                JOptionPane.showMessageDialog(this, "Libro eliminado");
                limpiarCampos();
                cargarTabla();
            }
        });

        btnBuscar.addActionListener(e -> {
            Libro libro = controller.buscarLibro(
                    Integer.parseInt(txtId.getText())
            );

            if (libro != null) {
                txtTitulo.setText(libro.getTitulo());
                txtAutor.setText(libro.getAutor());
                txtCategoria.setText(libro.getCategoria());
                chkDisponible.setSelected(libro.isDisponible());
            } else {
                JOptionPane.showMessageDialog(this, "Libro no encontrado");
            }
        });

        // Click en tabla
        tabla.getSelectionModel().addListSelectionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtId.setText(modeloTabla.getValueAt(fila, 0).toString());
                txtTitulo.setText(modeloTabla.getValueAt(fila, 1).toString());
                txtAutor.setText(modeloTabla.getValueAt(fila, 2).toString());
                txtCategoria.setText(modeloTabla.getValueAt(fila, 3).toString());
                chkDisponible.setSelected(
                        Boolean.parseBoolean(modeloTabla.getValueAt(fila, 4).toString())
                );
            }
        });
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        List<Libro> lista = controller.obtenerLibros();

        for (Libro l : lista) {
            modeloTabla.addRow(new Object[]{
                    l.getId(),
                    l.getTitulo(),
                    l.getAutor(),
                    l.getCategoria(),
                    l.isDisponible()
            });
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtCategoria.setText("");
        chkDisponible.setSelected(true);
    }
}