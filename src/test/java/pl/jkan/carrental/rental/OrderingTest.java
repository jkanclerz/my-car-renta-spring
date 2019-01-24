package pl.jkan.carrental.rental;

import org.junit.Assert;
import org.junit.Test;

public class OrderingTest {
    @Test
    public void rentTheCarBasedOnOrderingData() {
        ReservationRequest reservationInfo = clientProvidedRentalInformation();

        OrderingApi api = thereIsOrderingApi();

        ReservationConfirmation confirmation = api.handleReservation(reservationInfo);

        Assert.assertTrue(
                confirmation.getPaymentUrl()
                        .startsWith("https://sandbox.przelewy24.pl"));
    }

    private OrderingApi thereIsOrderingApi() {
        return new OrderingApi();
    }

    private ReservationRequest clientProvidedRentalInformation() {
        return ReservationRequest.builder()
                .carId("volvo-xc60-1")
                .clientData(ClientData.builder()
                    .email("jakub.kanclerz@gmail.com")
                    .firstName("Jakub")
                    .lastName("Kanclerz")
                    .build())
                .days(7)
                .build();
    }
}