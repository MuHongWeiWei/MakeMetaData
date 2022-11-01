public class Create {
    public static void main(String[] args) {
        for (int i = 0; i < 8393; i++) {
            CreateJson createJson = new CreateJson(i);
            createJson.setData( "SSSC", "SSSC" + " #" + i, i);
            createJson.build();
        }
    }
}
