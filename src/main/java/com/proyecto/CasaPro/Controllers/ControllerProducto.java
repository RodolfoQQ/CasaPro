package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.Categoria;
import com.proyecto.CasaPro.entidades.Producto;
import com.proyecto.CasaPro.exceptions.ResourceNotFoundException;
import com.proyecto.CasaPro.servicios.ServiceCaTegoria;
import com.proyecto.CasaPro.servicios.ServiceProducto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@AllArgsConstructor
@RequestMapping("/api/producto")
public class ControllerProducto {

    private ServiceProducto serviceProducto;


    @PostMapping
    public ResponseEntity<?> guardarProducto(@Valid @RequestBody Producto producto, BindingResult result){
        if (result.hasErrors()){
            return validacion(result);
        }

        Producto productoGuardado = serviceProducto.guardarProducto(producto);
        HashMap<String,Object> productoHashMap =new HashMap<>();
        if(productoGuardado!=null) {
            productoHashMap.put("producto",productoGuardado);
            productoHashMap.put("mensaje","se guardo con exito");
            return  ResponseEntity.status(HttpStatus.CREATED).body(productoHashMap);
        } else{
            throw new ResourceNotFoundException("Error en  guardar el producto");
        }
    }

    @PutMapping("{codproducto}")
    public ResponseEntity<?> actualizarProducto(@Valid  @RequestBody Producto producto, BindingResult result,@PathVariable Integer codproducto){
        if (result.hasErrors()){
            return validacion(result);
        }
        HashMap<String,Object> respose=new HashMap<>();
        Producto productoActualizado= serviceProducto.actualizaProducto( codproducto, producto);
        if(productoActualizado!=null){
            respose.put("success","Se actualizo con exito el producto con codigo : " +codproducto);
            respose.put("prodcuto :",productoActualizado);
            return new ResponseEntity<>( respose,HttpStatus.OK);
        }else {
            throw new ResourceNotFoundException("Error en actualizar el producto con código: " + codproducto);
        }
    }

    @GetMapping
    public ResponseEntity<List<Producto>>  listarProductos(){
        List<Producto> productos =serviceProducto.findallProductos();
        if (!productos.isEmpty()){
            return new ResponseEntity<>(productos,HttpStatus.OK);
        }else {
            throw new ResourceNotFoundException("Error en obtener losd datos de productos");
        }
    }


    @GetMapping("{codProducto}")
    public ResponseEntity<?> findByid(@PathVariable Integer codProducto){
        HashMap<String,Object> hashMap=new HashMap<>();
        Optional<Producto> responseSearch= serviceProducto.findByCodproducto(codProducto);
        if (responseSearch.isPresent()) {
            hashMap.put("success","exito en la busqueda");
            hashMap.put("responseSearch",responseSearch);
            return ResponseEntity.status(HttpStatus.OK).body(hashMap);
        } else {
            throw  new ResourceNotFoundException("Error en la busqueda --> " +codProducto);
        }
    }

    @DeleteMapping("{codProducto}")
    public ResponseEntity<?> deletebycodProducto(@PathVariable Integer codProducto){
        HashMap<String,Object> resposne=new HashMap<>();
        Producto productoaeliminar=serviceProducto.findByCodproducto(codProducto).orElseThrow(()->new ResourceNotFoundException("producto no encontrado con coddigo "+codProducto));
           if(productoaeliminar!=null){
               resposne.put("mensaje","prodcuto con codigo "+productoaeliminar.getCodProducto() +" ha sidio eliminado");
               serviceProducto.productodeletebyid(codProducto);
               return new ResponseEntity<>(resposne,HttpStatus.OK);
           }else {
               resposne.put("mensaje +","no se encontro el prodcuto de codigo "+codProducto);
               return  new ResponseEntity<>(resposne,HttpStatus.NOT_FOUND);
           }


    }
//usado para encontrar productos para usar el autocomplete de angular
    @GetMapping("/filtrar/{term}")
    @ResponseStatus(HttpStatus.OK)
    public  List<Producto>  autoCompleteProducto(@PathVariable String term){

        return serviceProducto.autocompleteProdcuto(term);
    }

    private  ResponseEntity<?>validacion(BindingResult bindingResult){
        Map<String,String> maperrors=new HashMap<>();
        bindingResult.getFieldErrors().forEach(error->{
            maperrors.put(error.getField(),"El campo "+error.getField()+" "+error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(maperrors);
    }

}
