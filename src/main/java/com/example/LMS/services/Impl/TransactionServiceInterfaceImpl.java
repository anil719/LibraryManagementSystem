package com.example.LMS.services.Impl;

import com.example.LMS.Dto.RequestDto.IssueBookRequestDto;
import com.example.LMS.Dto.RequestDto.ReturnBookRequestDto;
import com.example.LMS.Dto.ResponseDto.IssueBookResponseDto;
import com.example.LMS.Dto.ResponseDto.ReturnBookResponseDto;
import com.example.LMS.entities.Book;
import com.example.LMS.entities.Card;
import com.example.LMS.entities.Transactions;
import com.example.LMS.enums.Status;
import com.example.LMS.enums.TransactionStatus;
import com.example.LMS.repositories.BookRepository;
import com.example.LMS.repositories.CardRepository;
import com.example.LMS.repositories.TransactionRepository;
import com.example.LMS.services.TransactionService;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceInterfaceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        Transactions transactions = new Transactions();
        transactions.setTransactionNum(String.valueOf(UUID.randomUUID()));
        transactions.setIssueOperation(true);
        Card card;
        try{
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transactions.setTransactionStatus(TransactionStatus.FAIL);
            throw new Exception("Card not Valid !!!");
        }

        transactions.setCard(card);


        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transactions.setTransactionStatus(TransactionStatus.FAIL);
            throw new Exception("Invalid bookId !!!");
        }

        transactions.setBook(book);

        if(card.getStatus() != Status.ACTIVE){
            transactions.setTransactionStatus(TransactionStatus.FAIL);
            transactionRepository.save(transactions);
            throw new Exception("Card is not Active !!!");
        }

        if(book.isIssued() == true){
            transactions.setTransactionStatus(TransactionStatus.FAIL);
            transactionRepository.save(transactions);
            throw new Exception("Book is not available !!!");
        }

        transactions.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transactions);
        card.getBookIssued().add(book);
        card.getTransaction().add(transactions);
        cardRepository.save(card);              //it will save card, book, status

        //prepare Response Dto

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionNumber(transactions.getTransactionNum());
        issueBookResponseDto.setTransactionStatus(transactions.getTransactionStatus());

        return issueBookResponseDto;

    }

    //return book;

    @Override
    public ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestDto) throws Exception {
        Transactions transactions = new Transactions();
        transactions.setTransactionNum(String.valueOf(UUID.randomUUID()));
        transactions.setIssueOperation(false);
        Card card;
        try{
            card = cardRepository.findById(returnBookRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transactions.setTransactionStatus(TransactionStatus.FAIL);
            throw new Exception("Card not Valid !!!");
        }

        transactions.setCard(card);


        Book book;
        try{
            book = bookRepository.findById(returnBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transactions.setTransactionStatus(TransactionStatus.FAIL);
            throw new Exception("Invalid bookId !!!");
        }
        transactions.setBook(book);

        if(card.getStatus() != Status.ACTIVE){
            transactions.setTransactionStatus(TransactionStatus.FAIL);
            transactionRepository.save(transactions);
            throw new Exception("Card is not Active !!!");
        }

        if(book.isIssued() == false || !book.getCard().equals(card)){
            transactions.setTransactionStatus(TransactionStatus.FAIL);
            transactionRepository.save(transactions);
            throw new Exception("Book is available , its not issued from us !!!");
        }

        transactions.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(false);
        book.setCard(null);
        book.getTransactionList().add(transactions);
        card.getBookIssued().remove(book);
        card.getTransaction().add(transactions);
        cardRepository.save(card);              //it will save card, book, status

        //prepare Response Dto

        ReturnBookResponseDto returnBookResponseDto = new ReturnBookResponseDto();
        returnBookResponseDto.setBookName(book.getTitle());
        returnBookResponseDto.setTransactionNumber(transactions.getTransactionNum());
        returnBookResponseDto.setTransactionStatus(transactions.getTransactionStatus());

        return returnBookResponseDto;

    }
}
