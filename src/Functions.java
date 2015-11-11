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

    static boolean isMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != matrix[0].length) {
                return false;
            }
        }
        return true;
    }

    static boolean canBeMultiplied(int[][] matrix1, int[][] matrix2) {
        if ((matrix1 == null) || (matrix2 == null) ||
                (matrix1.length == 0) || (matrix2.length == 0) ||
                !isMatrix(matrix1) || !isMatrix(matrix2) ||
                (matrix1[0].length != matrix2.length)) {
            return false;
        }
        return true;
    }

    static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        if (!canBeMultiplied(matrix1, matrix2)) {
            return null;
        }
        int[][] matrixRes = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrixRes.length; i++) {
            for (int j = 0; j < matrixRes[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    matrixRes[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixRes;
    }

    static boolean isEqual(double value1, double value2) {
        if (Math.abs(value1 - value2) < 1.0e-10) {
            return true;
        }
        return false;
    }

    static double[] intersectArrays(double[] arr1, double[] arr2) {
        if (arr1 == null || arr2 == null
                || arr1.length == 0 || arr2.length == 0) {
            return null;
        }
        int size = 0;
        double[] arrTmp = new double[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            int j = 0;
            while ((j < arr2.length) && !isEqual(arr2[j], arr1[i])) {
                j++;
            }
            int k = 0;
            while (!isEqual(arrTmp[k], arr1[i]) && (k < size)) {
                k++;
            }
            if ((j < arr2.length) && (k == size)) {
                arrTmp[size] = arr1[i];
                size++;
            }
        }
        if (size == 0) {
            return null;
        }
        return Arrays.copyOf(arrTmp, size);
    }
}
