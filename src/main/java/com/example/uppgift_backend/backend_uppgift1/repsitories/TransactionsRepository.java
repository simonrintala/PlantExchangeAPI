package com.example.uppgift_backend.backend_uppgift1.repsitories;

import com.example.uppgift_backend.backend_uppgift1.models.Transactions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionsRepository extends MongoRepository<Transactions, String> {
    List<Transactions> findByUsersId(String usersId);
    //Vet inte vad jag gjorde här och transactionscontroller men allt gick sönder och sen gjorde jag såhär och allt började fungera?
}
