package com.farmacia.modules.ModoAdministracion.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.validadores;
import com.farmacia.modules.ModoAdministracion.application.CreateModoAdministracionUseCase;
import com.farmacia.modules.ModoAdministracion.application.DeleteModoAdministracionUseCase;
import com.farmacia.modules.ModoAdministracion.application.FindAllModoAdministracionUseCase;
import com.farmacia.modules.ModoAdministracion.application.FindByIdModoAdministracionUseCase;
import com.farmacia.modules.ModoAdministracion.application.UpdateModoAdministracionUseCase;
import com.farmacia.modules.ModoAdministracion.domain.Service.ModoAdministracionService;
import com.farmacia.modules.ModoAdministracion.infrastructure.repository.ModoAdministracionRepository;
import com.farmacia.modules.ModoAdministracion.domain.entity.ModoAdministracion;

public class ConsoleAdapterModoAdministracion {
    private ModoAdministracionService modoAdministracionService;
    private CreateModoAdministracionUseCase createmodo;
    private DeleteModoAdministracionUseCase delmodo;
    private UpdateModoAdministracionUseCase updmodo;
    private FindAllModoAdministracionUseCase allmodo;
    private FindByIdModoAdministracionUseCase idmodo;

    public ConsoleAdapterModoAdministracion() {
        this.modoAdministracionService = new ModoAdministracionRepository();
        this.createmodo = new CreateModoAdministracionUseCase(modoAdministracionService);
        this.delmodo = new DeleteModoAdministracionUseCase(modoAdministracionService);
        this.updmodo = new UpdateModoAdministracionUseCase(modoAdministracionService);
        this.allmodo = new FindAllModoAdministracionUseCase(modoAdministracionService);
        this.idmodo = new FindByIdModoAdministracionUseCase(modoAdministracionService);
    }

    public void StartModoAdministracion(){
        boolean Bandera = true;
        Scanner scanner = new Scanner(System.in);
        String titulo = """
                
        █▀▄▀█ █▀▀ █▄░█ █░█   █░█ █ ▄▀█   █▀▄ █▀▀   ▄▀█ █▀▄ █▀▄▀█ █ █▄░█ █ █▀ ▀█▀ █▀█ ▄▀█ █▀▀ █ █▀█ █▄░█
        █░▀░█ ██▄ █░▀█ █▄█   ▀▄▀ █ █▀█   █▄▀ ██▄   █▀█ █▄▀ █░▀░█ █ █░▀█ █ ▄█ ░█░ █▀▄ █▀█ █▄▄ █ █▄█ █░▀█

                """;
        while (Bandera) {
            validadores.limpiarConsola();
            System.out.println(titulo);
            System.out.println("1. añadir modo de administracion \n2. eliminar modo de administracion \n3. actualizar modo de administracion \n4. buscar por id \n5. listar Unidades de Medidas\n6. salir");
            int opcion = validadores.rangeValidator(1, 6);

            switch (opcion) {
                case 1:
                    validadores.limpiarConsola();
                    try {
                        System.out.println("ingrese el nombre del modo de administracion: ");
                        String nombre = scanner.nextLine();
                        ModoAdministracion ModoAdministracion = new ModoAdministracion(nombre);
                        createmodo.execute(ModoAdministracion);
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELEVE A INTENTARLO");                
                        validadores.pausa();
                        StartModoAdministracion();
                    }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 2:
                    validadores.limpiarConsola();
                    try {
                        System.out.println("ingresa el codigo del modo de administracion");
                        int codigoDel = scanner.nextInt();
                        delmodo.execute(codigoDel);
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELEVE A INTENTARLO");                
                        validadores.pausa();
                        StartModoAdministracion();
                    }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();

                    break;
                case 3:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingresa el codigo del modo de administracion");
                        int codigoUPd = scanner.nextInt();
                        updmodo.execute(codigoUPd);
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELEVE A INTENTARLO");                
                        validadores.pausa();
                        StartModoAdministracion();
                    }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 4:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingresa el codigo del modo de administracion");
                        int codigoID = scanner.nextInt();

                        Optional<ModoAdministracion> td = idmodo.execute(codigoID);
                        if (td.isPresent()) {
                            ModoAdministracion ptd = td.get();
                            System.out.println("Id: " + ptd.getIdma() + " NOMBRE: " + ptd.getDescripcion());
                        } else {
                            System.out.println("modo de administracion no encontrado.");
                        }
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELEVE A INTENTARLO");                
                        validadores.pausa();
                        StartModoAdministracion();
                    }

                    
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 5:
                    validadores.limpiarConsola();
                    List<ModoAdministracion> ModoAdministracions = allmodo.execute();
                    for (ModoAdministracion ModoAdministracion2 : ModoAdministracions) {
                        System.out.println("ID: " + ModoAdministracion2.getIdma() + " Nombre: " + ModoAdministracion2.getDescripcion());
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
