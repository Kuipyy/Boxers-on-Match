import java.util.Random;

public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    Random random = new Random();

    // constructor method
    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public boolean firstAttacker(Fighter f1, Fighter f2) {
        int getFirst = random.nextInt(2); // random number 0 or 1
        return getFirst == 0; // f1 attacks first if true
    }

    public int Dodge(Fighter f1, Fighter f2) {
        int dodgePoint;
        if (firstAttacker(f1, f2)) {
            dodgePoint = random.nextInt(f1.damage);
        } else {
            dodgePoint = random.nextInt(f2.damage);
        }
        return dodgePoint;
    }

    public boolean getWinner(Fighter f1, Fighter f2) {
        return this.f1.health > this.f2.health;
    }

    public void run() {
        if (isCheck()) {
            while (this.f1.health > 0 && this.f2.health > 0) {
                int dodgePoint = Dodge(f1, f2);
                if (firstAttacker(f1, f2)) {
                    System.out.println(this.f1.name + " attacks with " + this.f1.damage + " damage!");
                    if (this.f2.health > (f2.health - dodgePoint)) {
                        this.f2.health -= (f1.damage - dodgePoint);
                    } else {
                        continue;
                    }
                    System.out.println(this.f2.name + " dodges " + dodgePoint + " damage!");
                } else {
                    System.out.println(this.f2.name + " attacks with " + this.f2.damage + " damage!");
                    if (this.f1.health > (f1.health - dodgePoint)) {
                        this.f1.health -= (f2.damage - dodgePoint);
                    } else {
                        continue;
                    }
                    System.out.println(this.f1.name + " dodges " + dodgePoint + " damage!");
                }
                System.out.print("Health of " + this.f1.name + " : " + this.f1.health + "\nHealth of " + this.f2.name + " : " + this.f2.health);
                System.out.println("\n");
            }

            String winner;
            if (getWinner(f1, f2)) {
                winner = f1.name;
            } else {
                winner = f2.name;
            }

            System.out.printf("The winner of the match is %s%n", winner);

        } else {
            System.out.println("The athletes' weights do not match.");
        }
    }

    public boolean isCheck() {
        return ((this.f1.weight >= minWeight && this.f1.weight <= maxWeight) &&
                (this.f2.weight >= minWeight && this.f2.weight <= maxWeight));
    }

}
