package com.farmacia.modules.Ciudad.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacia.database.database;
import com.farmacia.modules.Ciudad.domain.Service.CiudadService;
import com.farmacia.modules.Ciudad.domain.entity.Ciudad;

public class CiudadRepository implements CiudadService{

    @Override
    public void createCiudad(Ciudad ciudad) {
        String sql = "INSERT INTO ciudad(codigociudad,nombreciudad,codigoreg) VALUES (?,?,?)";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, ciudad.getCodigociudad());
            ps.setString(2, ciudad.getNombreciudad());
            ps.setString(3, ciudad.getCodigoreg());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteCiudad(String codigociudad) {
        String sql = "DELETE FROM ciudad WHERE codigociudad = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, codigociudad);
            ps.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("codigo no encontrado");
        }
        
    }

    @Override
    public List<Ciudad> findAllCiudad() {
        String sql = "SELECT codigociudad,nombreciudad,codigoreg FROM ciudad";
        List<Ciudad> ciudades = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                String cod = rs.getString("codigociudad");
                String name = rs.getString("nombreciudad");
                String codreg = rs.getString("codigoreg");
                Ciudad city = new Ciudad(cod, name,codreg);
                ciudades.add(city);         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ciudades;
    }

    @Override
    public Optional<Ciudad> findById(String codciudad) {
        String sql = "SELECT codigociudad, nombreciudad, codigoreg FROM ciudad WHERE codigociudad = ?";
       
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, codciudad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cod = rs.getString("codigociudad");
                String name = rs.getString("nombreciudad");
                String codreg = rs.getString("codigoreg");
                Ciudad city = new Ciudad(cod, name,codreg);

                return Optional.of(city);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateCiudad(Ciudad ciudad) {
        String query = "UPDATE ciudad SET nombreciudad = ?, codigoreg = ? WHERE codigociudad = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ciudad.getNombreciudad());
            statement.setString(2, ciudad.getCodigoreg());
            statement.setString(3, ciudad.getCodigociudad());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el pais: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

}
