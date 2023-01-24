package se.me0nly.myJpaOrm1a2;

import se.me0nly.myJpaOrm1a2.data.*;
import se.me0nly.myJpaOrm1a2.model.AppUser;
import se.me0nly.myJpaOrm1a2.model.About;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
public class LetsGo implements CommandLineRunner {

    private final AppUserDAO appUserDAO;
    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;
    private final BookLoanDAO bookLoanDAO;
    private final DetailsDAO detailsDAO;


    @Autowired
    public LetsGo(AppUserDAO appUserDAO, AuthorDAO authorDAO, BookDAO bookDAO, BookLoanDAO bookLoanDAO, DetailsDAO detailsDAO) {
        this.appUserDAO = appUserDAO;
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
        this.bookLoanDAO = bookLoanDAO;
        this.detailsDAO = detailsDAO;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        About about = new About(0, "my.name@me0nly.se", "Me an 0ld Man", LocalDate.parse("1995-02-02"));
        AppUser appUser = new AppUser(0, "0ldman", "never4y", LocalDate.now(), about);
        appUser = new AppUser(0, "new0ldMan", "only_for_me", LocalDate.now(), about);

        AppUser persisted = appUserDAO.create(appUser);

        System.out.println(persisted);
        System.out.println(persisted.getUserDetails());

    }
}
