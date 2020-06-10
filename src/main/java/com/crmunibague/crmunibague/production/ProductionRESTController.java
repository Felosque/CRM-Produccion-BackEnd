package com.crmunibague.crmunibague.production;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin( origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("scm-unibague/Production")
@RestController
public class ProductionRESTController {

    private ProductionService productionService;

    @Autowired
    public ProductionRESTController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @PostMapping
    public ResponseEntity<Production> save(@RequestBody Production entity){
        return ResponseEntity.ok().body(this.productionService.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Production>> getAll(){
        return ResponseEntity.ok().body(this.productionService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Production> getById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.productionService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") int id){
        this.productionService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Production> update(@PathVariable("id") int id, @RequestBody Production entity){
        return ResponseEntity.ok().body(this.productionService.update(id,entity));
    }

    @GetMapping(path = "/TiempoRestante")
    public List<Map<String,String>> getTiempoRestante(){
        List<Production> productions = this.productionService.getAll();
        List<Map<String,String>> listaResultado = new ArrayList<>();
        Map<String,String> resultado = new HashMap<>();

        for (int i = 0; i < productions.size(); i++)
        {
            resultado = new HashMap<>();
            Production actual = productions.get(i);
            try {
                resultado.put("code",actual.getCode()+"");
                resultado.put("data", darTiempoDiferencia(new SimpleDateFormat("dd/MM/yyyy").parse(actual.getExpirationDate())));
                listaResultado.add(resultado);
            }
            catch (Exception e)
            {
                resultado.put("code",actual.getCode()+"");
                resultado.put("data","LA FECHA DE LA SOLICITUD ES INCORRECTA.");
                listaResultado.add(resultado);
            }

        }
        return listaResultado;
    }

    public String darTiempoDiferencia(Date pFecha){

        String respuesta = "";
        Date fechaActual = new Date();
        System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(fechaActual) + " fecha actual.");
        System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(pFecha) + " fecha parametro.");

        int diferencia=(int) ((pFecha.getTime()-fechaActual.getTime())/1000);

        int dias=0;
        int horas=0;
        int minutos=0;

        if(diferencia>86400) {
            dias=(int)Math.floor(diferencia/86400);
            diferencia=diferencia-(dias*86400);
        }
        if(diferencia>3600) {
            horas=(int)Math.floor(diferencia/3600);
            diferencia=diferencia-(horas*3600);
        }
        if(diferencia>60) {
            minutos=(int)Math.floor(diferencia/60);
            diferencia=diferencia-(minutos*60);
        }

        if(diferencia < 0){
            respuesta = "SOLICITUD VENCIDA";
        }
        else
        {
            respuesta = dias+" días, "+horas+" horas, "+minutos+" minutos restantes";
        }

        return respuesta;
    }

}

