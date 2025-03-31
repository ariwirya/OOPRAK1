public class Character {
    // atribut buat informasi karakter
    private String name;    
    private int health;     
    private int XP;        
    private String item;   
    
    // konstruktor buat karakter baru
    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.XP = 0;           // xp awal = 0
        this.item = "Voucher Bengkel";  // Item awal = Voucher Bengkel
    }

    // method buat kasi damage karakter
    public void takeDamage(int damage) { 
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0; // biar healthnya ga negatif
        }
    }

    // method buat nambah xp karakter
    public void addXP(int additionalXP) { 
        this.XP += additionalXP;
    }

    // getter buat dapet nama karakter
    public String getName() { 
        return name;
    }

    // getter buat health karakter
    public int getHealth() { 
        return health;
    }

    // getter buat xp karakter
    public int getXP() {
        return XP;
    }

    // getter buat dapet itemnya karakter
    public String getItem() { 
        return item;
    }

    // getter buat ngubah item karakter
    public void setItem(String item) {
        this.item = item;
    }

    // method buat pake item Voucher Bengkel
    public void useItem() {
        if (item.equals("Voucher Bengkel")) {
            item = ""; // item dihapus abis dipake
        } else {
            System.out.println("Item tidak dapat digunakan!");
        }
    }
}