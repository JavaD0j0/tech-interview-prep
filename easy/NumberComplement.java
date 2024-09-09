package easy;

public class NumberComplement {
    public static int findComplement(int num) {
        // Find the number of bits in the binary representation of the number
        int bitLength = Integer.toBinaryString(num).length();

        // Create a mask with all bits set to 1 that matches the length of the binary representation
        int mask = (1 << bitLength) - 1;

        // XOR the number with the mask to flip the bits
        return num ^ mask;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println(findComplement(5));  // Output will be 2
        System.out.println(findComplement(1));  // Output will be 0
    }
}
