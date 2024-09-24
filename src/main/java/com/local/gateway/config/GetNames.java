package com.local.gateway.config;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gateway")
public class GetNames {

    @GetMapping("/servicios-registrados")
    public List<String> obtenerServiciosRegistrados() {
        // Devuelve la lista de nombres de los servicios registrados en Eureka
        return List.of("");
    }
}
