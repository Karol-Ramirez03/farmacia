package com.farmacia.modules.Medicina.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacia.database.database;
import com.farmacia.modules.Medicina.domain.Service.MedicinaService;
import com.farmacia.modules.Medicina.domain.entity.Medicina;

public class MedicinaRepository implements MedicinaService{

    @Override
    public void CreateMedicina(Medicina medicina) {
        String sql = "INSERT INTO medicina(proceedings, nombre, registro_medico, descripcion, descripcion_corto, nombre_rol, codigomodoadmin, codigoprincactivo, codigounidadmedida, codigolab) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, medicina.getProceedings());
            ps.setString(2, medicina.getNombre());
            ps.setString(3, medicina.getRegistroMedico());
            ps.setString(4, medicina.getDescripcion());
            ps.setString(5, medicina.getDescripcionCorto());
            ps.setString(6, medicina.getNombreRol());
            ps.setInt(7, medicina.getCodigoModoAdmin());
            ps.setInt(8,medicina.getCodigoPrincActivo());
            ps.setInt(9, medicina.getCodigoUnidadMedida());
            ps.setInt(10, medicina.getCodigoLab());

            ps.executeUpdate();


            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void DeleteMedicina(int id) {
        String sql = "DELETE FROM medicina WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
           e.printStackTrace();
        }
        
    }

    @Override
    public List<Medicina> FindAllMedicina() {
        String sql = "SELECT proceedings, nombre, registro_medico, descripcion, descripcion_corto, nombre_rol, codigomodoadmin, codigoprincactivo, codigounidadmedida, codigolab FROM medicina";
        List<Medicina> medicinas = new ArrayList<>();

        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String proceedings = rs.getString("proceedings");
                String nombre = rs.getString("nombre");
                String registro_medico = rs.getString("registro_medico");
                String descripcion = rs.getString("descripcion");
                String descripcion_corto = rs.getString("descripcion_corto");
                String nombre_rol = rs.getString("nombre_rol");
                int  codigomodoadmin = rs.getInt("codigomodoadmin");
                int codigoprincactivo = rs.getInt("codigoprincactivo");
                int codigounidadmedida = rs.getInt("codigounidadmedida");
                int codigolab = rs.getInt("codigolab");

                Medicina allmedicina = new Medicina(proceedings, nombre, registro_medico, descripcion, descripcion_corto, nombre_rol, codigomodoadmin, codigoprincactivo, codigounidadmedida, codigolab);
                medicinas.add(allmedicina);  
            }    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicinas;
    }

    @Override
    public Optional<Medicina> FindByIdMedicina(int id) {
        String sql = "SELECT proceedings, nombre, registro_medico, descripcion, descripcion_corto, nombre_rol, codigomodoadmin, codigoprincactivo, codigounidadmedida, codigolab FROM medicina WHERE id = ?";


        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()) {
                int idb = id; 
                String proceedings = rs.getString("proceedings");
                String nombre = rs.getString("nombre");
                String registro_medico = rs.getString("registro_medico");
                String descripcion = rs.getString("descripcion");
                String descripcion_corto = rs.getString("descripcion_corto");
                String nombre_rol = rs.getString("nombre_rol");
                int  codigomodoadmin = rs.getInt("codigomodoadmin");
                int codigoprincactivo = rs.getInt("codigoprincactivo");
                int codigounidadmedida = rs.getInt("codigounidadmedida");
                int codigolab = rs.getInt("codigolab");

                Medicina idmedicina = new Medicina(idb,proceedings, nombre, registro_medico, descripcion, descripcion_corto, nombre_rol, codigomodoadmin, codigoprincactivo, codigounidadmedida, codigolab);
                return Optional.of(idmedicina);
        
            }  

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    @Override
    public void UpdateMedicina(Medicina medicina) {
        String sql = "UPDATE medicina SET proceedings = ?, nombre = ? , registro_medico = ?, descripcion = ?, descripcion_corto = ?, nombre_rol = ? , codigomodoadmin = ?, codigoprincactivo = ?, codigounidadmedida = ?, codigolab = ? WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, medicina.getProceedings());
            ps.setString(2, medicina.getNombre());
            ps.setString(3, medicina.getRegistroMedico());
            ps.setString(4, medicina.getDescripcion());
            ps.setString(5, medicina.getDescripcionCorto());
            ps.setString(6, medicina.getNombreRol());
            ps.setInt(7, medicina.getCodigoModoAdmin());
            ps.setInt(8,medicina.getCodigoPrincActivo());
            ps.setInt(9, medicina.getCodigoUnidadMedida());
            ps.setInt(10, medicina.getCodigoLab());

            ps.setInt(11, medicina.getId());
            
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
