public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;



    public Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    void run() {
        if (isCheck()) {
            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("====== Yeni ROUND =======");
                if (firstToAttack()== true){
                    this.f2.health = this.f1.hit(f2);
                    System.out.println(this.f2.name + "'s Health = " + this.f2.health);
                    System.out.println(this.f1.name + "'s Health =  " + this.f1.health);
                    if (isWin()){
                        break;
                    }
                } else {
                    this.f1.health = this.f2.hit(this.f1);
                    System.out.println(this.f1.name + "'s Health =  " + this.f1.health);
                    System.out.println(this.f2.name + "'s Health = " + this.f2.health);
                    if (isWin()){
                        break;
                    }
                }

            }

        } else {
            System.out.println("Sporcuların sikletleri uymuyor.");
        }
    }

    boolean isCheck() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) &&
                (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " Müsabakayı kazandı");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " Müsabakayı kazandı");
            return true;
        }
        return false;

    }
    boolean firstToAttack(){
        int number = (int) Math.random()*100;
        if (number <= 50){
            return true;
        }
        return false;
    }


}

