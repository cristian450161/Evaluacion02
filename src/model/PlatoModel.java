package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import entity.Plato;

public class PlatoModel {
	public int insertaPlato(Plato plato) {
		int insertados = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1. Crear conexion
			conn = util.MySqlDBConexion.getConexion();

			// 2. Crear sentencia SQL
			String sql = "INSERT INTO plato( nombre, descripcion, precio, categoria, stock, fechaRegistro, estado, idtipoplato) VALUES(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, plato.getNombre());
			ps.setString(2, plato.getDescripcion());
			ps.setDouble(3, plato.getPrecio());
			ps.setString(4, plato.getCategoria());
			ps.setInt(5, plato.getStock());
			ps.setDate(6, java.sql.Date.valueOf(plato.getFechaRegistro()));
			ps.setString(7, plato.getEstado());
			ps.setInt(8, plato.getTipoPlato().getIdTipoPlato());
			

			System.out.println("SQL: " + ps.toString());
			
			// 3. Ejecutar sentencia SQL
			insertados = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		 }
		return insertados;
	}

}
