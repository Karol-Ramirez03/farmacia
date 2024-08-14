package com.farmacia.modules.Ciudad.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.validadores;
import com.farmacia.modules.Ciudad.domain.Service.CiudadService;
import com.farmacia.modules.Ciudad.domain.entity.Ciudad;
import com.farmacia.modules.Ciudad.infrastructure.repository.CiudadRepository;
import com.farmacia.modules.Ciudad.application.CreateCiudadUseCase;
import com.farmacia.modules.Ciudad.application.DeleteCiudadUseCase;
import com.farmacia.modules.Ciudad.application.FindAllCiudadUseCase;
import com.farmacia.modules.Ciudad.application.FindByIdCiudadUseCase;
import com.farmacia.modules.Ciudad.application.UpdateCiudadUseCase;

public class CiudadConsoleAdapter {
    private CiudadService ciudadService;
    private CreateCiudadUseCase createCiudad;
    private DeleteCiudadUseCase delCiudad;
    private UpdateCiudadUseCase updCiudad;
    private FindAllCiudadUseCase allCiudad;
    private FindByIdCiudadUseCase idCiudad;

    

    public CiudadConsoleAdapter() {
        this.ciudadService = new CiudadRepository();
        this.createCiudad = new CreateCiudadUseCase(ciudadService);
        this.delCiudad = new DeleteCiudadUseCase(ciudadService);
        this.updCiudad = new UpdateCiudadUseCase(ciudadService);
        this.allCiudad = new FindAllCiudadUseCase(ciudadService);
        this.idCiudad = new FindByIdCiudadUseCase(ciudadService);
    }



    public void StartCiudad(){
        boolean Bandera = true;
        Scanner scanner = new Scanner(System.in);
        while (Bandera) {
            System.out.println("1. añadir Ciudad \n2. eliminar Ciudad \n3. actualizar Ciudad \n4. buscar por id \n5. listar Ciudad\n6. salir");
            int opcion = validadores.rangeValidator(1, 6);

            switch (opcion) {
                case 1:
                    System.out.println("ingrese el nombre de la Ciudad: ");
                    String nombre = scanner.nextLine();
                    System.out.println("ingresa el codigo de la Ciudad");
                    String codigo = scanner.nextLine();
                    System.out.println("ingresa el codigo de la region");
                    String codigoreg = scanner.nextLine();
                    Ciudad Ciudad = new Ciudad(codigo,nombre, codigoreg);
                    createCiudad.execute(Ciudad);
                    
                    break;
                case 2:
                    System.out.println("ingresa el codigo del Ciudad");
                    String codigoDel = scanner.nextLine();
                    delCiudad.execute(codigoDel);

                    break;

                case 3:
                    System.out.println("ingresa el codigo del Ciudad");
                    String codigoUPd = scanner.nextLine();

                    Optional<Ciudad> ciudadExistente = idCiudad.execute(codigoUPd);
                    if (!ciudadExistente.isPresent()) {
                        System.out.println("ciudad no encontrado.");
                        break;
                    }
                    Ciudad ciudadActual = ciudadExistente.get();
                    boolean actualizar = true;

                    while (actualizar) {
                        System.out.println("Seleccione el campo a actualizar:");
                        System.out.println("1. Nombre");
                        System.out.println("2. codigo de la region");
                        System.out.println("3. Terminar actualización");
                        int campo = validadores.rangeValidator(1, 3);

                        switch (campo) {
                            case 1:
                                System.out.print(">> Ingrese el nuevo nombre: ");
                                ciudadActual.setNombreciudad(scanner.nextLine());
                                
                                break;
                            case 2:
                                System.out.print(">> Ingrese el id de la region: ");
                                ciudadActual.setCodigoreg(scanner.nextLine());
                                break;
                            case 3:
                                actualizar = false;
                                break;
                            default:
                                System.out.println("Opción inválida, intente de nuevo.");
                        }
                    }
                    updCiudad.execute(ciudadActual);
                    
                    break;
                case 4:
                    System.out.println("ingresa el codigo de la Ciudad");
                    String codigoID = scanner.nextLine();

                    Optional<Ciudad> td = idCiudad.execute(codigoID);
                    
                    if (td.isPresent()) {
                        Ciudad ptd = td.get();
                        System.out.println("Id: " + ptd.getCodigociudad() + " NOMBRE: " + ptd.getNombreciudad() + "CODIGO DE LA REGION: " + ptd.getCodigoreg());
                    } else {
                        System.out.println("Ciudad no encontrado.");
                    }
                    
                    break;
                case 5:
                    List<Ciudad> Ciudades = allCiudad.execute(); 
                    for (Ciudad Ciudad2 : Ciudades) {
                        System.out.println("ID: " + Ciudad2.getCodigociudad() + " Nombre: " + Ciudad2.getNombreciudad() + "CODIGO DE LA REGION: " + Ciudad2.getCodigoreg());
                        System.out.println("--------------------");
                    }
                    break;
                case 6:
                    return;
                default:
                    break;
            }
            
        }

    }
}
