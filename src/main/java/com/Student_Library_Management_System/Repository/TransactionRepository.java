package com.Student_Library_Management_System.Repository;

import com.Student_Library_Management_System.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
    Transactions findByTranscationID(String transcationID);

    @Query(value = "select * from transactions_table t where t.book_id = :bookId and t.card_id = :cardId and t.is_issued_operation = true", nativeQuery = true)
    List<Transactions> listForBookAndCard(String bookId, String cardId);
}
