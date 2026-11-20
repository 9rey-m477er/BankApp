import org.example.DAO.AccountDAO;
import org.example.Model.Account;
import org.example.Service.AccountService;
import org.example.Service.CustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.security.auth.login.AccountNotFoundException;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountTests {
    @Mock
    private AccountDAO aDAO;
    private Account ac = new Account(1,"test","APPROVED",100,"CHECKING");
    private Account ac2 = new Account(2,"test2","APPROVED",0,"SAVING");
    @InjectMocks
    private AccountService as;



    @Test
    void accountCreationSuccess() throws SQLException {
        Account test = as.createAccount("Test Checking", "CHECKING", 3);
        aDAO.addAccount(test,3);
    }

    @Test
    void withdrawTest() throws SQLException {
        as.withdraw(ac,50);
    }
    @Test
    void depositTest() throws SQLException {
        as.deposit(ac,50);
    }

    /*@Test
    void accountNotFound() throws SQLException {
        assertThrows(AccountNotFoundException.class, () -> {
            aDAO.getAccountByID(1000);
        });
    }*/

}
