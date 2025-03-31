import java.util.Scanner;

public class Story {
    // atribut buat nyimpen scene awal, karakter pemain, scanner buat input, dan status karakternya
    private Scene startScene;
    private Character player;
    private Scanner scanner;
    private int oldHealth;  // Menyimpan health sebelum perubahan
    private int oldXP;      // Menyimpan XP sebelum perubahan

    // konstruktor buat bikin objek Story baru
    public Story(Scene startScene, Character player) {
        this.startScene = startScene;
        this.player = player;
        this.scanner = new Scanner(System.in);
        this.oldHealth = player.getHealth();
        this.oldXP = player.getXP();
    }

    // method buat mulai game
    public void start() {
        System.out.println("\n======================================");
        System.out.println("Halo " + player.getName() + ", perjalananmu di Bojongsoang akan dimulai.");
        System.out.println("--------------------------------------");
        System.out.println("Ketik 'INFO' untuk melihat statusmu.");
        System.out.println("======================================");
        play();  // mulai game
    }

    // method buat jalanin gamenya
    public void play() {
        Scene currentScene = startScene;
        while (true) {
            // cek kalo health pemain udah abis
            if (player.getHealth() <= 0) {
                // langsung gamenya selesai
                currentScene.displayScene();  // deskripsi scene terakhir
                displayGameOver();            // pesan game over
                break;                        // Keluar dari loop
            }

            // buat nampilin scene saat ini
            currentScene.displayScene();
            
            // cek scene yang saat ini adalah scene akhir
            if (currentScene.isEndScene()) {
                System.out.println("\n======================================");
                System.out.println("Perjalananmu di Bojongsoang selesai sampai disini");
                System.out.println("Total XP : " + player.getXP());
                System.out.println("Health : " + player.getHealth());
                System.out.println("Item : " + (player.getItem().isEmpty() ? "-" : player.getItem()));
                System.out.println("======================================");
                break;  // Keluar dari loop
            }

            // input opsi dari user
            System.out.print("\nPilih opsi : ");
            String choice = scanner.nextLine().trim();
            
            // kalo inputnya == INFO
            if (choice.equalsIgnoreCase("INFO")) {
                displayCharacterInfo();  // informasi karakter
            } else {
                // simpen status sebelum ada perubahan
                oldHealth = player.getHealth();
                oldXP = player.getXP();
                
                // prosesing pilihan user
                Scene nextScene = currentScene.makeChoice(choice, player);
                if (nextScene != null) {
                    displayImpact();     // dampak dari pilihan user 
                    currentScene = nextScene;  // pindah ke scene berikutnya
                } else {
                    // pesan error kalo pilihan ga valid
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    System.out.println("\n======================================");
                }
            }
        }
        scanner.close();  // tutup scanner abis gamenya selesai
    }

    // method buat nampilin informasi karakter
    private void displayCharacterInfo() {
        System.out.println("\n======================================");
        System.out.println("Informasi Kamu");
        System.out.println("Nama karaktermu : " + player.getName());
        System.out.println("Health : " + player.getHealth());
        System.out.println("XP : " + player.getXP());
        System.out.println("Item : " + (player.getItem().isEmpty() ? "-" : player.getItem()));
        System.out.println("======================================");
    }

    // method buat nampilin dampak dari pilihan user
    private void displayImpact() {
        System.out.println("\n======================================");
        
        // hitung trus nampilin perubahan health
        int healthChange = player.getHealth() - oldHealth;
        if (healthChange > 0) {
            System.out.println("Health : +" + healthChange + " poin");
        } else if (healthChange < 0) {
            System.out.println("Health : " + healthChange + " poin");
        } else {
            System.out.println("Health tidak berubah");
        }

        // hitung trus nampilin perubahan xp
        int xpChange = player.getXP() - oldXP;
        if (xpChange > 0) {
            System.out.println("XP : +" + xpChange + " poin");
        } else if (xpChange < 0) {
            System.out.println("XP : " + xpChange + " poin");
        } else {
            System.out.println("XP tidak berubah");
        }

        // nampilin status karakter saat ini
        System.out.println("\nStatus karaktermu :");
        System.out.println("Health : " + player.getHealth());
        System.out.println("XP : " + player.getXP());
        System.out.println("======================================");
        System.out.println("");
    }

    // method buat nampilin pesan game over
    private void displayGameOver() {
        System.out.println("\n======================================");
        System.out.println("GAME OVER");
        System.out.println("Health kamu sudah habis. Petualangan berakhir...");
        System.out.println("Total XP yang kamu dapatkan: " + player.getXP());
        System.out.println("======================================");
    }
}
