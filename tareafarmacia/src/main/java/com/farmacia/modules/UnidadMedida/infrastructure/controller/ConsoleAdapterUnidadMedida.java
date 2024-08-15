package com.farmacia.modules.UnidadMedida.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.modules.UnidadMedida.domain.entity.UnidadMedida;
import com.farmacia.validadores;
import com.farmacia.modules.UnidadMedida.application.CreateUnidadMedidadUseCase;
import com.farmacia.modules.UnidadMedida.application.DeleteUnidadMedidaUseCase;
import com.farmacia.modules.UnidadMedida.application.FindAllUnidadMedidaUseCase;
import com.farmacia.modules.UnidadMedida.application.FindByIdUnidadMedidaUseCase;
import com.farmacia.modules.UnidadMedida.application.UpdateUnidadMedidaUseCase;
import com.farmacia.modules.UnidadMedida.domain.Service.UnidadMedidaService;
import com.farmacia.modules.UnidadMedida.infrastructure.repository.UnidadMedidaRepository;

public class ConsoleAdapterUnidadMedida {

    private UnidadMedidaService unidadMedidadService;
    private CreateUnidadMedidadUseCase createUm;
    private DeleteUnidadMedidaUseCase delUm;
    private FindAllUnidadMedidaUseCase allUm;
    private UpdateUnidadMedidaUseCase updUm;
    private FindByIdUnidadMedidaUseCase idUm;

    
    
    public ConsoleAdapterUnidadMedida() {
        this.unidadMedidadService = new UnidadMedidaRepository();
        this.createUm = new CreateUnidadMedidadUseCase(unidadMedidadService);
        this.delUm = new DeleteUnidadMedidaUseCase(unidadMedidadService);
        this.allUm = new FindAllUnidadMedidaUseCase(unidadMedidadService);
        this.updUm = new UpdateUnidadMedidaUseCase(unidadMedidadService);
        this.idUm = new FindByIdUnidadMedidaUseCase(unidadMedidadService);
    }



    public void StartUnidadMedida(){
        boolean Bandera = true;
        Scanner scanner = new Scanner(System.in);
        String titulo = """
        
        █▀▄▀█ █▀▀ █▄░█ █░█   █░█ █▄░█ █ █▀▄ ▄▀█ █▀▄   █▀▄▀█ █▀▀ █▀▄ █ █▀▄ ▄▀█
        █░▀░█ ██▄ █░▀█ █▄█   █▄█ █░▀█ █ █▄▀ █▀█ █▄▀   █░▀░█ ██▄ █▄▀ █ █▄▀ █▀█        

                """;
        while (Bandera) {
            validadores.limpiarConsola();
            System.out.println(titulo);
            System.out.println("1. añadir Unidad de Medida \n2. eliminar Unidad de Medida \n3. actualizar Unidad de Medida \n4. buscar por id \n5. listar Unidades de Medidas\n6. salir");
            int opcion = validadores.rangeValidator(1, 6);

            switch (opcion) {
                case 1:
                    validadores.limpiarConsola();
                    System.out.println("ingrese el nombre de la Unidad de Medida: ");
                    String nombre = scanner.nextLine();
                    
                    UnidadMedida UnidadMedida = new UnidadMedida(nombre);
                    createUm.execute(UnidadMedida);
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 2:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingresa el codigo de la Unidad de Medida");
                        int codigoDel = scanner.nextInt();
                        delUm.execute(codigoDel);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                        validadores.pausa();
                        StartUnidadMedida();
                    }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();

                    break;
                case 3:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingresa el codigo de la Unidad de Medida");
                        int codigoUPd = scanner.nextInt();
                        updUm.execute(codigoUPd);
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                        validadores.pausa();
                        StartUnidadMedida();
                    }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 4:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingresa el codigo de la Unidad de Medida");
                        int codigoID = scanner.nextInt();
    
                        Optional<UnidadMedida> td = idUm.execute(codigoID);
                        
                        if (td.isPresent()) {
                            UnidadMedida ptd = td.get();
                            System.out.println("Id: " + ptd.getIdum() + " NOMBRE: " + ptd.getNombre());
                        } else {
                            System.out.println("Unidad de Medida no encontrado.");
                        }
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                        validadores.pausa();
                        StartUnidadMedida();
                    }
                   
                    validadores.pausa();
                    validadores.limpiarConsola();
                    break;
                case 5:
                    validadores.limpiarConsola();
                    List<UnidadMedida> UnidadMedidas = allUm.execute(); 
                    for (UnidadMedida UnidadMedida2 : UnidadMedidas) {
                        System.out.println("ID: " + UnidadMedida2.getIdum() + " Nombre: " + UnidadMedida2.getNombre());
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
