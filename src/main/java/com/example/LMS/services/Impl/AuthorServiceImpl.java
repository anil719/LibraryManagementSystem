package com.example.LMS.services.Impl;

import com.example.LMS.Dto.RequestDto.AddAuthorRequestDto;
import com.example.LMS.Dto.ResponseDto.AuthorResponseDto;
import com.example.LMS.Dto.ResponseDto.AuthorsWithGivenAgeResponseDto;
import com.example.LMS.Dto.ResponseDto.DeleteAuthorByIdResponseDto;
import com.example.LMS.Dto.ResponseDto.GetBookResponseDto;
import com.example.LMS.entities.Author;
import com.example.LMS.entities.Book;
import com.example.LMS.repositories.AuthorRepository;
import com.example.LMS.repositories.BookRepository;
import com.example.LMS.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public String addAuthor(AddAuthorRequestDto addAuthorRequestDto) {
        Author author = new Author();
        author.setName(addAuthorRequestDto.getName());
        author.setAge(addAuthorRequestDto.getAge());
        author.setEmail(addAuthorRequestDto.getEmail());
        author.setBooks(new ArrayList<Book>());
        authorRepository.save(author);
        return "Author Added Successfully";
    }

    @Override
    public DeleteAuthorByIdResponseDto deleteAuthor(int id) throws Exception {
        Author author;
        try{
            author = authorRepository.findById(id).get();
            authorRepository.delete(author);
            DeleteAuthorByIdResponseDto deleteAuthorByIdResponseDto = new DeleteAuthorByIdResponseDto();
            deleteAuthorByIdResponseDto.setName(author.getName());
            deleteAuthorByIdResponseDto.setAge(author.getAge());
            deleteAuthorByIdResponseDto.setEmail(author.getEmail());
            deleteAuthorByIdResponseDto.setStatus("Author Deleted");
            return deleteAuthorByIdResponseDto;
        }
        catch (Exception e){
            throw new Exception("AuthorId not Found");
        }
    }

    @Override
    public List<GetBookResponseDto> getAllBooksByAuthorId(int id) throws Exception {
        Author author ;
        try{
            author = authorRepository.findById(id).get();
            List<Book> authorBooks = author.getBooks();
            List<GetBookResponseDto> ans = new ArrayList<>();
            for(Book book : authorBooks) {
                GetBookResponseDto getBookResponseDto = new GetBookResponseDto();
                getBookResponseDto.setTitle(book.getTitle());
                getBookResponseDto.setGenre(book.getGenre());
                getBookResponseDto.setAuthor(book.getAuthor().getName());
                getBookResponseDto.setId(book.getId());
                getBookResponseDto.setPrice(book.getPrice());
                ans.add(getBookResponseDto);
            }
            return ans;
        }
        catch (Exception e){
            throw new Exception("AuthorId_is not valid");
        }
    }

    @Override
    public AuthorResponseDto getAuthorByEmail(String email) {
        Author author = authorRepository.getAuthorByEmail(email);

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setId(author.getId());
        authorResponseDto.setEmail(author.getEmail());
        authorResponseDto.setAge(author.getAge());
        return authorResponseDto ;
    }

    @Override
    public List<AuthorResponseDto> getAuthorsWithGivenAge(int age) {
        List<Author> authors = authorRepository.findAll();
        List<Author> authorsWithRequiredAge = new ArrayList<>();
        for(Author author : authors){
            if(author.getAge() == age) authorsWithRequiredAge.add(author);
        }

        List<AuthorResponseDto> ans = new ArrayList<>();
        for(Author author : authorsWithRequiredAge){
            AuthorResponseDto authorResponseDto = new AuthorResponseDto();
            authorResponseDto.setName(author.getName());
            authorResponseDto.setAge(author.getAge());
            authorResponseDto.setEmail(author.getEmail());
            authorResponseDto.setId(author.getId());
            ans.add(authorResponseDto);
        }
        return ans;
    }
}
