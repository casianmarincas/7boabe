package pizzashop;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;
import pizzashop.service.PizzaService;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class PizzaServiceTest {

    PaymentRepository paymentRepository = mock(PaymentRepository.class);

    private PizzaService pizzaService = new PizzaService(mock(MenuRepository.class), paymentRepository);

    @Test
    public void testGetTotalAmount_null() {
        doReturn(null).when(paymentRepository).getAll();
        assertEquals(0.0, pizzaService.getTotalAmount(PaymentType.Card));
    }

    @Test
    public void testGetTotalAmount_emptyList() {
        doReturn(new ArrayList<>()).when(paymentRepository).getAll();
        assertEquals(0.0, pizzaService.getTotalAmount(PaymentType.Card));
    }

    @Test
    public void testGetTotalAmount_valuesInList() {
        doReturn(new ArrayList<>(Arrays.asList(new Payment(1, PaymentType.Card, 12),
                new Payment(2, PaymentType.Card, 15)))).when(paymentRepository).getAll();
        assertEquals(27.0, pizzaService.getTotalAmount(PaymentType.Card));
    }
}
