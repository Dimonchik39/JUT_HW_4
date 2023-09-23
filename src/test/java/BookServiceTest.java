import org.example.book.Book;
import org.example.book.BookRepository;
import org.example.book.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    @Test
    public void findBookByIdTest() {
        BookRepository mockBookRepository = mock(BookRepository.class);
        when(mockBookRepository.findById("666")).thenReturn(new Book("666", "Тень сурикена", "Якано Мусирази"));

        BookService bookService = new BookService(mockBookRepository);
        Book result = bookService.findBookById("666");
        assertEquals("Тень сурикена", result.getTitle());
        assertEquals("Якано Мусирази", result.getAuthor());
    }

    @Test
    public void findAllBooksTest() {
        BookRepository mockBookRepository = mock(BookRepository.class);
        when(mockBookRepository.findAll()).thenReturn(List.of(new Book("666", "Тень сурикена", "Якано Мусирази"),
                new Book("5", "Скрип на ветру", "Джорж Кайлберт")));

        BookService bookService = new BookService(mockBookRepository);
        List<Book> result = bookService.findAllBooks();
        assertEquals(2, result.size());
        assertEquals("Тень сурикена", result.get(0).getTitle());
        assertEquals("Якано Мусирази", result.get(0).getAuthor());
        assertEquals("Скрип на ветру", result.get(1).getTitle());
        assertEquals("Джорж Кайлберт", result.get(1).getAuthor());
    }
}