public class Main {

    public static void main(String[] args) {
        // todo g
        //Drawer drawer = new Drawer(new Integer(37));
        //System.out.println(drawer.getType());
        //Drawer stringDrawer = new Drawer("XP");
        //System.out.println(stringDrawer.getType());

        Drawer usefulDrawer = new Drawer();
        usefulDrawer.setType(new Integer(42));
        System.out.println(usefulDrawer.getType() instanceof  Integer);
        usefulDrawer.setType("Ohh Yeah");
        System.out.println(usefulDrawer.getType() instanceof String);

    }
}
