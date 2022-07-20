package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author ken = new Author("Ken", "Follet");
        Book pillarsOfTheEarth = new Book("The pillars of the earth", "123123");
        ken.getBooks().add(pillarsOfTheEarth);
        pillarsOfTheEarth.getAuthors().add(ken);
        authorRepository.save(ken);
        bookRepository.save(pillarsOfTheEarth);

        Author stephen = new Author("Stephen", "King");
        Book walkOrDie = new Book("Walk or die", "123124");
        stephen.getBooks().add(walkOrDie);
        walkOrDie.getAuthors().add(stephen);
        authorRepository.save(stephen);
        bookRepository.save(walkOrDie);

        Publisher larousse = new Publisher("Larousse","Paris");
        publisherRepository.save(larousse);

        System.out.println("Number of editor: "+publisherRepository.count());
        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: "+bookRepository.count());

    }
}
