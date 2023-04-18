package com.example.LMS.services.Impl;

import com.example.LMS.Dto.RequestDto.AddBookRequestDto;
import com.example.LMS.Dto.ResponseDto.AuthorBooksListResponseDto;
import com.example.LMS.Dto.ResponseDto.GetBookResponseDto;
import com.example.LMS.entities.Author;
import com.example.LMS.entities.Book;
import com.example.LMS.repositories.AuthorRepository;
import com.example.LMS.repositories.BookRepository;
import com.example.LMS.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;
    public String addBook(AddBookRequestDto addBookRequestDto) throws Exception {
        //want to check books author exists or not

        Author author;
        try{
            author = authorRepository.findById(addBookRequestDto.getAuthorId()).get();
        }
        catch (Exception e){
            throw new Exception("Author not present");
        }

        Book book = new Book();
        book.setTitle(addBookRequestDto.getTitle());
        book.setGenre(addBookRequestDto.getGenre());
        book.setNoOfPages(addBookRequestDto.getNoOfPages());
        book.setPrice(addBookRequestDto.getPrice());
        author.getBooks().add(book);
        book.setAuthor(author);

        authorRepository.save(author);
        return "Book Added Successfully";
    }

    public List<GetBookResponseDto> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        List<GetBookResponseDto> allBooks = new ArrayList<>();
        for(Book b : bookList){
            GetBookResponseDto getBookResponseDto = new GetBookResponseDto();
            getBookResponseDto.setTitle(b.getTitle());
            getBookResponseDto.setGenre(b.getGenre());
            getBookResponseDto.setAuthor(b.getAuthor().getName());
            getBookResponseDto.setId(b.getId());
            getBookResponseDto.setPrice(b.getPrice());
            allBooks.add(getBookResponseDto);
        }
        return allBooks;
    }

    @Override
    public String findNoOfBooksByAuthor(int id){
        int ans = authorRepository.findById(id).get().getBooks().size();

        return "There are a total of " + ans + " Books written by " +  authorRepository.findById(id).get().getName()  ;
    }


}
