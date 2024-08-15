package com.farmacia.modules.PrincipioActivo.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.database.database;
import com.farmacia.modules.PrincipioActivo.domain.Service.PrincipioActivoService;
import com.farmacia.modules.PrincipioActivo.domain.entity.PrincipioActivo;


public class PrincipioActivoRepository implements PrincipioActivoService {
    Scanner scanner = new Scanner(System.in);
    
    
    
    @Override
    public void createPrincipioActivo(PrincipioActivo principioActivo) {
       String sql = "INSERT INTO principio_activo (nombre) VALUES (?)";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, principioActivo.getNombre());
            ps.executeUpdate();
            System.out.println("principio activo creado con exito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePrincipioActivo(int idpa) {
        String sql = "DELETE FROM principio_activo WHERE idpa = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, idpa);
            ps.executeUpdate();
            System.out.println("principio activo eliminado con exito!");
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("codigo no encontrado");
        }
    }

    @Override
    public List<PrincipioActivo> findAllPrincipioActivo() {
        String sql = "SELECT idpa, nombre FROM principio_activo";
        List<PrincipioActivo> unidad = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idpa");
                String name = rs.getString("nombre");
                PrincipioActivo activos = new PrincipioActivo(id, name);
                unidad.add(activos);         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unidad;
    }

    @Override
    public Optional<PrincipioActivo> findById(int idpa) {
        String sql = "SELECT idpa, nombre FROM principio_activo WHERE idpa = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, idpa);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idpa");
                String name = rs.getString("nombre");
                PrincipioActivo principioActivo = new PrincipioActivo(id, name);
                return Optional.of(principioActivo);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updatePrincipioActivo(int idpa) {
        String sql = "UPDATE principio_activo SET nombre = ?  WHERE idpa = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Ingrese el nombre del principio activo: ");
            String nombre = scanner.nextLine();
            ps.setString(1, nombre);
            ps.setInt(2, idpa);
            ps.executeUpdate();
            System.out.println("principio activo actualizado con exito!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
