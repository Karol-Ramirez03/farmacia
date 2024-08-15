package com.farmacia.modules.FarmaciaMedicina.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.validadores;
import com.farmacia.modules.FarmaciaMedicina.application.CreateFarmaciaMedicinaUseCase;
import com.farmacia.modules.FarmaciaMedicina.application.DeleteFarmaciaMedicinaUseCase;
import com.farmacia.modules.FarmaciaMedicina.application.FindAllFarmaciaMedicinaUseCase;
import com.farmacia.modules.FarmaciaMedicina.application.FindByIdFarmaciaMedicinaUseCase;
import com.farmacia.modules.FarmaciaMedicina.application.UpdateFarmaciaMedicinaUseCase;
import com.farmacia.modules.FarmaciaMedicina.domain.Service.FarmaciaMedicinaService;
import com.farmacia.modules.FarmaciaMedicina.infrastructure.repository.FarmaciaMedicinaRepository;
import com.farmacia.modules.FarmaciaMedicina.domain.entity.FarmaciaMedicina;

public class ConsoleAdapterFarmaciaMedicina {


    private FarmaciaMedicinaService farmaciaMedicinaService;
    private CreateFarmaciaMedicinaUseCase createFM;
    private DeleteFarmaciaMedicinaUseCase delFM;
    private UpdateFarmaciaMedicinaUseCase upFM;
    private FindAllFarmaciaMedicinaUseCase allFM;
    private FindByIdFarmaciaMedicinaUseCase idFM;


    public ConsoleAdapterFarmaciaMedicina() {
        this.farmaciaMedicinaService = new FarmaciaMedicinaRepository();
        this.createFM = new CreateFarmaciaMedicinaUseCase(farmaciaMedicinaService);
        this.delFM = new DeleteFarmaciaMedicinaUseCase(farmaciaMedicinaService);
        this.upFM = new UpdateFarmaciaMedicinaUseCase(farmaciaMedicinaService);
        this.allFM = new FindAllFarmaciaMedicinaUseCase(farmaciaMedicinaService);
        this.idFM = new FindByIdFarmaciaMedicinaUseCase(farmaciaMedicinaService);
    }




    public void StartFarmaciaMedicina(){
            boolean Bandera = true;
            Scanner scanner = new Scanner(System.in);
            
            while (Bandera) {
                System.out.println("1. añadir asignacion de medicamento a farmacias \n2. eliminar asignacion de medicamento a farmacias \n3. actualizar asignacion de medicamento a farmacias \n4. buscar por id \n5. listar asignacion de medicamento a farmacias\n6. salir");
                int opcion = validadores.rangeValidator(1, 6);

                switch (opcion) {
                    case 1:
                        System.out.println("ingresa el id de la farmacia");
                        int farmaciaid = scanner.nextInt();
                        System.out.println("ingresa el id del medicamento");
                        int medicamentoid = scanner.nextInt();
                        System.out.println("ingresa el precio");
                        float precio = scanner.nextFloat();
                       

                        FarmaciaMedicina farmaciaMedicina = new FarmaciaMedicina(farmaciaid, medicamentoid,precio);
                        createFM.execute(farmaciaMedicina);
                        
                        break;
                    case 2:
                        System.out.println("ingresa el id de la farmacia");
                        int farmaciaid2 = scanner.nextInt();
                        System.out.println("ingresa el id del medicamento");
                        int medicamentoid2 = scanner.nextInt();
                        delFM.execute(farmaciaid2, medicamentoid2);

                        break;

                    case 3:
                        System.out.println("ingresa el id de la farmacia");
                        int farmaciaidupd = scanner.nextInt();
                        System.out.println("ingresa el id del medicamento");
                        int medicamentoidupd = scanner.nextInt();

                        Optional<FarmaciaMedicina> FarmaciaMedicinaExistente = idFM.execute(farmaciaidupd, medicamentoidupd);
                        if (!FarmaciaMedicinaExistente.isPresent()) {
                            System.out.println("Farmacia Medicina no encontrado.");
                            break;
                        }
                        FarmaciaMedicina FarmaciaMedicinaActual = FarmaciaMedicinaExistente.get();

                        System.out.print("Ingrese el nuevo precio: ");
                        FarmaciaMedicinaActual.setPrecio(scanner.nextFloat());
                        
                                  
                        upFM.execute(FarmaciaMedicinaActual);
                        
                        break;
                    case 4:
                        System.out.println("ingresa el id de la farmacia");
                        int farmaciaidprint = scanner.nextInt();
                        System.out.println("ingresa el id del medicamento");
                        int medicamentoidprint = scanner.nextInt();

                        Optional<FarmaciaMedicina> td = idFM.execute(farmaciaidprint, medicamentoidprint);
                        
                        if (td.isPresent()) {
                            FarmaciaMedicina ptd = td.get();
                            System.out.println("Id FARMACIA: " + ptd.getIdFarmacia() + " ID MEDICAMENTO: " + ptd.getIdMedicinaFarm() + " PRECIO: " + ptd.getPrecio());
                        } else {                                                                                                                                                                        
                            System.out.println("FarmaciaMedicina no encontrado.");
                        }
                        
                        break;
                    case 5:
                        List<FarmaciaMedicina> FarmaciaMedicinas = allFM.execute();
                        for (FarmaciaMedicina FarmaciaMedicina2 : FarmaciaMedicinas) {
                            System.out.println("ID FARMACIA: " + FarmaciaMedicina2.getIdFarmacia() + " ID MEDICAMENTO: " + FarmaciaMedicina2.getIdMedicinaFarm() + " PRECIO: " + FarmaciaMedicina2.getPrecio());
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
