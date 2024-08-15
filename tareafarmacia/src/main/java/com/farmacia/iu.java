package com.farmacia;

import java.util.Scanner;

import com.farmacia.modules.Ciudad.infrastructure.controller.CiudadConsoleAdapter;
import com.farmacia.modules.Cliente.infrastructure.controller.ConsoleAdapterCliente;
import com.farmacia.modules.Farmacia.infrastructure.controller.ConsoleAdapterFarmacia;
import com.farmacia.modules.FarmaciaMedicina.infrastructure.controller.ConsoleAdapterFarmaciaMedicina;
import com.farmacia.modules.Laboratorio.infrastructure.controller.ConsoleAdapterLaboratorio;
import com.farmacia.modules.Medicina.infrastructure.controller.ConsoleAdapterMedicina;
import com.farmacia.modules.ModoAdministracion.infrastructure.controller.ConsoleAdapterModoAdministracion;
import com.farmacia.modules.Pais.infrastructure.controller.ConsoleAdapterPais;
import com.farmacia.modules.PrincipioActivo.infrastructure.controller.ConsoleAdapterPrincipioActivo;
import com.farmacia.modules.Region.infrastructure.controller.ConsoleAdapterRegion;
import com.farmacia.modules.UnidadMedida.infrastructure.controller.ConsoleAdapterUnidadMedida;

public class iu {
    static String titulo = """
            
            █▀▀ ▄▀█ █▀█ █▀▄▀█ ▄▀█ █▀▀ █ ▄▀█
            █▀░ █▀█ █▀▄ █░▀░█ █▀█ █▄▄ █ █▀█

    """;
    public static void menuPrincipal(){
        System.out.println(titulo);
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;

        while (exit) {
            validadores.limpiarConsola();
            System.out.println(titulo);
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Menú País");
            System.out.println("2. Menú Ciudad");
            System.out.println("3. Menú Región");
            System.out.println("4. Menú Unidad de Medida");
            System.out.println("5. Menú Principio Activo");
            System.out.println("6. Menú Modo de Administración");
            System.out.println("7. Menú Cliente");
            System.out.println("8. Menú Medicina");
            System.out.println("9. Menú Farmacia");
            System.out.println("10. Menú Laboratorio");
            System.out.println("11. Menú Farmacia Medicina");
            System.out.println("12. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = validadores.rangeValidator(1, 12);

             switch (opcion) {
                case 1:
                    ConsoleAdapterPais menuPais = new ConsoleAdapterPais();
                    menuPais.StartPais();
                    break;
                case 2:
                    CiudadConsoleAdapter menuciudad = new CiudadConsoleAdapter();
                    menuciudad.StartCiudad();
                    break;
                case 3:
                    ConsoleAdapterRegion menuRegion = new ConsoleAdapterRegion();
                    menuRegion.StartRegion();
                    break;
                case 4:
                    ConsoleAdapterUnidadMedida menuUnidadMedida = new ConsoleAdapterUnidadMedida();
                    menuUnidadMedida.StartUnidadMedida();
                    break;
                case 5:
                    ConsoleAdapterPrincipioActivo menuPrincipioActivo = new ConsoleAdapterPrincipioActivo();
                    menuPrincipioActivo.StartPrincipioActivo();
                    break;
                case 6:
                    ConsoleAdapterModoAdministracion menuModo = new ConsoleAdapterModoAdministracion();
                    menuModo.StartModoAdministracion();
                    break;
                case 7:
                    ConsoleAdapterCliente menuCliente = new ConsoleAdapterCliente();
                    menuCliente.StartCliente();
                    break;
                case 8:
                    ConsoleAdapterMedicina menuMedicina = new ConsoleAdapterMedicina();
                    menuMedicina.StartMedicina();
                    break;
                case 9:
                    ConsoleAdapterFarmacia menuFarmacia = new ConsoleAdapterFarmacia();
                    menuFarmacia.StartFarmacia();
                    break;
                case 10:
                    ConsoleAdapterLaboratorio menuLaboratorio = new ConsoleAdapterLaboratorio();
                    menuLaboratorio.StartLaboratorio();
                    break;
                case 11:
                    ConsoleAdapterFarmaciaMedicina menufm = new ConsoleAdapterFarmaciaMedicina();
                    menufm.StartFarmaciaMedicina();
                    break;
                case 12:
                    exit = false;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
            
        }
    



}
    

