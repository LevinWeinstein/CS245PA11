public class CS245_PA_11_Test {


    public static void main(String []args){
        Judge g = new Judge();


        int [][]test1 = {{1, 2}};
        System.out.println("Example test one:");
        System.out.printf("Expected: \"2\". Got: \"%d\"\n\n", g.findJudge(2, test1));

        int [][]test2 = {{1, 3}, {2, 3}};
        System.out.println("Example test two:");
        System.out.printf("Expected: \"3\". Got: \"%d\"\n\n", g.findJudge(3, test2));

        int [][]test3 = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println("Example test three:");
        System.out.printf("Expected: \"-1\". Got: \"%d\"\n\n", g.findJudge(3, test3));

        int [][]test4 = {{1, 2}, {2, 3}};
        System.out.println("Example test four:");
        System.out.printf("Expected: \"-1\". Got: \"%d\"\n\n", g.findJudge(3, test4));

        int [][]test5 = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println("Example test five:");
        System.out.printf("Expected: \"3\". Got: \"%d\"\n\n", g.findJudge(4, test5));



        int [][]vertices = new int[10000][2];
        for (int i = 0; i < 10000; i++) {
            // All people but "7" are trusting of one person.
            vertices[i][0] = i == 6 ? i : i + 1;

            // and that person they trust? is seven.
            vertices[i][1] = 7;
        }

        System.out.println("Testing with 10000 * 10000 size:");
        System.out.printf("Expected: \"7\". Got: \"%d\"\n", g.findJudge(10000, vertices));
    }
}
