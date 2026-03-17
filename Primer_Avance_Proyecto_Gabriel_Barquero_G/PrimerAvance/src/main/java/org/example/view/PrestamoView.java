package org.example.view;


import org.example.controller.PrestamoController;
import org.example.model.Prestamo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class PrestamoView extends JFrame {

    private PrestamoController controller;

    private JTextField txtId, txtIdLibro, txtIdUsuario, txtFechaPrestamo, txtFechaDevolucion;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public PrestamoView() {
        controller = new PrestamoController();

        setTitle("Sistema de Biblioteca - Gestión de Préstamos");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
        cargarTabla();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        // Formulario
        JPanel panelForm = new JPanel(new GridLayout(5,2));

        panelForm.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelForm.add(txtId);

        panelForm.add(new JLabel("ID Libro:"));
        txtIdLibro = new JTextField();
        panelForm.add(txtIdLibro);

        panelForm.add(new JLabel("ID Usuario:"));
        txtIdUsuario = new JTextField();
        panelForm.add(txtIdUsuario);

        panelForm.add(new JLabel("Fecha Préstamo (yyyy-mm-dd):"));
        txtFechaPrestamo = new JTextField();
        panelForm.add(txtFechaPrestamo);

        panelForm.add(new JLabel("Fecha Devolución (yyyy-mm-dd):"));
        txtFechaDevolucion = new JTextField();
        panelForm.add(txtFechaDevolucion);

        panel.add(panelForm, BorderLayout.NORTH);

        // Tabla
        modeloTabla = new DefaultTableModel(new String[]{
                "ID", "ID Libro", "ID Usuario", "Fecha Préstamo", "Fecha Devolución"
        },0);
        tabla = new JTable(modeloTabla);
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Botones
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

        // Eventos
        btnAgregar.addActionListener(e -> {
            boolean ok = controller.agregarPrestamo(
                    Integer.parseInt(txtIdLibro.getText()),
                    Integer.parseInt(txtIdUsuario.getText()),
                    LocalDate.parse(txtFechaPrestamo.getText()),
                    LocalDate.parse(txtFechaDevolucion.getText())
            );
            if(ok){
                JOptionPane.showMessageDialog(this,"Préstamo agregado");
                limpiarCampos();
                cargarTabla();
            }
        });

        btnActualizar.addActionListener(e -> {
            boolean ok = controller.actualizarPrestamo(
                    Integer.parseInt(txtId.getText()),
                    Integer.parseInt(txtIdLibro.getText()),
                    Integer.parseInt(txtIdUsuario.getText()),
                    LocalDate.parse(txtFechaPrestamo.getText()),
                    LocalDate.parse(txtFechaDevolucion.getText())
            );
            if(ok){
                JOptionPane.showMessageDialog(this,"Préstamo actualizado");
                limpiarCampos();
                cargarTabla();
            }
        });

        btnEliminar.addActionListener(e -> {
            boolean ok = controller.eliminarPrestamo(Integer.parseInt(txtId.getText()));
            if(ok){
                JOptionPane.showMessageDialog(this,"Préstamo eliminado");
                limpiarCampos();
                cargarTabla();
            }
        });

        btnBuscar.addActionListener(e -> {
            Prestamo p = controller.buscarPrestamo(Integer.parseInt(txtId.getText()));
            if(p!=null){
                txtIdLibro.setText(String.valueOf(p.getIdLibro()));
                txtIdUsuario.setText(String.valueOf(p.getIdUsuario()));
                txtFechaPrestamo.setText(p.getFechaPrestamo().toString());
                txtFechaDevolucion.setText(p.getFechaDevolucion().toString());
            } else {
                JOptionPane.showMessageDialog(this,"Préstamo no encontrado");
            }
        });

        // Selección tabla
        tabla.getSelectionModel().addListSelectionListener(e -> {
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                txtId.setText(modeloTabla.getValueAt(fila,0).toString());
                txtIdLibro.setText(modeloTabla.getValueAt(fila,1).toString());
                txtIdUsuario.setText(modeloTabla.getValueAt(fila,2).toString());
                txtFechaPrestamo.setText(modeloTabla.getValueAt(fila,3).toString());
                txtFechaDevolucion.setText(modeloTabla.getValueAt(fila,4).toString());
            }
        });
    }

    private void cargarTabla(){
        modeloTabla.setRowCount(0);
        List<Prestamo> lista = controller.obtenerPrestamos();
        for(Prestamo p : lista){
            modeloTabla.addRow(new Object[]{
                    p.getId(),
                    p.getIdLibro(),
                    p.getIdUsuario(),
                    p.getFechaPrestamo(),
                    p.getFechaDevolucion()
            });
        }
    }

    private void limpiarCampos(){
        txtId.setText("");
        txtIdLibro.setText("");
        txtIdUsuario.setText("");
        txtFechaPrestamo.setText("");
        txtFechaDevolucion.setText("");
    }
}