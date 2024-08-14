package com.farmacia.modules.Region.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacia.database.database;
import com.farmacia.modules.Ciudad.domain.entity.Ciudad;
import com.farmacia.modules.Region.domain.Service.RegionService;
import com.farmacia.modules.Region.domain.entity.Region;

public class RegionRepository implements RegionService {

    @Override
    public void createRegion(Region region) {
        
        String sql = "INSERT INTO region(codigoreg,nombrereg,codigopais) VALUES (?,?,?)";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, region.getCodigoreg());
            ps.setString(2, region.getNombrereg());
            ps.setString(3, region.getCodigopais());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteRegion(String codigoReg) {
        String sql = "DELETE FROM region WHERE codigoreg = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, codigoReg);
            ps.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("codigo no encontrado");
        }
        
    }

    @Override
    public List<Region> findAllRegion() {
        String sql = "SELECT codigoreg,nombrereg,codigopais FROM region";
        List<Region> regiones = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                String cod = rs.getString("codigoreg");
                String name = rs.getString("nombrereg");
                String codpais = rs.getString("codigopais");
                Region region = new Region(cod, name,codpais);
                regiones.add(region);         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regiones;
    }

    @Override
    public Optional<Region> findById(String codigoReg) {
        String sql = "SELECT codigoreg,nombrereg,codigopais FROM region WHERE codigoreg = ?";
       
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, codigoReg);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cod = rs.getString("codigoreg");
                String name = rs.getString("nombrereg");
                String codpais = rs.getString("codigopais");
                Region reg = new Region(cod, name,codpais);

                return Optional.of(reg);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateRegion(Region region) {
        String query = "UPDATE region SET nombrereg = ?, codigopais = ? WHERE codigoreg = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(3, region.getCodigoreg());
            statement.setString(1, region.getNombrereg());
            statement.setString(2, region.getCodigopais());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la region: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

}
