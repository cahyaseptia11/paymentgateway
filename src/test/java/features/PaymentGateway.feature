Feature: PaymentGateway from payment module

  Scenario: Input PaymentGateway
    Given berada di halaman produk
    When pilih quantity tertentu
    When menekan tombol buy now
    When berada di halaman payment process
    When isi card number "1676898765432546"
    When pilih expiration month
    When pilih expiration year
    When  isi CVV code "121"
    When menekan tombol pay
    Then dapat order id