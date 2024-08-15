package com.farmacia.modules.Farmacia.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacia.database.database;
import com.farmacia.modules.Farmacia.domain.entity.Farmacia;
import com.farmacia.modules.Farmacia.domain.Service.FarmaciaService;

public class FarmaciaRepository implements FarmaciaService{

    @Override
    public void createFarmacia(Farmacia farmacia) {
        String sql = "INSERT INTO farmacia (nombrefarmacia, direccionfarmacia, longfarmacia, latfarmacia, codigociudadfarm, logofarmacia) VALUES (?,?,?,?,?,?)";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, farmacia.getNombreFarmacia());
            ps.setString(2, farmacia.getDireccionFarmacia());
            ps.setDouble(3, farmacia.getLongFarmacia());
            ps.setDouble(4, farmacia.getLatFarmacia());
            ps.setString(5, farmacia.getCodigoCiudadFarm());
            ps.setString(6, farmacia.getLogoFarmacia());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteFarmacia(int id) {
        String sql = "DELETE FROM farmacia WHERE idf = ?";
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
    public List<Farmacia> findAllFarmacia() {
        String sql = "SELECT idf, nombrefarmacia, direccionfarmacia, longfarmacia, latfarmacia, codigociudadfarm, logofarmacia FROM Farmacia";
        List<Farmacia> Farmacias = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                int idf = rs.getInt("idf");
                String nombreFarmacia = rs.getString("nombrefarmacia");
                String direccion = rs.getString("direccionfarmacia");
                float longi = rs.getFloat("longfarmacia");
                float lat = rs.getFloat("latfarmacia");
                String ciudad = rs.getString("codigociudadfarm");
                String logo = rs.getString("logofarmacia");
                Farmacia farmacia = new Farmacia(idf,nombreFarmacia, direccion ,longi,lat,ciudad,logo);
                Farmacias.add(farmacia);         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Farmacias;
    }

    @Override
    public Optional<Farmacia> findById(int id) {
        String sql = "SELECT nombrefarmacia, direccionfarmacia, longfarmacia, latfarmacia, codigociudadfarm, logofarmacia FROM farmacia WHERE idf = ?";
       
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idf = rs.getInt("idf");
                String nombreFarmacia = rs.getString("nombrefarmacia");
                String direccion = rs.getString("direccionfarmacia");
                float longi = rs.getFloat("longfarmacia");
                float lat = rs.getFloat("latfarmacia");
                String ciudad = rs.getString("codigociudadfarm");
                String logo = rs.getString("logofarmacia");
                Farmacia farmacia = new Farmacia(idf,nombreFarmacia, direccion ,longi,lat,ciudad,logo);
                return Optional.of(farmacia);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateFarmacia(Farmacia farmacia) {
        String query = "UPDATE Farmacia SET  nombrefarmacia = ?, direccionfarmacia = ? , longfarmacia = ?, latfarmacia = ?, codigociudadfarm = ?, logofarmacia = ? WHERE idf = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, farmacia.getNombreFarmacia());
                statement.setString(2, farmacia.getDireccionFarmacia());
                statement.setDouble(3, farmacia.getLongFarmacia());
                statement.setDouble(4, farmacia.getLatFarmacia());
                statement.setString(5, farmacia.getCodigoCiudadFarm());
                statement.setString(6, farmacia.getLogoFarmacia());
                statement.setInt(7, farmacia.getIdf());


            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la Farmacia: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

}
