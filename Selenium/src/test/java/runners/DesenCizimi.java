package runners;

public class DesenCizimi {
    public static void main(String[] args) {

                int n = 15; // n>= pozitif tek sayı
                int enBuyukSayi = n/2+1;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        // üstteki iki for olusacak matrisin her bir indexinde tek tek gezinmemizi sağlıyor
                        // alttaki k indeksi ise bulunulan yere göre konulacak sayıyı hesaplıyor.
                        for (int k = 0; k <n/2+1 ; k++) {
                            if ((k==i) || (k==j) || (k==n-1-i) || (k==n-1-j) ) {
                                System.out.print((enBuyukSayi-k)+" ");break;
                            };

                        }

                    }
                    System.out.println();
                }
            }
        }

