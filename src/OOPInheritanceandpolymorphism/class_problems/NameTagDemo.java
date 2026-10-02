package OOPInheritanceandpolymorphism.class_problems;

public class NameTagDemo {
    public static class NameTag {
        private final String firstName;
        private final String lastNameInitial;

        public NameTag(String fullName) {
            String[] parts = fullName.trim().split(" ");
            this.firstName = parts[0];
            this.lastNameInitial = parts[1].substring(0, 1) + ".";
        }

        public String getNickname() {
            return firstName + " " + lastNameInitial;
        }
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("Nickname: " + tag.getNickname()); // Maria G.
    }
}
