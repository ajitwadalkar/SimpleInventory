package com.demo.mvc.controller;

import com.demo.mvc.repository.inventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class InventoryController {

    @Autowired
    inventoryRepo inventoryrepo;

    @GetMapping("/getcount")
    public long findCount() {
        return inventoryrepo.findAll().size();
    }

    @GetMapping("/findbyupa/{upa}")
    public String getByUpa(@PathVariable(value = "upa") String upa) {
        return inventoryrepo.searchByUpa(upa);
    }

    @GetMapping("/getlastmodifieddate")
    public String getLastUpdateDate() {
        return inventoryrepo.getLastDate();
    }

//    @PostMapping("/uploadcsv")
    @RequestMapping(value="/uploadcsv", method = { RequestMethod.POST, RequestMethod.GET })
    public String uploadCSVData(@RequestParam("file") MultipartFile file) {
        {
            String tempPath = "/home/phoenix/tempfiles/"+file.getOriginalFilename();
            try {
                file.transferTo(new File(tempPath));
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }

            try{

                inventoryrepo.uploadData(tempPath);
            }catch (Exception e)
            {
                System.out.println("Post Successful");
            }

        }


        return "Data posted successfully.. <a href='http://localhost:8080/home'>Click here</a> to go back..";
    }
}
