package com.farmacia.modules.Farmacia.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.validadores;
import com.farmacia.modules.Farmacia.application.CreateFarmaciaUseCase;
import com.farmacia.modules.Farmacia.application.DeleteFarmaciaUseCase;
import com.farmacia.modules.Farmacia.application.FindAllFarmaciaUseCase;
import com.farmacia.modules.Farmacia.application.FindByIdFarmaciaUseCase;
import com.farmacia.modules.Farmacia.application.UpdateFarmaciaUseCase;
import com.farmacia.modules.Farmacia.domain.Service.FarmaciaService;
import com.farmacia.modules.Farmacia.domain.entity.Farmacia;
import com.farmacia.modules.Farmacia.infrastructure.repository.FarmaciaRepository;


public class ConsoleAdapterFarmacia {

    private FarmaciaService farmaciaService;
    private CreateFarmaciaUseCase createFarm;
    private DeleteFarmaciaUseCase delFarm; 
    private UpdateFarmaciaUseCase updFarm;
    private FindAllFarmaciaUseCase allFarm;
    private FindByIdFarmaciaUseCase idFarm;

    public ConsoleAdapterFarmacia() {
            this.farmaciaService = new FarmaciaRepository();
            this.createFarm = new CreateFarmaciaUseCase(farmaciaService);
            this.delFarm = new DeleteFarmaciaUseCase(farmaciaService);
            this.updFarm = new UpdateFarmaciaUseCase(farmaciaService);
            this.allFarm = new FindAllFarmaciaUseCase(farmaciaService);
            this.idFarm = new FindByIdFarmaciaUseCase(farmaciaService);
        }





    public void StartFarmacia(){
            boolean Bandera = true;
            Scanner scanner = new Scanner(System.in);
            String titulo = """
                    
                    █▀▄▀█ █▀▀ █▄░█ █░█   █▀▀ ▄▀█ █▀█ █▀▄▀█ ▄▀█ █▀▀ █ ▄▀█
                    █░▀░█ ██▄ █░▀█ █▄█   █▀░ █▀█ █▀▄ █░▀░█ █▀█ █▄▄ █ █▀█

                    """;
            
            while (Bandera) {
                validadores.limpiarConsola();
                System.out.println(titulo);
                System.out.println("1. añadir Farmacia \n2. eliminar Farmacia \n3. actualizar Farmacia \n4. buscar por id \n5. listar Farmacia\n6. salir");
                int opcion = validadores.rangeValidator(1, 6);

                switch (opcion) {
                    case 1:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingrese el nombre de la Farmacia: ");
                        String nombreFarmacia = scanner.nextLine();
                        System.out.println("ingrese el direccion de la Farmacia: ");
                        String direccion = scanner.nextLine();
                        System.out.println("ingresa la longitud");
                        float lon = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.println("ingresa la latitud");
                        float latitud = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.println("ingrese el codigo de la ciudad de la Farmacia: ");
                        String ciudad = scanner.nextLine();
                        System.out.println("ingrese el logo: ");
                        String logo = scanner.nextLine();

                        Farmacia Farmacia = new Farmacia(nombreFarmacia, direccion ,lon,latitud,ciudad,logo);
                        createFarm.execute(Farmacia);
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                        validadores.pausa();
                        StartFarmacia();
                    }
                        
                        System.out.println("");
                        validadores.pausa();
                        validadores.limpiarConsola();
                        
                        break;
                    case 2:
                    try {
                        validadores.limpiarConsola();
                        System.out.println("ingresa el id del Farmacia");
                        int codigoDel = scanner.nextInt();
                        delFarm.execute(codigoDel);
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("");
                        System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                        validadores.pausa();
                        StartFarmacia();
                    }
                        
                        validadores.pausa();
                        validadores.limpiarConsola();

                        break;

                    case 3:
                      try {
                        validadores.limpiarConsola();
                        System.out.println("ingresa el id del Farmacia");
                        int codigoUPd = scanner.nextInt();

                        Optional<Farmacia> FarmaciaExistente = idFarm.execute(codigoUPd);
                        if (!FarmaciaExistente.isPresent()) {
                            System.out.println("Farmacia no encontrado.");
                            break;
                        }
                        Farmacia FarmaciaActual = FarmaciaExistente.get();
                        boolean actualizar = true;

                        while (actualizar) {
                            validadores.limpiarConsola();
                            System.out.println("Seleccione el campo a actualizar:");
                            System.out.println("1. Nombre");
                            System.out.println("2. direccion");
                            System.out.println("3. longitud ");
                            System.out.println("4. latitud ");
                            System.out.println("5. codigo ciudad");
                            System.out.println("6. logo");
                            System.out.println("7. Terminar Actualizacion ");



                            int campo = validadores.rangeValidator(1, 8);
                            scanner.nextLine();

                            switch (campo) {
                                case 1:
                                    System.out.print("Ingrese el nuevo nombre: ");
                                    FarmaciaActual.setNombreFarmacia(scanner.nextLine());
                                    
                                    break;
                                case 2:
                                    System.out.print("Ingrese la nueva dirrecion: ");
                                    FarmaciaActual.setDireccionFarmacia(scanner.nextLine());
                                    break;
                                case 3:
                                    System.out.print("Ingrese la longitud: ");
                                    FarmaciaActual.setLongFarmacia(scanner.nextFloat());

                                    break;
                                case 4:
                                    System.out.print("Ingrese la latitud ");
                                    FarmaciaActual.setLatFarmacia(scanner.nextFloat());
                                    break;
                                case 5:
                                    System.out.print("Ingrese el nuevo codigo de ciudad: ");
                                    FarmaciaActual.setCodigoCiudadFarm(scanner.nextLine());
                                    
                                    break;
                                case 6:
                                    System.out.print("Ingrese el logo: ");
                                    FarmaciaActual.setLogoFarmacia(scanner.nextLine());
                                    
                                    break;
                                case 7:
                                    actualizar = false;
                                    break;
                                default:
                                    System.out.println("Opción inválida, intente de nuevo.");
                            }
                        }
                        updFarm.execute(FarmaciaActual);
                            
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("");
                            System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                            validadores.pausa();
                            StartFarmacia();
                        }
                        
                        validadores.pausa();
                        validadores.limpiarConsola();
                        
                        break;
                    case 4:
                        try {
                            validadores.limpiarConsola();
                            System.out.println("ingresa el codigo de la Farmacia");
                            int codigoID = scanner.nextInt();

                            Optional<Farmacia> td = idFarm.execute(codigoID);
                            
                            if (td.isPresent()) {
                                Farmacia ptd = td.get();
                                System.out.println("Id: " + ptd.getIdf() + " NOMBRE: " + ptd.getNombreFarmacia() + " DIRECCION: " + ptd.getDireccionFarmacia() + " LONGITUD: " + ptd.getLongFarmacia()+" CODIGO CIUDAD" + ptd.getCodigoCiudadFarm() + " LOGO: "+ ptd.getLogoFarmacia());
                            } else {                                                                                                                                                                        
                                System.out.println("Farmacia no encontrado.");
                            }
                            
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("");
                            System.out.println("PROBLEMAS AL INGRESAR DATOS, VUELVE A INTENTARLO");                
                            validadores.pausa();
                            StartFarmacia();
                        }
                        
                        validadores.pausa();
                        validadores.limpiarConsola();
                        
                        break;
                    case 5:
                        validadores.limpiarConsola();
                        List<Farmacia> Farmacias = allFarm.execute();
                        for (Farmacia Farmacia2 : Farmacias) {
                            System.out.println("Id: " + Farmacia2.getIdf() + " NOMBRE: " + Farmacia2.getNombreFarmacia() + " DIRECCION: " + Farmacia2.getDireccionFarmacia() + " LONGITUD: " + Farmacia2.getLongFarmacia()+" CODIGO CIUDAD" + Farmacia2.getCodigoCiudadFarm() + " LOGO: "+ Farmacia2.getLogoFarmacia());
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
