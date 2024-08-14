package com.farmacia;

import com.farmacia.modules.Ciudad.infrastructure.controller.CiudadConsoleAdapter;
import com.farmacia.modules.ModoAdministracion.infrastructure.controller.ConsoleAdapterModoAdministracion;
import com.farmacia.modules.Pais.infrastructure.controller.ConsoleAdapterPais;
import com.farmacia.modules.PrincipioActivo.infrastructure.controller.ConsoleAdapterPrincipioActivo;
import com.farmacia.modules.Region.infrastructure.controller.ConsoleAdapterRegion;
import com.farmacia.modules.UnidadMedida.infrastructure.controller.ConsoleAdapterUnidadMedida;

public class Main {
    public static void main(String[] args) {
        // ConsoleAdapterPais menuPais = new ConsoleAdapterPais();
        // menuPais.StartPais();

        // CiudadConsoleAdapter menuciudad = new CiudadConsoleAdapter();
        // menuciudad.StartCiudad();

        // ConsoleAdapterRegion menuRegion = new ConsoleAdapterRegion();
        // menuRegion.StartRegion();

        // ConsoleAdapterUnidadMedida menuUnidadMedida = new ConsoleAdapterUnidadMedida();
        // menuUnidadMedida.StartUnidadMedida();

        // ConsoleAdapterPrincipioActivo menuPrincipioActivo = new ConsoleAdapterPrincipioActivo();
        // menuPrincipioActivo.StartPrincipioActivo();

        ConsoleAdapterModoAdministracion menuModo = new ConsoleAdapterModoAdministracion();
        menuModo.StartModoAdministracion();
    }
}