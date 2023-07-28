import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        Random acak = new Random();

        // Menghasilkan angka acak dari 1 hingga 100
        int angkaTebakan = acak.nextInt(100) + 1; // acak.nextInt(100) akan menampilkan angka 0-99

        int tebakan;
        int percobaan = 0;
        int batasWaktu = 60000; // Batas waktu dalam milidetik (60 detik = 60000 milidetik)

        System.out.println("Selamat datang di permainan Tebak Angka!");
        System.out.println("Saya telah memilih angka antara 1 hingga 100.");
        System.out.println("Anda memiliki 1 menit untuk menebaknya.");

        long waktuMulai = System.currentTimeMillis(); // Catat waktu mulai permainan

        boolean gameOver = false;
        while (!gameOver) {
            // Input tebakan dari pengguna
            System.out.print("Masukkan tebakan Anda (1-100): ");

            try {
                tebakan = masukan.nextInt();

                // Cek apakah tebakan berada dalam rentang yang valid (1-100)
                if (tebakan < 1 || tebakan > 100) {
                    System.out.println("Tebakan harus berada dalam rentang 1 hingga 100.");
                } else {
                    percobaan++; // Menghitung jumlah / counter percobaan tebakan

                    // Cek apakah tebakan terlalu rendah
                    if (tebakan < angkaTebakan) {
                        System.out.println("Tebakan terlalu rendah.");
                    }
                    // Cek apakah tebakan terlalu tinggi
                    else if (tebakan > angkaTebakan) {
                        System.out.println("Tebakan terlalu tinggi.");
                    }
                    // Jika tebakan benar, maka program mengeset gameOver menjadi true
                    else {
                        System.out.println("Selamat, tebakan Anda benar!");
                        System.out.println("Anda berhasil menebak angka " + angkaTebakan + " dalam " + percobaan + " percobaan.");
                        gameOver = true;
                    }
                }
            } catch (InputMismatchException e) {
                // Catch Error jika input tidak sesuai integer
                System.out.println("Masukan tidak valid. Harap masukkan angka.");
                masukan.next(); // Buang masukan yang tidak valid dari buffer
            }

            // Cek apakah batas waktu sudah habis
            long waktuSekarang = System.currentTimeMillis(); // untuk mengembalikan waktu (timestamp) dalam bentuk milidetik
            if (waktuSekarang - waktuMulai >= batasWaktu) {
                // Jika waktu sudah habis, program mengeset gameOver menjadi true
                System.out.println("Waktu habis! Anda belum berhasil menebak angka " + angkaTebakan + ".");
                gameOver = true;
            }
        }
        System.out.println();
        System.out.println("Terima kasih Telah bermain. Sampai jumpa!");
        masukan.close(); // close scanner
    }
}