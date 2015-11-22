import java.util.Arrays;

public class Functions {

    static int countSymbolNumber(String str, char symbol) {
        if (str == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    static boolean haveSameElement(String[] arr) {
        if (arr == null) {
            return false;
        }
        boolean found = false;
        out:
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    found = true;
                    break out;
                }
            }
        }
        return found;
    }

    static boolean isEmpty(int[][] matrix){
        if (matrix == null || matrix.length == 0){
            return true;
        }
        return false;
    }

    static boolean isMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != matrix[0].length) {
                return false;
            }
        }
        return true;
    }

    static boolean canBeMultiplied(int[][] first, int[][] second) {
        if (isEmpty(first) || isEmpty(second) ||
                !isMatrix(first) || !isMatrix(second) ||
                (first[0].length != second.length)) {
            return false;
        }
        return true;
    }

    static int[][] multiplyMatrix(int[][] first, int[][] second) {
        if (!canBeMultiplied(first, second)) {
            return null;
        }
        int[][] matrixRes = new int[first.length][second[0].length];
        for (int i = 0; i < matrixRes.length; i++) {
            for (int j = 0; j < matrixRes[0].length; j++) {
                for (int k = 0; k < first[0].length; k++) {
                    matrixRes[i][j] += first[i][k] * second[k][j];
                }
            }
        }
        return matrixRes;
    }

    static boolean equals(double first, double second) {
        if (Math.abs(first - second) < 1.0e-10) {
            return true;
        }
        return false;
    }

    static double[] intersect(double[] first, double[] second) {
        if (first == null || second == null
                || first.length == 0 || second.length == 0) {
            return new double[]{};
        }
        int size = 0;
        double[] tmp = new double[first.length];
        for (int i = 0; i < first.length; i++) {
            int j = 0;
            while ((j < second.length) && !equals(second[j], first[i])) {
                j++;
            }
            int k = 0;
            while (!equals(tmp[k], first[i]) && (k < size)) {
                k++;
            }
            if ((j < second.length) && (k == size)) {
                tmp[size] = first[i];
                size++;
            }
        }
        if (size == 0) {
            return new double[]{};
        }
        return Arrays.copyOf(tmp, size);
    }
}
