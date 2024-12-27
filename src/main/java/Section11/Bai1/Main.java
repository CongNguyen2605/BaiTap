package Section11.Bai1;

public class Main {
    public enum FoodMenu{
       CAFE(1,"Cafe"),
        MILK_TEA(2, "Milk Tea");

            private final int id;
            private final String name;

        FoodMenu(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
    public static void main(String[] args) {
        for (FoodMenu foodMenu : FoodMenu.values()){
            System.out.println(foodMenu.getId() + "-" + foodMenu.getName());
        }
    }
}
