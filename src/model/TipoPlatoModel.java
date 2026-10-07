package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.TipoPlato;
import util.MySqlDBConexion;

public class TipoPlatoModel {
	public List<TipoPlato> listarTipoPlato() {
		List<TipoPlato> lista = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			// 1. Crear conexion
			conn = MySqlDBConexion.getConexion();

			// 2. Crear sentencia SQL
			String sql = "SELECT * FROM tipoplato";
			pstm = conn.prepareStatement(sql);
			System.out.println("SQL: " + pstm.toString());

			// 3. Ejecutar sentencia SQL
			rs = pstm.executeQuery();

			while (rs.next()) {
				TipoPlato tipoPlato = new TipoPlato();
				tipoPlato.setIdTipoPlato(rs.getInt("idTipoPlato"));
				tipoPlato.setDescripcion(rs.getString("descripcion"));
				lista.add(tipoPlato);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)		rs.close();
				if (pstm != null)	pstm.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

}
