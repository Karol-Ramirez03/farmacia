package com.farmacia.modules.Medicina.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.validadores;
import com.farmacia.modules.Medicina.domain.entity.Medicina;
import com.farmacia.modules.Medicina.application.CreateMedicinaUseCase;
import com.farmacia.modules.Medicina.application.DeleteMedicinaUseCase;
import com.farmacia.modules.Medicina.application.FindAllMedicinaUseCase;
import com.farmacia.modules.Medicina.application.FindByIdMedicinaUseCase;
import com.farmacia.modules.Medicina.application.UpdateMedicinaUseCase;
import com.farmacia.modules.Medicina.domain.Service.MedicinaService;
import com.farmacia.modules.Medicina.infrastructure.repository.MedicinaRepository;

public class ConsoleAdapterMedicina {
    private MedicinaService medicinaService;
    private CreateMedicinaUseCase createMed;
    private DeleteMedicinaUseCase delmed;
    private UpdateMedicinaUseCase updmed;
    private FindByIdMedicinaUseCase idmed;
    private FindAllMedicinaUseCase allmed;


    public ConsoleAdapterMedicina() {
        this.medicinaService = new MedicinaRepository();
        this.createMed = new CreateMedicinaUseCase(medicinaService);
        this.delmed = new DeleteMedicinaUseCase(medicinaService);
        this.updmed = new UpdateMedicinaUseCase(medicinaService);
        this.idmed = new FindByIdMedicinaUseCase(medicinaService);
        this.allmed = new FindAllMedicinaUseCase(medicinaService);
    }

    public void StartMedicina() {
        boolean bandera = true;
        Scanner scanner = new Scanner(System.in);

        while (bandera) {
            System.out.println("1. añadir medicina \n2. eliminar medicina \n3. actualizar medicina \n4. buscar por id \n5. listar medicina\n6. salir");
            int opcion = validadores.rangeValidator(1, 6);

            switch (opcion) {
                case 1:
                    System.out.println("ingrese el proceedings: ");
                    String proceedings = scanner.nextLine();
                    System.out.println("ingresa el nombre de la medicina");
                    String nombre = scanner.nextLine();
                    System.out.println("ingresa el registro Medico de la medicina");
                    String registroMedico = scanner.nextLine();
                    System.out.println("ingresa una descripcion breve del medicina");
                    String descripcionCorto = scanner.nextLine();
                    System.out.println("ingresa una descripcion mas detallada de la  medicina");
                    String descripcion = scanner.nextLine();
                    System.out.println("ingresa el nameRol del medicamento");
                    String nombreRol = scanner.nextLine();
                    System.out.println("ingresa el codigo del Modo de Administracion del medicamento");
                    int codigoModoAdmin = scanner.nextInt();
                    System.out.println("ingresa el codigo del Principio Activo del medicamento");
                    int codigoPrincActivo = scanner.nextInt();
                    System.out.println("ingresa el codigo de Unidad de Medida del medicamento");
                    int codigoUnidadMedida = scanner.nextInt();
                    System.out.println("ingresa el codigo del Laboratorio del medicamento");
                    int codigoLab = scanner.nextInt();

                    Medicina medicina = new Medicina(proceedings, nombre, registroMedico, descripcion, descripcionCorto, nombreRol, codigoModoAdmin, codigoPrincActivo, codigoUnidadMedida, codigoLab);
                    createMed.execute(medicina);
                    
                    break;
                case 2:
                    System.out.println("ingresa el id del medicamento");
                    int iddel = scanner.nextInt();
                    delmed.execute(iddel);
                    
                    break;
                case 3:
                    System.out.println("ingrese el id del medicamento para acctualizar");
                    int idupd = scanner.nextInt();
                    Optional<Medicina> medicinaActulizar = idmed.execute(idupd);

                    if (!medicinaActulizar.isPresent()) {
                        System.out.println("medicamento NO encontrado.");
                        break;       
                    }

                    Medicina medicamentoActual = medicinaActulizar.get();
                    boolean run = true;

                    while (run) {
                        System.out.println("ingresa la opcion que desea actualizar");
                        System.out.println("1. proceedings \n2. nombre \n3. registroMedico \n4. descripcion \n5. descripcion Corta\n6. nombreRol\n7. codigo del Modo de Administracion \n8. codigo del Principio Activo\n9. codigo de Unidad de Medida\n10. codigo del Laboratorio\n11. salir");
                        int opcionact =  validadores.rangeValidator(1,11);
                        switch (opcionact) {
                            case 1:
                                System.out.print("Ingrese el nuevo proceedings: ");
                                medicamentoActual.setProceedings(scanner.nextLine());
                                break;
                            case 2:
                                System.out.print("Ingrese el nuevo nombre: ");
                                medicamentoActual.setNombre(scanner.nextLine());
                                break;
                            case 3:
                                System.out.print("Ingrese el nuevo registroMedico: "); 
                                medicamentoActual.setRegistroMedico(scanner.nextLine());

                                break;
                            case 4:
                                System.out.print("Ingrese la nueva descripcion: "); 
                                medicamentoActual.setDescripcion(scanner.nextLine());
                                
                                break;
                            case 5:
                                System.out.print("Ingrese la nueva descripcion Corta: "); 
                                medicamentoActual.setDescripcionCorto(scanner.nextLine());
                                
                                break;
                            case 6:
                                System.out.print("Ingrese el nuevo nombreRol: "); 
                                medicamentoActual.setNombreRol(scanner.nextLine());
                                
                                break;
                            case 7:
                                System.out.print("Ingrese el codigo del Modo de Administracion: "); 
                                medicamentoActual.setCodigoModoAdmin(scanner.nextInt());
                                
                                break;
                            case 8:
                                System.out.print("Ingrese el codigo del Principio Activo: "); 
                                medicamentoActual.setCodigoPrincActivo(scanner.nextInt());
                                
                                break;
                            case 9:
                                System.out.print("Ingrese el codigo de Unidad de Medida: "); 
                                medicamentoActual.setCodigoUnidadMedida(scanner.nextInt());
                                
                                break;
                            case 10:
                                System.out.print("Ingrese el codigo del Laboratorio: "); 
                                medicamentoActual.setCodigoLab(scanner.nextInt());
                                
                                break;
                            case 11:
                                run = false;
                                break;
                            default:
                                break;
                        }
                        
                        
                    }
                    updmed.execute(medicamentoActual);
                    break;
                case 4:
                    System.out.println("ingresa el codigo de la Medicina");
                    int codigoID = scanner.nextInt();

                    Optional<Medicina> td = idmed.execute(codigoID);
                    
                    if (td.isPresent()) {
                        Medicina ptd = td.get();
                        System.out.println("Proceedings: " + ptd.getProceedings() + " NOMBRE: " + ptd.getNombre() + " REGISTRO MEDICO: " + ptd.getRegistroMedico() + " DESCRIPCION: " + ptd.getDescripcion() +" RESUMEN: " + ptd.getDescripcionCorto()+" NOMBRE ROL:"+ ptd.getNombreRol() + " CODIGO MODO DE ADMINISTRACION: " + ptd.getCodigoModoAdmin() + " CODIGO PRINCIPIO ACTIVO: "+ ptd.getCodigoPrincActivo() + " CODIGO UNIDAD MEDIDA: "+ ptd.getCodigoUnidadMedida()+" CODIGO DEL LABORATORIO: "+ ptd.getCodigoLab());
                    } else {                                                                                                                                                                                                                                                                                                         
                        System.out.println("Medicina no encontrado.");
                    }
                    
                    break;
                case 5:
                    List<Medicina> Medicinas = allmed.execute();
                        for (Medicina Medicina2 : Medicinas) {
                            System.out.println("Proceedings: " + Medicina2.getProceedings() + " NOMBRE: " + Medicina2.getNombre() + " REGISTRO MEDICO: " + Medicina2.getRegistroMedico() + " DESCRIPCION: " + Medicina2.getDescripcion() +" RESUMEN: " + Medicina2.getDescripcionCorto()+" NOMBRE ROL:"+ Medicina2.getNombreRol() + " CODIGO MODO DE ADMINISTRACION: " + Medicina2.getCodigoModoAdmin() + " CODIGO PRINCIPIO ACTIVO: "+ Medicina2.getCodigoPrincActivo() + " CODIGO UNIDAD MEDIDA: "+ Medicina2.getCodigoUnidadMedida()+" CODIGO DEL LABORATORIO: "+ Medicina2.getCodigoLab());
                            System.out.println("____________________");
                        }
                    
                    break;
                case 6:
                    bandera = false;
                    break;

                default:
                    break;
            }
            
        }



    }
    

}
