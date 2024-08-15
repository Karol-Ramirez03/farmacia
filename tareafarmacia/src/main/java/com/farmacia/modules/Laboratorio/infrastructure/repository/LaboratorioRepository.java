package com.farmacia.modules.Laboratorio.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacia.database.database;
import com.farmacia.modules.Laboratorio.domain.Service.LaboratorioService;
import com.farmacia.modules.Laboratorio.domain.entity.Laboratorio;

public class LaboratorioRepository implements LaboratorioService{

    @Override
    public void createLaboratorio(Laboratorio laboratorio) {
        String sql = "INSERT INTO laboratorio(nombrelab, codigociudad) VALUES (?,?)";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, laboratorio.getNombreLab());
            ps.setString(2, laboratorio.getCodigoCiudad());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteLaboratorio(int id) {
        String sql = "DELETE FROM laboratorio WHERE codigolab = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("codigo no encontrado");
        }
    }

    @Override
    public List<Laboratorio> findAllLaboratorio() {
        String sql = "SELECT codigolab, nombrelab, codigociudad FROM laboratorio";
        List<Laboratorio> Laboratorios = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                int idf = rs.getInt("codigolab");
                String nombreLaboratorio = rs.getString("nombrelab");
                String codciudad = rs.getString("codigociudad");
                Laboratorio laboratorio = new Laboratorio(idf,nombreLaboratorio, codciudad);
                Laboratorios.add(laboratorio);         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Laboratorios;
    }

    @Override
    public Optional<Laboratorio> findById(int id) {
        String sql = "SELECT codigolab, nombrelab, codigociudad FROM laboratorio WHERE codigolab = ?";
       
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idlab = rs.getInt("codigolab");
                String nombrelab = rs.getString("nombrelab");
                String codciudad = rs.getString("codigociudad");

                Laboratorio lab = new Laboratorio(idlab,nombrelab, codciudad);
                return Optional.of(lab);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateLaboratorio(Laboratorio laboratorio) {
        String query = "UPDATE laboratorio SET   nombrelab = ?, codigociudad = ? WHERE codigolab = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, laboratorio.getNombreLab());
                statement.setString(2, laboratorio.getCodigoCiudad());
                statement.setInt(3, laboratorio.getCodigoLab());


            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la laboratorio: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

}
