package com.example.uppgift_backend.backend_uppgift1.controllers;

import com.example.uppgift_backend.backend_uppgift1.models.Transactions;
import com.example.uppgift_backend.backend_uppgift1.repsitories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/transactions")
public class TransactionsController {
    @Autowired
    private TransactionsRepository transactionsRepository;

    //Hämta alla transaktioner
    @GetMapping
    public ResponseEntity<List> getAllTransactions() {
        List<Transactions> transactions = transactionsRepository.findAll();
        return ResponseEntity.ok(transactions);
    }

    //Hämta specifik transaktion
    @GetMapping("/{id}")
    public ResponseEntity<Transactions> getTransactionById(@PathVariable String id) {
        Transactions transaction = transactionsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found"));
        return ResponseEntity.ok(transaction);
    }

    //Uppdatera en transaktion
    @PutMapping("/{id}")
    public ResponseEntity<Transactions> updateTransaction(@PathVariable String id, @RequestBody Transactions transaction) {
        Transactions existingTransaction = transactionsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found"));

        existingTransaction.setTransactionType(transaction.getTransactionType());
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setTransactionStatus(transaction.getTransactionStatus());
        //users/plants borde inte behövas/kunnas bytas på en transaktion även om nåt gått fel. isåfall
        //ta bort och gör om hela transaktionen.

        Transactions updatedTransaction = transactionsRepository.save(existingTransaction);
        return ResponseEntity.ok(updatedTransaction);

    }

    //Hämta alla transaktioner för en specifik användare
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Transactions>> getTransactionByUsersId(@PathVariable String usersId) {
        List<Transactions> transactions = transactionsRepository.findByUsersId(usersId);
        //Vet inte vad jag gjorde här och inteface men allt gick sönder och sen gjorde jag såhär och allt började fungera?
        return ResponseEntity.ok(transactions);
    }

    //Registrera en ny transaktion (byte eller köp)
    @PostMapping
    public ResponseEntity<Transactions> createTransaction(@RequestBody Transactions transaction) {
        if (transaction.getTransactionType().equalsIgnoreCase("TRADE")) { //not case sensitive.
            if (transaction.getPlantsId() == null || transaction.getTradePlantId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid transaction, both parties need plant ID:s to complete a trade.");
            }
            transaction.setTransactionStatus("PENDING"); //If trade


        } else if (transaction.getTransactionType().equalsIgnoreCase("PURCHASE")) {
            if (transaction.getAmount() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid purchase, plant need to have a price");
            }
            transaction.setTransactionStatus("COMPLETED");


        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid transaction type");
        }
        Transactions newTransaction = transactionsRepository.save(transaction);
        return ResponseEntity.ok(newTransaction);
    }

    //Godkänna
    @PostMapping("/{id}/approved")
    public ResponseEntity<Transactions> approveTransaction(@PathVariable String id, @RequestBody String usersId) {
        Transactions transaction = transactionsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found"));

        if (transaction.getTransactionType().equalsIgnoreCase("TRADE")) {
            transaction.setTransactionStatus("APPROVED");
            transactionsRepository.save(transaction);
            return ResponseEntity.ok(transaction);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid transaction type");
        }
    }

    //Genomföra
    @PostMapping("/{id}/Competed")
    public ResponseEntity<Transactions> competeTransaction(@PathVariable String id) {
        Transactions transaction = transactionsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found"));

        if (!transaction.getTransactionType().equalsIgnoreCase("APPROVED")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid transaction type");
        }
        transaction.setTransactionStatus("COMPLETED");
        transactionsRepository.save(transaction);
        return ResponseEntity.ok(transaction);
    }

}
