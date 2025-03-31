import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner buat input dari user
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=====================================================================");
        System.out.println(" Game Petualangan Berbasis Teks : 'Just a Normal Day in Bojongsoang' ");
        System.out.println("=====================================================================");
        
        // input nama karakter dari user
        System.out.print("Masukkan nama karaktermu : ");
        String playerName = scanner.nextLine();

        // buat objek karakter pake nama yang diinputin user, health 100
        Character player = new Character(playerName, 100);

        // SCENE ENDING
        Scene badEnding2A8C = new Scene("Kamu kecelakaan, coba jangan kebanyakan gerakan tambahan :D ");  
        Scene badEnding6BC = new Scene("Kamu digebukin warga, lagian pake aneh-aneh segala dah :D ");  
        Scene badEnding9AB = new Scene("Kamu kesetrum, jangan main-main sama listrik deket air yee :D ");  
        Scene badEnding10C = new Scene("Kamu kelamaan, barang-barangmu jadi rusak karena terendam kelamaan, makanya jangan males-males :D ");  
        Scene goodEnding = new Scene("Kamu berhasil menyelamatkan barang-barangmu dan kamu berhasil selamat dari kerugian besar :D "); 

        // Scene 10
        Scene scene10 = new Scene(
            "Listrik di kos kamu telah berhasil dimatikan",
            "Lanjut amanin barang-barang", goodEnding, 0, 15,  // -> goodEnding (ending barang selamat)
            "Lanjut bersih-bersih", goodEnding, 0, 20,         // -> goodEnding (ending barang selamat)
            "Leha-leha dulu istirahat", badEnding10C, 100, 0   // -> badEnding10C (ending barang rusak)
        );

        // Scene 9
        Scene scene9 = new Scene(
            "Kamu berhasil masuk ke dalam kamar kosmu, apa yang akan kamu lakukan terlebih dahulu?",
            "Ambil barang elektronik", badEnding9AB, 100, 0,  // -> badEnding9AB (ending kesetrum)
            "Ambil baju-baju", badEnding9AB, 100, 0,          // -> badEnding9AB (ending kesetrum)
            "Matikan listrik", scene10, 0, 10                 // -> scene 10
        );

        // Scene 8
        Scene scene8 = new Scene(
            "Kamu berhasil sampai depan kos kamu yang sudah tenggelam banjir tetapi pintunya terkunci",
            "Dobrak pintunya", scene9, 0, 15,                             // -> scene 9
            "Masuk lewat jendela", scene9, 0, 10,                         // -> scene 9
            "Panjat lewat tembok trus ke rooftop", badEnding2A8C, 100, 0  // -> badEnding2A8C (ending kecelakaan)
        );

        // Scene 7
        Scene scene7 = new Scene(
            "Motor kamu sudah berhasil diperbaiki dan kamu ingin lanjut ke kos",
            "Naik perahu bareng warga", scene8, 0, 15,                                          // -> scene 8
            "Nitip motor di bengkel trus trobos banjir jalan kaki", scene8, 0, 5,               // -> scene 8
            "Parkir motor di luar area banjir yang deket trus lanjut jalan kaki", scene8, 0, 5  // -> scene 8
        );

        // Scene 6
        Scene scene6 = new Scene(
            "Motor kamu sudah diperbaiki dan diminta uang service",
            "Bayar pake voucher bengkel", scene7, 0, 15,                           // -> scene 7
            "Kabur", badEnding6BC, 100, 0,                                         // -> badEnding6BC (ending digebukin warga)
            "Nyolot minta gratis soalnya abis kena bencana", badEnding6BC, 100, 0  // -> badEnding6BC (ending digebukin warga)
        );

        // Scene 5
        Scene scene5 = new Scene(
            "Motor kamu jadi rusak dan harus segera ditangani",
            "Minta tolong orang bantu dorong ke bengkel", scene6, 0, 5,    // -> scene 6
            "Dorong motor sendiri ke bengkel", scene6, 0, 10,              // -> scene 6
            "Benerin motornya sendiri", scene7, 0, 50                      // -> scene 7
        );

        // Scene 4
        Scene scene4 = new Scene(
            "Motor kamu jadi mati di tengah jalan karena air masuk ke dalam mesin",
            "Lanjut menerobos banjirnya bawa motor", scene5, 10, 0,                                     // -> scene 5
            "Putar balik dan parkir motor di luar area banjir trus lanjut jalan kaki", scene8, 0, 10,   // -> scene 8
            "Coba nyalain mesin motornya", scene5, 20, 0                                                // -> scene 5
        );

        // Scene 3
        Scene scene3 = new Scene(
            "Kamu berhasil masuk daerah Sukabirus tapi ternyata daerahnya kebanjiran dan ternyata kosmu kena banjir",
            "Parkir motor dulu trus lanjut menerobos banjir", scene8, 0, 10,  // -> scene 8
            "Menerobos banjir pake motor", scene4, 10, 0,                     // -> scene 4
            "Naik perahu bareng warga", scene8, 0, 15                         // -> scene 8
        );

        // Scene 2
        Scene scene2 = new Scene(
            "Jalan menuju arah Sukabirus ternyata ditutup karena jembatannya jebol",
            "Parkour pake motor", badEnding2A8C, 100, 0,        // -> badEnding2A8C (ending kecelakaan)
            "Putar balik lewat Jalan Sukapura", scene3, 0, 10,  // -> scene 3
            "Putar balik lewat gapura Telyu", scene3, 0, 10     // -> scene 3
        );

        // Scene 1
        Scene scene1 = new Scene(
            "Kamu abis belanja di transmart dan dapet gratis voucher bengkel, trus sekarang akan pulang ke kosmu di Sukabirus,"
            + " kamu mau pulang ke kos lewat jalan mana?",
            "Lewat Jalan Sukapura", scene3, 0, 10,           // -> scene 3
            "Lewat gapura Telyu", scene3, 0, 10,             // -> scene 3
            "Lewat Jalan Raya Bojongsoang", scene2, 10, 0    // -> scene 2
        );

        // buat objek story dan mulai game
        Story story = new Story(scene1, player);
        story.start();

        // tutup scanner abis gamenya selesai
        scanner.close();
    }
}
