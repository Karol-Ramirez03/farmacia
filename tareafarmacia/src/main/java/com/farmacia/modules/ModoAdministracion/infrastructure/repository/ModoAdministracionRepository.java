package com.farmacia.modules.ModoAdministracion.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.database.database;
import com.farmacia.modules.ModoAdministracion.domain.Service.ModoAdministracionService;
import com.farmacia.modules.ModoAdministracion.domain.entity.ModoAdministracion;



public class ModoAdministracionRepository implements ModoAdministracionService{
    Scanner scanner = new Scanner(System.in);

    @Override
    public void deleteModoAdministracion(int idma) {
        String sql = "DELETE FROM modo_administracion WHERE idma = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, idma);
            ps.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("codigo no encontrado");
        }
    }

    @Override
    public void updateModoAdministracion(int idma) {
        String sql = "UPDATE modo_administracion SET descripcion = ?  WHERE idma = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Ingrese el nombre del modo de administracion: ");
            String nombre = scanner.nextLine();
            ps.setString(1, nombre);
            ps.setInt(2, idma);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createModoAdministracion(ModoAdministracion ModoAdministracion) {
        String sql = "INSERT INTO modo_administracion(descripcion) VALUES (?)";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, ModoAdministracion.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ModoAdministracion> findById(int idma) {
        String sql = "SELECT idma, descripcion FROM modo_administracion WHERE idma = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, idma);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idma");
                String name = rs.getString("descripcion");
                ModoAdministracion modoAdministracion = new ModoAdministracion(id, name);
                return Optional.of(modoAdministracion);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<ModoAdministracion> findAllModoAdministracion() {
        String sql = "SELECT idma, descripcion FROM modo_administracion";
        List<ModoAdministracion> modos = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idma");
                String name = rs.getString("descripcion");
                ModoAdministracion admin = new ModoAdministracion(id, name);
                modos.add(admin);         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modos;
    }

}
