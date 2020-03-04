public class Hello {
    public static void main(String[] args){
        World myworld = new World();
        System.out.println(World.i);
//        try {
////            Class.forName("DBManager");
////        } catch (ClassNotFoundException e) {
////            e.printStackTrace();
////        }

//DBManager myDBManager = new DBManager();
//DBManager.closeConnection();
        DBManager.openConnection();
        DBManager.printCatalog();
        DBManager.closeConnection();
    }
}
