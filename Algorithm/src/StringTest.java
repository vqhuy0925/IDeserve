public class StringTest {
    public static void main(String[] args) {
        String uri = "/api/v1/export/0b294c4e-a793-4dba-a858-3c8c4d8c5a67/pdf";
       String[] result = uri.split("/");
        System.out.println(result[4]);
    }
}
