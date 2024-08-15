package com.farmacia.modules.PrincipioActivo.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.validadores;
import com.farmacia.modules.PrincipioActivo.application.CreatePrincipioActivoUseCase;
import com.farmacia.modules.PrincipioActivo.application.DeletePrincipioActivoUseCase;
import com.farmacia.modules.PrincipioActivo.application.FindAllPrincipioActivoUseCase;
import com.farmacia.modules.PrincipioActivo.application.FindByIdPrincipioActivoUseCase;
import com.farmacia.modules.PrincipioActivo.application.UpdatePrincipioActivoUseCase;
import com.farmacia.modules.PrincipioActivo.domain.Service.PrincipioActivoService;
import com.farmacia.modules.PrincipioActivo.domain.entity.PrincipioActivo;
import com.farmacia.modules.PrincipioActivo.infrastructure.repository.PrincipioActivoRepository;

public class ConsoleAdapterPrincipioActivo {
    
    private PrincipioActivoService principioActivoService;
    private CreatePrincipioActivoUseCase createActivo;
    private DeletePrincipioActivoUseCase delActivo; 
    private UpdatePrincipioActivoUseCase updActivo;
    private FindByIdPrincipioActivoUseCase idActivo;
    private FindAllPrincipioActivoUseCase allActivo;

    


    public ConsoleAdapterPrincipioActivo() {
        this.principioActivoService = new PrincipioActivoRepository();
        this.createActivo = new CreatePrincipioActivoUseCase(principioActivoService);
        this.updActivo = new UpdatePrincipioActivoUseCase(principioActivoService);
        this.delActivo = new DeletePrincipioActivoUseCase(principioActivoService);
        this.idActivo = new FindByIdPrincipioActivoUseCase(principioActivoService);
        this.allActivo = new FindAllPrincipioActivoUseCase(principioActivoService);
    }




    public void StartPrincipioActivo(){
        boolean Bandera = true;
        Scanner scanner = new Scanner(System.in);
        String titulo = """
                
        █▀▄▀█ █▀▀ █▄░█ █░█   █▀█ █▀█ █ █▄░█ █▀▀ █ █▀█ █ █▀█   ▄▀█ █▀▀ ▀█▀ █ █░█ █▀█
        █░▀░█ ██▄ █░▀█ █▄█   █▀▀ █▀▄ █ █░▀█ █▄▄ █ █▀▀ █ █▄█   █▀█ █▄▄ ░█░ █ ▀▄▀ █▄█
                
                """;
        while (Bandera) {
            validadores.limpiarConsola();
            System.out.println(titulo);
            System.out.println("1. añadir Principio Activo \n2. eliminar Principio Activo \n3. actualizar Principio Activo \n4. buscar por id \n5. listar Unidades de Medidas\n6. salir");
            int opcion = validadores.rangeValidator(1, 6);

            switch (opcion) {
                case 1:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingrese el nombre del Principio Activo: ");
                        String nombre = scanner.nextLine();                    
                        PrincipioActivo principioActivo = new PrincipioActivo(nombre);
                        createActivo.execute(principioActivo);
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELEVE A INTENTARLO");                
                        validadores.pausa();
                        StartPrincipioActivo();
                    }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 2:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingresa el codigo del Principio Activo");
                        int codigoDel = scanner.nextInt();
                        delActivo.execute(codigoDel);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                        validadores.pausa();
                        StartPrincipioActivo();
                    }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();

                    break;
                case 3:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingresa el codigo del Principio Activo");
                        int codigoUPd = scanner.nextInt();
                        updActivo.execute(codigoUPd);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                        validadores.pausa();
                        StartPrincipioActivo();
                    }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 4:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingresa el codigo del Principio Activo");
                        int codigoID = scanner.nextInt();

                        Optional<PrincipioActivo> td = idActivo.execute(codigoID);
                        
                        if (td.isPresent()) {
                            PrincipioActivo ptd = td.get();
                            System.out.println("Id: " + ptd.getIdpa() + " NOMBRE: " + ptd.getNombre());
                        } else {
                            System.out.println("Principio Activo no encontrado.");
                        }
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                        validadores.pausa();
                        StartPrincipioActivo();
                    }
                    
                    validadores.pausa();
                    validadores.limpiarConsola();
                    break;
                case 5:
                    validadores.limpiarConsola();
                    List<PrincipioActivo> PrincipioActivos = allActivo.execute();
                    for (PrincipioActivo PrincipioActivo2 : PrincipioActivos) {
                        System.out.println("ID: " + PrincipioActivo2.getIdpa() + " Nombre: " + PrincipioActivo2.getNombre());
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
