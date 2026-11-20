import org.example.DAO.AccountDAO;
import org.example.DAO.CustomerDAO;
import org.example.Model.Account;
import org.example.Model.Customer;
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
public class CustomerTests {
    @Mock
    private CustomerDAO cDAO;
    private Customer c = new Customer(1,"tester","password");
    @InjectMocks
    private CustomerService cs;



    @Test
    void customerCreationSuccess() throws SQLException {
        cs.createCustomer("test", "password");
    }
    @Test
    void loginSuccess() throws SQLException {
        cs.login("tester", "password");
    }


    /*@Test
    void customerNotFound() throws SQLException {
        assertThrows(AccountNotFoundException.class, () -> {
            cDAO.
        });*/
    }