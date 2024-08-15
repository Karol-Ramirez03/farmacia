package com.farmacia.modules.Laboratorio.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


import com.farmacia.validadores;
import com.farmacia.modules.Laboratorio.application.CreateLaboratorioUseCase;
import com.farmacia.modules.Laboratorio.application.DeleteLaboratorioUseCase;
import com.farmacia.modules.Laboratorio.application.FindAllLaboratorioUseCase;
import com.farmacia.modules.Laboratorio.application.FindByIdLaboratorioUseCase;
import com.farmacia.modules.Laboratorio.application.UpdateLaboratorioUseCase;
import com.farmacia.modules.Laboratorio.domain.Service.LaboratorioService;
import com.farmacia.modules.Laboratorio.domain.entity.Laboratorio;
import com.farmacia.modules.Laboratorio.infrastructure.repository.LaboratorioRepository;

public class ConsoleAdapterLaboratorio {

    private LaboratorioService laboratorioService;
    private CreateLaboratorioUseCase createlab;
    private DeleteLaboratorioUseCase dellab;
    private UpdateLaboratorioUseCase updlab;
    private FindAllLaboratorioUseCase allLab;
    private FindByIdLaboratorioUseCase idLab;

    public ConsoleAdapterLaboratorio() {
        this.laboratorioService = new LaboratorioRepository();
        this.createlab = new CreateLaboratorioUseCase(laboratorioService);
        this.dellab = new DeleteLaboratorioUseCase(laboratorioService);
        this.updlab = new UpdateLaboratorioUseCase(laboratorioService);
        this.allLab = new FindAllLaboratorioUseCase(laboratorioService);
        this.idLab = new FindByIdLaboratorioUseCase(laboratorioService);
    }
    

    public void StartLaboratorio(){
            boolean Bandera = true;
            Scanner scanner = new Scanner(System.in);
            
            while (Bandera) {
                System.out.println("1. añadir Laboratorio \n2. eliminar Laboratorio \n3. actualizar Laboratorio \n4. buscar por id \n5. listar Laboratorio\n6. salir");
                int opcion = validadores.rangeValidator(1, 6);

                switch (opcion) {
                    case 1:
                        System.out.println("ingrese el nombre de la Laboratorio: ");
                        String nombreLaboratorio = scanner.nextLine();
                        System.out.println("ingrese el codigo de la ciudad del Laboratorio: ");
                        String codCiudad = scanner.nextLine();
                       

                        Laboratorio laboratorio = new Laboratorio(nombreLaboratorio, codCiudad);
                        createlab.execute(laboratorio);
                        
                        break;
                    case 2:
                        System.out.println("ingresa el id del Laboratorio");
                        int codigoDel = scanner.nextInt();
                        dellab.execute(codigoDel);

                        break;

                    case 3:
                        System.out.println("ingresa el id del Laboratorio");
                        int codigoUPd = scanner.nextInt();

                        Optional<Laboratorio> LaboratorioExistente = idLab.execute(codigoUPd);
                        if (!LaboratorioExistente.isPresent()) {
                            System.out.println("Laboratorio no encontrado.");
                            break;
                        }
                        Laboratorio LaboratorioActual = LaboratorioExistente.get();
                        boolean actualizar = true;

                        while (actualizar) {
                            System.out.println("Seleccione el campo a actualizar:");
                            System.out.println("1. Nombre");
                            System.out.println("2. codigo de ciudad");
                            System.out.println("3. terminar Actualizacion");


                            int campo = validadores.rangeValidator(1, 3);

                            switch (campo) {
                                case 1:
                                    System.out.print("Ingrese el nuevo nombre: ");
                                    LaboratorioActual.setNombreLab(scanner.nextLine());
                                    
                                    break;
                                case 2:
                                    System.out.print("Ingrese el nuevo codigo de ciudad: ");
                                    LaboratorioActual.setCodigoCiudad(scanner.nextLine());
                               
                                    break;
                                case 3:
                                    actualizar = false;
                                    break;
                                default:
                                    System.out.println("Opción inválida, intente de nuevo.");
                            }
                        }
                        updlab.execute(LaboratorioActual);
                        
                        break;
                    case 4:
                        System.out.println("ingresa el codigo del Laboratorio");
                        int codigoID = scanner.nextInt();

                        Optional<Laboratorio> td = idLab.execute(codigoID);
                        
                        if (td.isPresent()) {
                            Laboratorio ptd = td.get();
                            System.out.println("Id: " + ptd.getCodigoLab() + " NOMBRE: " + ptd.getNombreLab() + " CODIGO CIUDAD: " + ptd.getCodigoCiudad());
                        } else {                                                                                                                                                                        
                            System.out.println("Laboratorio no encontrado.");
                        }
                        
                        break;
                    case 5:
                        List<Laboratorio> Laboratorios = allLab.execute();
                        for (Laboratorio Laboratorio2 : Laboratorios) {
                            System.out.println("Id: " + Laboratorio2.getCodigoLab() + " NOMBRE: " + Laboratorio2.getNombreLab() + " CODIGO CIUDAD: " + Laboratorio2.getCodigoCiudad());
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
