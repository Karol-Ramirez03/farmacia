package com.farmacia.modules.Cliente.infrastructure.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


import com.farmacia.validadores;
import com.farmacia.modules.Cliente.application.CreateClienteUseCase;
import com.farmacia.modules.Cliente.application.DeleteClienteUseCase;
import com.farmacia.modules.Cliente.application.FindAllClienteUseCase;
import com.farmacia.modules.Cliente.application.FindByIdClienteUseCase;
import com.farmacia.modules.Cliente.application.UpdateClienteUseCase;
import com.farmacia.modules.Cliente.domain.Service.ClienteService;
import com.farmacia.modules.Cliente.infrastructure.repository.ClienteRepository;
import com.farmacia.modules.Cliente.domain.entity.Cliente;

public class ConsoleAdapterCliente {
    private ClienteService clienteService;
    private CreateClienteUseCase createCliente;
    private DeleteClienteUseCase delCliente;
    private UpdateClienteUseCase updCliente;
    private FindAllClienteUseCase allCliente;
    private FindByIdClienteUseCase idCliente;

    public ConsoleAdapterCliente() {
        this.clienteService = new ClienteRepository();
        this.createCliente = new CreateClienteUseCase(clienteService);
        this.delCliente = new DeleteClienteUseCase(clienteService);
        this.updCliente = new UpdateClienteUseCase(clienteService);
        this.allCliente = new FindAllClienteUseCase(clienteService);
        this.idCliente = new FindByIdClienteUseCase(clienteService);
    }

    public void StartCliente(){
        boolean Bandera = true;
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        validadores.limpiarConsola();
        String titulo = """
                
            █▀▄▀█ █▀▀ █▄░█ █░█   █▀▀ █░░ █ █▀▀ █▄░█ ▀█▀ █▀▀ █▀
            █░▀░█ ██▄ █░▀█ █▄█   █▄▄ █▄▄ █ ██▄ █░▀█ ░█░ ██▄ ▄█
                """;
        
        while (Bandera) {
            validadores.limpiarConsola();
            System.out.println(titulo);
            System.out.println("1. añadir Cliente \n2. eliminar Cliente \n3. actualizar Cliente \n4. buscar por id \n5. listar Cliente\n6. salir");
            int opcion = validadores.rangeValidator(1, 6);

            switch (opcion) {
                case 1:

                    try {
                        validadores.limpiarConsola();
                    System.out.println("ingrese el nombre de la Cliente: ");
                    String nombrecliente = scanner.nextLine();
                    System.out.println("ingresa el id de la Cliente");
                    String idcliente = scanner.nextLine();
                    System.out.println("ingresa el apellido del cliente");
                    String lastnombrecliente = scanner.nextLine();
                    System.out.println("ingresa el codigo de ciudad del  cliente");
                    String codigociudadcliente = scanner.nextLine();
                    System.out.println("ingresa el email  del cliente");
                    String emailcliente = scanner.nextLine();
                    System.out.println("ingresa el fecha de nacimiento del cliente, en formato dd/MM/yyyy");
                    String birthdate = scanner.nextLine();
                    Date nacimiento = null;

                    try {
                        nacimiento = dateFormat.parse(birthdate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
                    }

                    System.out.println("ingresa la longitud");
                    float lon = scanner.nextFloat();
                    System.out.println("ingresa la latitud");
                    float latitud = scanner.nextFloat();

                    Cliente cliente = new Cliente(idcliente, nombrecliente, lastnombrecliente, codigociudadcliente, emailcliente, nacimiento, lon, latitud);
                    createCliente.execute(cliente);

                    System.out.println("");
                    System.out.println("cliente creado con exito!");
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                        validadores.pausa();
                        StartCliente();
                    }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 2:
                try {
                    validadores.limpiarConsola();
                    System.out.println("ingresa el id del Cliente");
                    String codigoDel = scanner.nextLine();
                    delCliente.execute(codigoDel);
                    System.out.println("");
                    System.out.println("cliente eliminado con exito");
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("");
                    System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                    validadores.pausa();
                    StartCliente();
                }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();

                    break;

                case 3:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingresa el id del Cliente");
                        String codigoUPd = scanner.nextLine();

                        Optional<Cliente> ClienteExistente = idCliente.execute(codigoUPd);
                        if (!ClienteExistente.isPresent()) {
                            System.out.println("Cliente no encontrado.");
                            break;
                        }
                        Cliente ClienteActual = ClienteExistente.get();
                        boolean actualizar = true;

                        while (actualizar) {
                            validadores.limpiarConsola();
                            System.out.println("Seleccione el campo a actualizar:");
                            System.out.println("1. Nombre");
                            System.out.println("2. apellido");
                            System.out.println("3. codigo ciudad");
                            System.out.println("4. email");
                            System.out.println("5. fecha nacimiento");
                            System.out.println("6. longitud ");
                            System.out.println("7. latitud ");
                            System.out.println("8. Terminar Actualizacion ");



                            int campo = validadores.rangeValidator(1, 8);

                            switch (campo) {
                                case 1:
                                    System.out.print("Ingrese el nuevo nombre: ");
                                    ClienteActual.setNombreCliente(scanner.nextLine());
                                    
                                    break;
                                case 2:
                                    System.out.print("Ingrese el nuevo apellido: ");
                                    ClienteActual.setLastNombreCliente(scanner.nextLine());
                                    break;
                                case 3:
                                    System.out.print("Ingrese el nuevo codigo de ciudad: ");
                                    ClienteActual.setCodigoCiudadCliente(scanner.nextLine());
                                    break;
                                case 4:
                                    System.out.print("Ingrese el nuevo email: ");
                                    ClienteActual.setEmailCliente(scanner.nextLine());
                                    break;
                                case 5:
                                    System.out.print("Ingrese la fecha de nacimiento correctamente: ");
                                    String fechabirt = scanner.nextLine();
                                    Date nacio = null;
                                        
                                    try {
                                        nacio = dateFormat.parse(fechabirt);
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                        System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
                                    }
                                    
                                    ClienteActual.setBirthdate(nacio);
                                    break;
                                case 6:
                                    System.out.print("Ingrese la longitud: ");
                                    ClienteActual.setLon(scanner.nextFloat());
                                    break;
                                case 7:
                                    System.out.print("Ingrese la latitud ");
                                    ClienteActual.setLatitud(scanner.nextFloat());
                                    break;
                                case 8:
                                    actualizar = false;
                                    break;
                                default:
                                    System.out.println("Opción inválida, intente de nuevo.");
                            }
                        }
                        updCliente.execute(ClienteActual);
                        System.out.println("");
                        System.out.println("cliente actualizado con exito!");
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                        validadores.pausa();
                        StartCliente();
                    }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 4:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingresa el codigo de la Cliente");
                        String codigoID = scanner.nextLine();

                        Optional<Cliente> td = idCliente.execute(codigoID);
                        
                        if (td.isPresent()) {
                            Cliente ptd = td.get();
                            System.out.println("");
                            System.out.println("Id: " + ptd.getIdCliente() + " NOMBRE: " + ptd.getNombreCliente() + " APELLIDOS: " + ptd.getLastNombreCliente() + " EMAIL: " + ptd.getEmailCliente()+" CODIGO CIUDAD" + ptd.getCodigoCiudadCliente());
                            System.out.println("");
                        } else {
                            System.out.println("Cliente no encontrado.");
                        }
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                        validadores.pausa();
                        StartCliente();
                    }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 5:
                    validadores.limpiarConsola();
                    List<Cliente> Clientes = allCliente.execute();
                    for (Cliente Cliente2 : Clientes) {
                        System.out.println("Id: " + Cliente2.getIdCliente() + " NOMBRE: " + Cliente2.getNombreCliente() + " APELLIDOS: " + Cliente2.getLastNombreCliente() + " EMAIL: " + Cliente2.getEmailCliente()+" CODIGO CIUDAD" + Cliente2.getCodigoCiudadCliente());
                        System.out.println("--------------------");
                    }
                    validadores.pausa();
                    validadores.limpiarConsola();
                    break;
                case 6:
                    return;
                default:
                    break;
            }
            
        }
        scanner.close();

    }
    

}
