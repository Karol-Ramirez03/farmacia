package com.farmacia.modules.Region.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.modules.Region.domain.entity.Region;
import com.farmacia.validadores;
import com.farmacia.modules.Region.application.CreateRegionUseCase;
import com.farmacia.modules.Region.application.DeleteRegionUseCase;
import com.farmacia.modules.Region.application.FindAllRegionUseCase;
import com.farmacia.modules.Region.application.FindByIdRegionUseCase;
import com.farmacia.modules.Region.application.UpdateRegionUseCase;
import com.farmacia.modules.Region.domain.Service.RegionService;
import com.farmacia.modules.Region.infrastructure.repository.RegionRepository;



public class ConsoleAdapterRegion {

    private RegionService regionService;
    private CreateRegionUseCase createRegionUseCase;
    private DeleteRegionUseCase deleteRegionUseCase;
    private UpdateRegionUseCase updateRegionUseCase;
    private FindAllRegionUseCase allRegionUseCase;
    private FindByIdRegionUseCase idRegionUseCase;

    


    public ConsoleAdapterRegion() {
        this.regionService = new RegionRepository();
        this.createRegionUseCase = new CreateRegionUseCase(regionService);
        this.deleteRegionUseCase = new DeleteRegionUseCase(regionService);
        this.updateRegionUseCase = new UpdateRegionUseCase(regionService);
        this.allRegionUseCase = new FindAllRegionUseCase(regionService);
        this.idRegionUseCase = new FindByIdRegionUseCase(regionService);
    }




public void StartRegion(){
        boolean Bandera = true;
        Scanner scanner = new Scanner(System.in);
        
        while (Bandera) {
            System.out.println("1. añadir Region \n2. eliminar Region \n3. actualizar Region \n4. buscar por id \n5. listar Region\n6. salir");
            int opcion = validadores.rangeValidator(1, 6);

            switch (opcion) {
                case 1:
                    System.out.println("ingrese el nombre de la Region: ");
                    String nombre = scanner.nextLine();
                    System.out.println("ingresa el codigo de la Region");
                    String codigo = scanner.nextLine();
                    System.out.println("ingresa el codigo del pais");
                    String codigopais = scanner.nextLine();
                    Region region = new Region(codigo,nombre, codigopais);
                    createRegionUseCase.execute(region);
                    
                    break;
                case 2:
                    System.out.println("ingresa el codigo del Region");
                    String codigoDel = scanner.nextLine();
                    deleteRegionUseCase.execute(codigoDel);

                    break;

                case 3:
                    System.out.println("ingresa el codigo del Region");
                    String codigoUPd = scanner.nextLine();

                    Optional<Region> RegionExistente = idRegionUseCase.execute(codigoUPd);
                    if (!RegionExistente.isPresent()) {
                        System.out.println("Region no encontrado.");
                        break;
                    }
                    Region RegionActual = RegionExistente.get();
                    boolean actualizar = true;

                    while (actualizar) {
                        System.out.println("Seleccione el campo a actualizar:");
                        System.out.println("1. Nombre");
                        System.out.println("2. codigo del pais");
                        System.out.println("3. Terminar actualización");
                        int campo = validadores.rangeValidator(1, 3);

                        switch (campo) {
                            case 1:
                                System.out.print(">> Ingrese el nuevo nombre: ");
                                RegionActual.setNombrereg(scanner.nextLine());
                                
                                break;
                            case 2:
                                System.out.print(">> Ingrese el id del pais: ");
                                RegionActual.setCodigopais(scanner.nextLine());
                                break;
                            case 3:
                                actualizar = false;
                                break;
                            default:
                                System.out.println("Opción inválida, intente de nuevo.");
                        }
                    }
                    updateRegionUseCase.execute(RegionActual);
                    
                    break;
                case 4:
                    System.out.println("ingresa el codigo de la Region");
                    String codigoID = scanner.nextLine();

                    Optional<Region> td = idRegionUseCase.execute(codigoID);
                    
                    if (td.isPresent()) {
                        Region ptd = td.get();
                        System.out.println("Id: " + ptd.getCodigoreg() + " NOMBRE: " + ptd.getNombrereg() + "CODIGO DEL PAIS: " + ptd.getCodigopais());
                    } else {
                        System.out.println("Region no encontrado.");
                    }
                    
                    break;
                case 5:
                    List<Region> Regiones = allRegionUseCase.execute();
                    for (Region Region2 : Regiones) {
                        System.out.println("ID: " + Region2.getCodigoreg() + " Nombre: " + Region2.getNombrereg() + "CODIGO DE LA REGION: " + Region2.getCodigopais());
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
