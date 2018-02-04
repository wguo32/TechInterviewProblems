class ZipNumbers {
    public static String zipNum(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }

        char[] result = new char[num1.length() + num2.length()];
        int index = 0;
        for (int i = 0; i < num1.length() || i < num2.length(); i++) {
            if (i < num1.length()) {
                result[index++] = num1.charAt(i);
            }
            if (i < num2.length()) {
                result[index++] = num2.charAt(i);
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String num1 = "100000";
        String num2 = "5678";
        System.out.println(zipNum(num1, num2));
    }
}
