package com.Student_Library_Management_System.Service;
import com.Student_Library_Management_System.Enums.CardStatus;
import com.Student_Library_Management_System.Enums.TransactionStatus;
import com.Student_Library_Management_System.Models.Book;
import com.Student_Library_Management_System.Models.Card;
import com.Student_Library_Management_System.Models.Transactions;
import com.Student_Library_Management_System.Repository.BookRepository;
import com.Student_Library_Management_System.Repository.CardRepository;
import com.Student_Library_Management_System.Repository.TransactionRepository;
import com.Student_Library_Management_System.dtos.IssueBookReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    public String issueBook(IssueBookReqDto issueBookReqDto) throws Exception{
       int bookId = issueBookReqDto.getBookId();
       Book book = bookService.findById(bookId);
       int cardId = issueBookReqDto.getCardId();
       Card card = cardRepository.findById(cardId).get();

       //Create transaction
        Transactions transaction = new Transactions();
        //setting the attributes
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setIssuedOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);

        //successfull or failure
        //do some validations
        if(book == null || book.isIssued()){
                transaction.setTransactionStatus(TransactionStatus.FAILED);
                transactionRepository.save(transaction);
;               throw new Exception("Book is not available");
        }
        if(card == null || card.getCardStatus().equals(CardStatus.ACTIVATED) == false){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not working");
        }
        //success case
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        //card + Book && card + transaction
        List<Transactions> cardTransactions = card.getTransactionsList();
        cardTransactions.add(transaction);
        List<Book> bookList = card.getBooksIssued();
        bookList.add(book);

        //book and the transaction
        List<Transactions> bookTransactions = book.getTransactionsList();
        bookTransactions.add(transaction);
        book.setIssued(true);


        //set the foreign keys and bidirectional mapping
        //only we have to save card
        //card is parent w.r.t to book and transaction
        //if we save card and book duplicate entries will be there.

         cardRepository.save(card);
         return transaction.getTranscationID();
    }

}

