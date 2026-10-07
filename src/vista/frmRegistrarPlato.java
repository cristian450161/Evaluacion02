package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.TipoPlato;
import entity.Plato;

import model.PlatoModel;
import model.TipoPlatoModel;
import util.ValidateUtil;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class frmRegistrarPlato extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtCategoria;
	private JTextField txtStock;
	private JTextField txtFecha;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtEstado;
	private JButton btnProcesar;
	private JComboBox cboTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistrarPlato frame = new frmRegistrarPlato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmRegistrarPlato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(42, 34, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setBounds(42, 64, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(42, 89, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Categoria");
		lblNewLabel_3.setBounds(42, 120, 68, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Stock");
		lblNewLabel_4.setBounds(42, 146, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Fecha Registro");
		lblNewLabel_5.setBounds(42, 177, 88, 14);
		contentPane.add(lblNewLabel_5);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(140, 31, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(140, 61, 86, 20);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(140, 86, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(140, 117, 86, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(140, 143, 86, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(140, 174, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Estado");
		lblNewLabel_6.setBounds(42, 206, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Tipo Plato");
		lblNewLabel_7.setBounds(42, 238, 68, 14);
		contentPane.add(lblNewLabel_7);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(140, 203, 86, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		btnProcesar = new JButton("GUARDAR");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(41, 268, 89, 23);
		contentPane.add(btnProcesar);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(140, 234, 176, 22);
		contentPane.add(cboTipo);
		cargarComboTipo();

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//1 Capturar los datos del formulario en variables locales de tipo String
		String nombre = txtNombre.getText().trim();
		String descripcion = txtDescripcion.getText().trim();
		String preciostr = txtPrecio.getText().trim();
		String categoria = txtCategoria.getText().trim();
		String stockstr=txtStock.getText().trim();
		String fechaIngreso = txtFecha.getText().trim();
		String tipo = cboTipo.getSelectedItem().toString();
		
		// 3. Validar los datos capturados
		if (nombre.isEmpty() || !nombre.matches(ValidateUtil.NOMBRE)) {
		    JOptionPane.showMessageDialog(null, "El nombre no es válido (solo letras y números).");
		} else if (descripcion.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "La descripción no puede estar vacía.");
		} else if (!preciostr.matches(ValidateUtil.PRECIO)) {
		    JOptionPane.showMessageDialog(null, "El precio debe ser un número válido (ej: 15.50).");
		} else if (categoria.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Debe ingresar una categoría.");
		} else if (!stockstr.matches(ValidateUtil.STOCK)) {
		    JOptionPane.showMessageDialog(null, "El stock debe ser un número entero positivo.");
		} else if (!fechaIngreso.matches(ValidateUtil.FECHA)) {
		    JOptionPane.showMessageDialog(null, "La fecha debe tener el formato YYYY-MM-DD.");
		} else if (tipo.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo.");
		} else {
			try {
		        // Parsear números con los valores validados del formulario
		        double precio = Double.parseDouble(preciostr);
		        int stock = Integer.parseInt(stockstr);

		        // Crear objeto TipoPlato
		        TipoPlato objTipoPlato = new TipoPlato();
		        objTipoPlato.setIdTipoPlato(Integer.parseInt(tipo.split(" - ")[0].trim()));
		        
		        // Crear objeto Plato con los datos reales
		        Plato objPlato = new Plato();
		        objPlato.setNombre(nombre);
		        objPlato.setDescripcion(descripcion);    
		        objPlato.setPrecio(precio);           // Guarda el precio real
		        objPlato.setCategoria(categoria);
		        objPlato.setStock(stock);             // Guarda el stock real
		        objPlato.setFechaRegistro(LocalDate.parse(fechaIngreso));
		        objPlato.setTipoPlato(objTipoPlato);
		        
		        
		        
		        // Registrar en la Base de Datos
		        PlatoModel objPlatoModel = new PlatoModel();
		        int insertados = objPlatoModel.insertaPlato(objPlato);
		        
		        // Mensaje de confirmación
		        if (insertados > 0) {
		            JOptionPane.showMessageDialog(this, "Plato registrado correctamente");
		        } else {
		            JOptionPane.showMessageDialog(this, "No se pudo registrar el plato en la base de datos.");
		        }

		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(this, "Error al procesar o guardar los datos: " + ex.getMessage());
		    }
		    
		}
		// 2. Declarar las variables numéricas fuera del alcance de la validación
		double precio = 0.0;
		int stock = 0;
		//2 Validar que los datos no esten vacios	
		
	}
	
	public void cargarComboTipo() {
		TipoPlatoModel model = new TipoPlatoModel();
		List<TipoPlato> tipos = model.listarTipoPlato();
		cboTipo.addItem("[ Seleccione un tipo] ");
		for (TipoPlato tipo : tipos) {
			 cboTipo.addItem(tipo.getIdTipoPlato() + " - " + tipo.getDescripcion());
		}
		
	}
}

