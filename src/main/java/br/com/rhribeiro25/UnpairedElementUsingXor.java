package br.com.rhribeiro25;

public class UnpairedElementUsingXor {
    public int solution(int[] A) {
        int result = 0;

        // XOR de todos os elementos
        for (int num : A) {
            result ^= num;
        }

        // O único número não pareado é o valor de 'result'
        return result;
    }
    public static void main(String[] args){
        UnpairedElementUsingXor unpairedElementUsingXor = new UnpairedElementUsingXor();
        System.out.println(unpairedElementUsingXor.solution(new int[]{1,3,5,3,1}));
    }
}
