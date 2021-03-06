public class Main {
    public static void main(String[] argc) {
        try {
            if (argc.length != 1) {
                throw new Exception(String.format("Wrong number of arguments (args.length != 1) args.length = %s", argc.length));
            }
            int year = Integer.parseInt(argc[0]);
            new XMLMaker(year);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}