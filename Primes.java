public class Primes {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        boolean [] arr = new boolean [N + 1];
        int count = 0;
        for (int i = 2 ; i <= N ; i++){
            arr[i] = true;
        }
        System.out.println("Prime numbers up to " + N + ":");
        int j = 2;
        while (j <= N) {
            if (arr[j] == true) {
                count++;
                System.out.println(j);
                int p = j + j;
                while (p <= N) {
                    arr[p] = false;
                    p = p + j;
                }
            }
            j++;
        }
        int primesInPrecents = count * 100 / N ;
        System.out.println("There are " + count + " primes between 2 and " + N + " (" + primesInPrecents + "% are primes)");
    }
}