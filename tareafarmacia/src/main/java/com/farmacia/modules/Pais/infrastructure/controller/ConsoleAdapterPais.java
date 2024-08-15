package com.farmacia.modules.Pais.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.validadores;
import com.farmacia.modules.Pais.application.CreatePaisUseCase;
import com.farmacia.modules.Pais.application.DeletePaisUseCase;
import com.farmacia.modules.Pais.application.FindPaisAllUseCase;
import com.farmacia.modules.Pais.application.FindPaisByIdUseCase;
import com.farmacia.modules.Pais.application.UpdatePaisUseCase;
import com.farmacia.modules.Pais.domain.service.PaisService;
import com.farmacia.modules.Pais.domain.entity.Pais;
import com.farmacia.modules.Pais.infrastructure.repository.PaisRepository;

public class ConsoleAdapterPais {
    private PaisService paisService;
    private CreatePaisUseCase createPais;
    private DeletePaisUseCase delPais;
    private UpdatePaisUseCase updPais;
    private FindPaisAllUseCase allPais;
    private FindPaisByIdUseCase idPais;


    public ConsoleAdapterPais() {
        this.paisService = new PaisRepository();
        this.createPais = new CreatePaisUseCase(paisService);
        this.delPais = new DeletePaisUseCase(paisService);
        this.updPais = new UpdatePaisUseCase(paisService);
        this.allPais = new FindPaisAllUseCase(paisService);
        this.idPais = new FindPaisByIdUseCase(paisService);
    }


    public void StartPais(){
        boolean Bandera = true;
        Scanner scanner = new Scanner(System.in);
        String titulo = """             
                
        █▀▄▀█ █▀▀ █▄░█ █░█   █▀█ ▄▀█ █ █▀
        █░▀░█ ██▄ █░▀█ █▄█   █▀▀ █▀█ █ ▄█

                """;
        while (Bandera) {
            validadores.limpiarConsola();
            System.out.println(titulo);
            System.out.println("1. añadir pais \n2. eliminar pais \n3. actualizar pais \n4. buscar por id \n5. listar pais\n6. salir");
            int opcion = validadores.rangeValidator(1, 6);
            switch (opcion) {
                case 1:
                    validadores.limpiarConsola();
                    System.out.println("ingrese el nombre del pais: ");
                    String nombre = scanner.nextLine();
                    System.out.println("ingresa el codigo del pais");
                    String codigo = scanner.nextLine();
                    Pais pais = new Pais(nombre, codigo);
                    createPais.execute(pais);
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 2:
                    validadores.limpiarConsola();
                    System.out.println("ingresa el codigo del pais");
                    String codigoDel = scanner.nextLine();
                    delPais.execute(codigoDel);
                    validadores.pausa();
                    validadores.limpiarConsola();

                    break;
                case 3:
                    validadores.limpiarConsola();
                    System.out.println("ingresa el codigo del pais");
                    String codigoUPd = scanner.nextLine();

                    updPais.execute(codigoUPd);
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 4:
                    validadores.limpiarConsola();
                    System.out.println("ingresa el codigo del pais");
                    String codigoID = scanner.nextLine();

                    Optional<Pais> td = idPais.execute(codigoID);
                    
                    if (td.isPresent()) {
                        Pais ptd = td.get();
                        System.out.println("Id: " + ptd.getCodigopais() + " NOMBRE: " + ptd.getNombre());
                    } else {
                        System.out.println("pais no encontrado.");
                    }
                    validadores.pausa();
                    validadores.limpiarConsola();
                    
                    break;
                case 5:
                    validadores.limpiarConsola();
                    List<Pais> paises = allPais.execute(); 
                    for (Pais pais2 : paises) {
                        System.out.println("ID: " + pais2.getCodigopais() + " Nombre: " + pais2.getNombre());
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
