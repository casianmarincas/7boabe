//
//package pizzashop;
//
//import org.junit.Before;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import pizzashop.exception.ServiceException;
//import pizzashop.model.PaymentType;
//import pizzashop.repository.MenuRepository;
//import pizzashop.repository.PaymentRepository;
//import pizzashop.service.PizzaService;
//
//import java.util.stream.Stream;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//@DisplayName("Add payment feature test")
//public class PaymentTest {
//
//
//    @Mock MenuRepository menuRepository;
//    PaymentRepository paymentRepository = new PaymentRepository();
//    private PizzaService pizzaService;
//
//    private static Stream<Arguments> dataInvalid() {
//        return Stream.of(
//                Arguments.of(0, PaymentType.Cash, 52.23),
//                Arguments.of(4, PaymentType.Card, -1),
//                Arguments.of(420, PaymentType.Card, 96),
//                Arguments.of(5, null, 420),
//                Arguments.of(7, PaymentType.Card, -420)
//        );
//    }
//
//    private static Stream<Arguments> dataValid() {
//        return Stream.of(
//                Arguments.of(1, PaymentType.Card, 96),
//                Arguments.of(5, PaymentType.Cash, 0),
//                Arguments.of(3, PaymentType.Cash, 55.23)
//        );
//    }
//
//    @BeforeEach
//    public void mockTests() {
//        pizzaService = new PizzaService(menuRepository, paymentRepository);
//    }
//
//    @ParameterizedTest
//    @MethodSource("dataInvalid")
//    public void testInvalid(int table, PaymentType paymentType, double amount) {
//        Exception ex = assertThrows(ServiceException.class, () -> pizzaService.addPayment(table, paymentType, amount));
//        assertEquals(ex.getMessage(), "invalid payment");
//    }
//
//    @ParameterizedTest
//    @MethodSource("dataValid")
//    public void testValid(int table, PaymentType paymentType, double amount) {
//        int len = paymentRepository.getAll().size();
//        pizzaService.addPayment(table, paymentType, amount);
//        assertEquals(pizzaService.getPayments().size(), len + 1);
//    }
//
//}
