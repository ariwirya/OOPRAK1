public class Scene {
    // atribut buat nyimpen informasi scene
    private String description;     // deskripsi scene
    private String choiceA, choiceB, choiceC;  // pilihan-pilihan
    private Scene nextSceneA, nextSceneB, nextSceneC;  // scene buat tiap pilihan
    private int damageA, damageB, damageC;     // damage buat tiap pilihan
    private int XPA, XPB, XPC;     // xp dari tiap pilihan
    private boolean isEndScene;     // status scene (apakah scene ini adalah scene akhir)

    // konstruktor buat scene
    public Scene(String description, String choiceA, Scene nextSceneA, int damageA, int XPA,
                 String choiceB, Scene nextSceneB, int damageB, int XPB,
                 String choiceC, Scene nextSceneC, int damageC, int XPC) {
        this.description = description;
        this.choiceA = choiceA;
        this.nextSceneA = nextSceneA;
        this.damageA = damageA;
        this.XPA = XPA;
        this.choiceB = choiceB;
        this.nextSceneB = nextSceneB;
        this.damageB = damageB;
        this.XPB = XPB;
        this.choiceC = choiceC;
        this.nextSceneC = nextSceneC;
        this.damageC = damageC;
        this.XPC = XPC;
        this.isEndScene = false;  // false soalnya ini scene biasa bukan scene akhir (ending)
    }

    // konstruktor buat scene akhir (ending)
    public Scene(String description) {
        this.description = description;
        this.isEndScene = true;    // true soalnya ini scene akhir (ending)
        this.choiceA = null;       // gaada pilihan A, B, C soalnya cuma deskripsi aja
        this.choiceB = null;
        this.choiceC = null;
    }

    // method buat nampilin scene sama pilihannya
    public void displayScene() {
        System.out.println(description);
        if (choiceA != null && !choiceA.isEmpty()) System.out.println("A: " + choiceA);
        if (choiceB != null && !choiceB.isEmpty()) System.out.println("B: " + choiceB);
        if (choiceC != null && !choiceC.isEmpty()) System.out.println("C: " + choiceC);
    }

    // method buat proses pilihan user
    public Scene makeChoice(String choice, Character player) {
        // kalo ini scene akhir, gaada pilihan yang bisa dipilih
        if (isEndScene) {
            return null;
        }

        choice = choice.toUpperCase();
        switch (choice) {
            case "A":
                player.takeDamage(damageA);
                player.addXP(XPA);
                // buat pilihan di scene yang ada voucher bengkelnya
                if (choiceA.contains("voucher bengkel") && player.getItem().equals("Voucher Bengkel")) {
                    player.useItem();
                }
                return nextSceneA;
            case "B":
                player.takeDamage(damageB);
                player.addXP(XPB);
                return nextSceneB;
            case "C":
                player.takeDamage(damageC);
                player.addXP(XPC);
                return nextSceneC;
            default:
                return null;  // pilihan yang ga valid
        }
    }

    // method buat ngecek scene ini adalah scene akhir
    public boolean isEndScene() {
        return isEndScene;
    }

    // getter buat dapetin deskripsi scene
    public String getDescription() {
        return description;
    }

    // getter buat dapetin scene abis pilih A
    public Scene getNextSceneA() {
        return nextSceneA;
    }

    // getter buat dapetin scene abis pilih B
    public Scene getNextSceneB() {
        return nextSceneB;
    }

    // getter buat dapetin scene abis pilih C
    public Scene getNextSceneC() {
        return nextSceneC;
    }

    // getter buat dapetin opsi A
    public String getChoiceA() {
        return choiceA;
    }

    // getter buat dapetin opsi B
    public String getChoiceB() {
        return choiceB;
    }

    // getter buat dapetin opsi C
    public String getChoiceC() {
        return choiceC;
    }
}
