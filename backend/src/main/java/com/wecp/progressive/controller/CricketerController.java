package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Cricketer;
import com.wecp.progressive.service.impl.CricketerServiceImplJdbc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
// @RestController
public class CricketerController {
    // private CricketerServiceImplJdbc cricketerServiceImplJdbc;

    public ResponseEntity<List<Cricketer>> getAllCricketers() throws SQLException {
        return null;
    }

    public ResponseEntity<Cricketer> getCricketerById(int cricketerId)throws SQLException {
        return null;
    }

    public ResponseEntity<Integer> addCricketer(Cricketer cricketer)throws SQLException {
        return null;
    }

    public ResponseEntity<Void> updateCricketer(int cricketerId, Cricketer cricketer)throws SQLException {
        return null;
    }

    public ResponseEntity<Void> deleteCricketer(int cricketerId)throws SQLException {
        return null;
    }

    public ResponseEntity<List<Cricketer>> getCricketersByTeam(int teamId)throws SQLException {
        return null;
    }
}