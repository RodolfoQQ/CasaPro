package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.Producto;
import com.proyecto.CasaPro.servicios.ServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/producto")
public class ControllerProducto {
    @Autowired
    private ServiceProducto serviceProducto;

    @PostMapping
    public ResponseEntity<?> guardarProducto(@RequestBody Producto producto){

        HashMap<String,Object> productoHashMap =new HashMap<>();
        productoHashMap.put("producto",serviceProducto.guardarProducto(producto));
        productoHashMap.put("mensaje","se guardo con exito");

        return ResponseEntity.status(HttpStatus.CREATED).body(productoHashMap);
    }

    @GetMapping
    public ResponseEntity<List<Producto>>  listarProductos(){
        List<Producto> productos =serviceProducto.findallProductos();
        HttpHeaders headers =new HttpHeaders();
            headers.add("mensaje","menajeeeeeeeeeeeeeeeeee");
        return  new ResponseEntity<>(productos,headers, HttpStatus.OK);
    }

   /* @GetMapping
    public List<Producto>  listarProductos(){
        List<Producto> productos =serviceProducto.findallProductos();
        return  productos;
    }*/

    @GetMapping("{codProducto}")
    public ResponseEntity<?> findByid(@PathVariable Integer codProducto){
        HashMap<String,Object> hashMap=new HashMap<>();
        Optional<Producto>  responseSearch= serviceProducto.findByCodproducto(codProducto);
        if (responseSearch.isEmpty()) {
            hashMap.put("menjsajeError", "Codigo incorrecto o no existe");
            return ResponseEntity.noContent().build();
        } else {
            hashMap.put("responseSearch",responseSearch);

            return ResponseEntity.status(HttpStatus.OK).body(hashMap);
        }
    }

    @DeleteMapping("{codProducto}")
    public ResponseEntity<?> deletebycodProducto(@PathVariable Integer codProducto){
            serviceProducto.productodeletebyid(codProducto);
            String mensaje="se elimino correctamente el producto con codidigo "+codProducto;

        return ResponseEntity.ok(mensaje);
    }

}
