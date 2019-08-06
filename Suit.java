public enum Suit {

    Club, Diamond, Heart, Spade;

    @Override
    public String toString() {
        return name() + "s";
    }
}