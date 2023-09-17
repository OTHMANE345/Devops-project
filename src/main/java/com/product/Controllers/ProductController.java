package com.product.Controllers;


import com.product.Service.ProductServices;
import com.product.Wrapper.Productwrapper;
import com.product.Wrapper.productwrapperfordisplay;
import com.product.modules.Product;
import com.product.utils.apputils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping(path = "/product")
@RestController
public class ProductController {

    @Autowired
    ProductServices productServices;
    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewProduct(@ModelAttribute Productwrapper requestMap){
        try {
            return productServices.addNewProduct(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return apputils.getResponseEntity("Something went wrong in controller", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping(path = "/get")
    public ResponseEntity<List<Product>> getAllProducts(){
        try {
            return productServices.getAllProducts();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(path = "/show")
    public ResponseEntity<productwrapperfordisplay> showProduct(@RequestBody(required = true) Map<String,String> requestMap){
        try {
            return productServices.showProduct(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new productwrapperfordisplay(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<String> updateNewProduct(@RequestBody(required = true) Map<String,String> requestMap){
        try {
            return productServices.updateNewProduct(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return apputils.getResponseEntity("Something went wrong in controller", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<String> deleteNewProduct(@RequestBody(required = true) Map<String,String> requestMap){
        try {
            return productServices.deleteNewProduct(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return apputils.getResponseEntity("Something went wrong in controller", HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
