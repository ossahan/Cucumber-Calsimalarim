Feature: US1011 web tablosundaki istenen sutunu yazdirma

  Scenario: TC16 kullanici sutun basligi ile liste alabilmeli
 @guru
  Given  kullanici "guruUrl" anasayfasinda
    And cookies sorulursa kabul eder
    And "Prev Close (Rs)", sutunundaki tum degerleri yazdirir
    Then sayfayi kapatir
