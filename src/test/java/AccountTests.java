import org.example.DAO.AccountDAO;
import org.example.Service.AccountService;
import org.example.Service.CustomerService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class AccountTests {
    @Mock
    private AccountDAO aDAO;

    @InjectMocks
    private AccountService as;



}
