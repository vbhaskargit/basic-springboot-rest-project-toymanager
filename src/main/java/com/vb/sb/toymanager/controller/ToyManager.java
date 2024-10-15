package com.vb.sb.toymanager.controller;

import com.vb.sb.toymanager.store.ToyStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/toys")
public class ToyManager {

    @Autowired
    ToyStorage toyStorage;

    @GetMapping("/available")
    public List<String> availableToys() {
        return toyStorage.getAllToyNames();
    }
}