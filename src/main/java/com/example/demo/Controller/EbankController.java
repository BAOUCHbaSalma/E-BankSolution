package com.example.demo.Controller;


import com.example.demo.Model.Compte;
import com.example.demo.Service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EbankController {
    @Autowired
       private CompteService compteSrv;

    @PostMapping("/compte")
    public Compte addCompte(@RequestBody Compte compte){
      return compteSrv.addCompte(compte);
    }

    @RequestMapping("/comptes")
    public ArrayList<Compte> showComptes(){
        return compteSrv.showAllCompte();
    }


}

