
class Player {
    private static Player instance;

    private Player() {
        /* Private constructor to prevent instantiation
        -----------------
                --------------
                        -------------
        */
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }
}