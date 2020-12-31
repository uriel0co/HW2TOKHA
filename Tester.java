package part1;

public class Tester {

    public static void main(String[] args){
        Tester t = new Tester();
        t.testGetFollow();
    }

    public void testGetFollow(){
        MarkovOne markov = new MarkovOne();
        markov.setTraining("this is a test yes this is a test.");
        System.out.println(markov.getFollows("."));
    }
}
