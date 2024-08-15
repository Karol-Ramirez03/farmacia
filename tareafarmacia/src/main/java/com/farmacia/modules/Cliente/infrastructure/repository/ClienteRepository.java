package com.farmacia.modules.Cliente.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.farmacia.database.database;
import com.farmacia.modules.Cliente.domain.Service.ClienteService;
import com.farmacia.modules.Cliente.domain.entity.Cliente;

public class ClienteRepository implements ClienteService {

    @Override
    public void createCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente(idcliente, nombrecliente, lastnombrecliente, codigociudadcliente, emailcliente, birthdate, lon, latitud) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNombreCliente());
            ps.setString(3, cliente.getLastNombreCliente());
            ps.setString(4, cliente.getCodigoCiudadCliente());
            ps.setString(5, cliente.getEmailCliente());
            ps.setDate(6, new Date(cliente.getBirthdate().getTime()));
            ps.setDouble(7, cliente.getLon());
            ps.setDouble(8, cliente.getLatitud());
            

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteCliente(String id) {
        String sql = "DELETE FROM cliente WHERE idcliente = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("codigo no encontrado");
        }
        
    }

    @Override
    public List<Cliente> findAllCliente() {
        String sql = "SELECT idcliente, nombrecliente, lastnombrecliente, codigociudadcliente, emailcliente, birthdate, lon, latitud FROM cliente";
        List<Cliente> Clientes = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                String idcliente = rs.getString("idcliente");
                String nombrecliente = rs.getString("nombrecliente");
                String lastnombrecliente = rs.getString("lastnombrecliente");
                String codigociudadcliente = rs.getString("codigociudadcliente");
                String emailcliente = rs.getString("emailcliente");
                Cliente Cliente = new Cliente(idcliente, nombrecliente ,lastnombrecliente,codigociudadcliente,emailcliente);
                Clientes.add(Cliente);         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Clientes;
    }

    @Override
    public Optional<Cliente> findById(String id) {
        String sql = "SELECT idcliente, nombrecliente, lastnombrecliente, codigociudadcliente, emailcliente, birthdate, lon, latitud FROM cliente WHERE idcliente = ?";
       
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idcliente = rs.getString("idcliente");
                String nombrecliente = rs.getString("nombrecliente");
                String lastnombrecliente = rs.getString("lastnombrecliente");
                String codigociudadcliente = rs.getString("codigociudadcliente");
                String emailcliente = rs.getString("emailcliente");
                Date birthdate = rs.getDate("birthdate");
                float lon = rs.getFloat("lon");
                float lat = rs.getFloat("latitud");


                Cliente cliente = new Cliente(idcliente, nombrecliente ,lastnombrecliente,codigociudadcliente,emailcliente,birthdate,lon,lat);;

                return Optional.of(cliente);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateCliente(Cliente cliente) {
        String query = "UPDATE cliente SET  nombrecliente = ? , lastnombrecliente = ?, codigociudadcliente = ?, emailcliente = ?, birthdate = ?, lon = ? , latitud = ? WHERE idcliente = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cliente.getNombreCliente());
            statement.setString(2, cliente.getLastNombreCliente());
            statement.setString(3, cliente.getCodigoCiudadCliente());
            statement.setString(4, cliente.getEmailCliente());
            statement.setDate(5, new Date(cliente.getBirthdate().getTime()));
            statement.setDouble(6, cliente.getLon());
            statement.setDouble(7, cliente.getLatitud());
            statement.setString(8, cliente.getIdCliente());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

}
