package com.farmacia.modules.FarmaciaMedicina.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacia.database.database;
import com.farmacia.modules.FarmaciaMedicina.domain.Service.FarmaciaMedicinaService;
import com.farmacia.modules.FarmaciaMedicina.domain.entity.FarmaciaMedicina;

public class FarmaciaMedicinaRepository implements FarmaciaMedicinaService{

    @Override
    public void createFarmaciaMedicina(FarmaciaMedicina FarmaciaMedicina) {
        String sql = "INSERT INTO farmaciamedicina (idfarmacia, idmedicinafarm, precio) VALUES (?,?,?)";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, FarmaciaMedicina.getIdFarmacia());
            ps.setInt(2, FarmaciaMedicina.getIdMedicinaFarm());
            ps.setFloat(3, FarmaciaMedicina.getPrecio());

            ps.executeUpdate();
            System.out.println("Asignacion creada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFarmaciaMedicina(int idfarmacia, int idmedicina) {
        String sql = "DELETE FROM farmaciamedicina WHERE idfarmacia = ? AND idmedicinafarm = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, idfarmacia);
            ps.setInt(2, idmedicina);
            ps.executeUpdate();
            System.out.println("Asignacion eliminada con exito!");
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("codigo no encontrado");
        }
        
    }

    @Override
    public List<FarmaciaMedicina> findAllFarmaciaMedicina() {
        String sql = "SELECT idfarmacia, idmedicinafarm, precio FROM farmaciamedicina";
        List<FarmaciaMedicina> FarmaciaMedicinas = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                int idf = rs.getInt("idfarmacia");
                int idm = rs.getInt("idmedicinafarm");
                float precio = rs.getFloat("precio");
                FarmaciaMedicina FarmaciaMedicina = new FarmaciaMedicina(idf,idm, precio);
                FarmaciaMedicinas.add(FarmaciaMedicina);         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FarmaciaMedicinas;
    }

    @Override
    public Optional<FarmaciaMedicina> findById(int idfarmacia, int idmedicina) {
        String sql = "SELECT idfarmacia, idmedicinafarm, precio FROM FarmaciaMedicina WHERE idfarmacia = ? AND idmedicinafarm = ?";
       
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, idfarmacia);
            ps.setInt(2, idmedicina);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idf = rs.getInt("idfarmacia");
                int idm = rs.getInt("idmedicinafarm");
                float precio = rs.getFloat("precio");
                FarmaciaMedicina FarmaciaMedicina = new FarmaciaMedicina(idf,idm, precio);
                return Optional.of(FarmaciaMedicina);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateFarmaciaMedicina(FarmaciaMedicina FarmaciaMedicina) {
        String query = "UPDATE FarmaciaMedicina SET  precio = ? WHERE idfarmacia = ? AND idmedicinafarm = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(2, FarmaciaMedicina.getIdFarmacia());
                ps.setInt(3, FarmaciaMedicina.getIdMedicinaFarm());
                ps.setFloat(1, FarmaciaMedicina.getPrecio());
                ps.executeUpdate();
                System.out.println("actualizacion realizada con exito!");
        } catch (SQLException e) {
            System.out.println("Error al actualizar la FarmaciaMedicina: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

}
