public class Main {
    public static void main(String[] argc) throws Exception {
        try {
            if(argc.length != 1){
                throw new Exception("Wrong number of arguments (args != 1)");
            }
            int year = Integer.parseInt(argc[0]);
            XMLMaker a = new XMLMaker(year);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}