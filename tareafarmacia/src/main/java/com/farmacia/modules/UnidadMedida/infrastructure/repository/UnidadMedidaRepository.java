package com.farmacia.modules.UnidadMedida.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.database.database;
import com.farmacia.modules.UnidadMedida.domain.Service.UnidadMedidaService;
import com.farmacia.modules.UnidadMedida.domain.entity.UnidadMedida;

public class UnidadMedidaRepository implements UnidadMedidaService {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void createUnidadMedida(UnidadMedida unidadMedida) {
        String sql = "INSERT INTO unidadmedida (nombre) VALUES (?)";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, unidadMedida.getNombre());
            ps.executeUpdate();
            System.out.println("unidad de medida registrada con exito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteUnidadMedida(int idum) {
        String sql = "DELETE FROM unidadmedida WHERE idum = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, idum);
            ps.executeUpdate();
            System.out.println("unidad de medida eliminada con exito!");
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("codigo no encontrado");
        }
        
    }

    @Override
    public List<UnidadMedida> findAllUnidadMedida() {
        String sql = "SELECT idum, nombre FROM unidadmedida";
        List<UnidadMedida> medidas = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idum");
                String name = rs.getString("nombre");
                UnidadMedida medida = new UnidadMedida(id, name);
                medidas.add(medida);         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medidas;
    }

    @Override
    public Optional<UnidadMedida> findById(int idum) {
        String sql = "SELECT idum, nombre FROM unidadmedida WHERE idum = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, idum);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idum");
                String name = rs.getString("nombre");
                UnidadMedida medida = new UnidadMedida(id, name);
                return Optional.of(medida);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateUnidadMedida(int idum) {
        String sql = "UPDATE unidadmedida SET nombre = ?  WHERE idum = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Ingrese el nombre de la unidadmedida: ");
            String nombre = scanner.nextLine();
            ps.setString(1, nombre);
            ps.setInt(2, idum);
            ps.executeUpdate();
            System.out.println("unidad de medida registrada con exito!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
