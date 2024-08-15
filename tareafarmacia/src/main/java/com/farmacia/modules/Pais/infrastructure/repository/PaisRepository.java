package com.farmacia.modules.Pais.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.database.database;
import com.farmacia.modules.Pais.domain.entity.Pais;
import com.farmacia.modules.Pais.domain.service.PaisService;

public class PaisRepository implements PaisService {
     Scanner scanner = new Scanner(System.in);

    @Override
    public void createPais(Pais pais) {
        String sql = "INSERT INTO pais(codigopais,nombre) VALUES (?,?)";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, pais.getCodigopais());
            ps.setString(2, pais.getNombre());
            ps.executeUpdate();
            System.out.println("pais creado con exito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deletepais(String codigo) {
        String sql = "DELETE FROM pais WHERE codigopais = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, codigo);
            ps.executeUpdate();
            System.out.println("pais eliminado con exito!");
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("codigo no encontrado");
        }
    }

    @Override
    public List<Pais> findAllPais() {
        String sql = "SELECT codigopais, nombre FROM pais";
        List<Pais> paises = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                String cod = rs.getString("codigopais");
                String name = rs.getString("nombre");
                Pais pais = new Pais(name, cod);
                paises.add(pais);         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paises;
    }

    @Override
    public Optional<Pais> findById(String codigo) {
        String sql = "SELECT codigopais, nombre FROM pais WHERE codigopais = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cod = rs.getString("codigopais"); 
                String name = rs.getString("nombre"); 
                Pais pais = new Pais(name, cod);
                return Optional.of(pais);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updatePais(String codigo) {
        String sql = "UPDATE pais SET nombre = ?  WHERE codigopais = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Ingrese el nombre del pais: ");
            String nombre = scanner.nextLine();
            ps.setString(1, nombre);
            ps.setString(2, codigo);
            ps.executeUpdate();
            System.out.println("pais actualizado con exito!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
