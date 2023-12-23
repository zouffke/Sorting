package sorting;

/**
 * Class for calculating the function of an array
 */
public final class FunctionCalculator {
    /**
     * Private constructor
     */
    private FunctionCalculator() {
    }

    /**
     * Returns the function of the array
     * @param arr array to check
     * @return function of the array
     */
    public static String getFunction(int[] arr) {
        if (arr.length < 10) {
            throw new RuntimeException("Array is too small");
        }

        int functionType = findFunctionType(arr);
        return switch (functionType) {
            case 0 -> String.format("O(1) = %d(1)", arr[0]);
            case 1 -> String.format("O(n) = %d(n)", arr[1] - arr[0]);
            case 2 -> "O(n²)";
            case 3 -> "Exponential";
            default -> "Unknown";
        };
    }

    /**
     * Finds the type of the function
     *
     * @param arr array to check
     * @return 0 if the function is constant, 1 if the function is linear, 2 if the function is quadratic, 3 if the function is exponential, -1 if the function is unknown
     */
    private static int findFunctionType(int[] arr) {
        if (constant(arr)) return 0;

        if (linear(arr)) return 1;

        if (quadratic(arr)) return 2;

        if (exponential(arr)) return 3;

        return -1;
    }

    /**
     * Checks if the array is constant
     * <p>O(1)</p>
     * <p>If the difference between two consecutive elements is 0, then it is an constant sequence.</p>
     * <table border="1">
     * 		<tbody>
     * 			<tr>
     * 				<td>&nbsp;75</td>
     * 				<td>&nbsp;</td>
     * 				<td>&nbsp;75</td>
     * 				<td>&nbsp;</td>
     * 				<td>&nbsp;75</td>
     * 				<td>&nbsp;</td>
     * 				<td>&nbsp;75</td>
     * 			</tr>
     * 			<tr>
     * 				<td>&nbsp;</td>
     * 				<td>+0&nbsp;</td>
     * 				<td>&nbsp;</td>
     * 				<td>+0&nbsp;</td>
     * 				<td>&nbsp;</td>
     * 				<td>+0&nbsp;</td>
     * 				<td>&nbsp;</td>
     * 			</tr>
     * 		</tbody>
     * 	</table>
     *
     * @param arr array to check
     * @return true if the array is constant
     * @see <a href="https://en.wikipedia.org/wiki/Constant_function">Constant function</a>
     */
    private static boolean constant(int[] arr) {
        int size = arr.length - 1;
        return arr[0] == arr[1] && arr[size] == arr[size - 1] && arr[0] == arr[size];
    }

    /**
     * Checks if the array is linear
     * <p>O(n)</p>
     * <p>If the difference between two consecutive elements is the same than the difference between two other consecutive elements, then it is a linear sequence.</p>
     * <table border="1">
     * 		<tbody>
     * 			<tr>
     * 				<td>&nbsp;75</td>
     * 				<td>&nbsp;</td>
     * 				<td>&nbsp;150</td>
     * 				<td>&nbsp;</td>
     * 				<td>&nbsp;225</td>
     * 				<td>&nbsp;</td>
     * 				<td>&nbsp;300</td>
     * 			</tr>
     * 			<tr>
     * 				<td>&nbsp;</td>
     * 				<td>+75&nbsp;</td>
     * 				<td>&nbsp;</td>
     * 				<td>+75&nbsp;</td>
     * 				<td>&nbsp;</td>
     * 				<td>+75&nbsp;</td>
     * 				<td>&nbsp;</td>
     * 			</tr>
     * 		</tbody>
     * 	</table>
     *
     * @param arr array to check
     * @return true if the array is linear
     * @see <a href="https://en.wikipedia.org/wiki/Linear_function">Linear function</a>
     */
    private static boolean linear(int[] arr) {
        int dif = arr[1] - arr[0];
        return arr[0] + dif * 10 == arr[arr.length - 1] && arr[5] + dif == arr[6];
    }

    /**
     * Checks if the array is quadratic
     *
     * <p>O(n²)</p>
     * <p>If the difference between the difference of two consecutive elements is the same, then it is a quadratic sequence.</p>
     * <table border="1">
     * 		<tbody>
     * 			<tr>
     * 				<td>&nbsp;45</td>
     * 				<td>&nbsp;</td>
     * 				<td>&nbsp;190</td>
     * 				<td>&nbsp;</td>
     * 				<td>&nbsp;435</td>
     * 				<td>&nbsp;</td>
     * 				<td>&nbsp;780</td>
     * 			</tr>
     * 			<tr>
     * 				<td>&nbsp;</td>
     * 				<td>+145&nbsp;</td>
     * 				<td>&nbsp;</td>
     * 				<td>+245&nbsp;</td>
     * 				<td>&nbsp;</td>
     * 				<td>+345&nbsp;</td>
     * 				<td>&nbsp;</td>
     * 			</tr>
     * 		    <tr>
     * 	            <td>&nbsp;</td>
     * 	            <td>&nbsp;</td>
     * 	            <td>+100&nbsp;</td>
     * 	            <td>&nbsp;</td>
     * 	            <td>+100&nbsp;</td>
     * 	            <td>&nbsp;</td>
     * 	            <td>&nbsp;</td>
     *          </tr>
     * 		</tbody>
     * 	</table>
     *
     * @param arr array to check
     * @return true if the array is quadratic
     * @see <a href="https://en.wikipedia.org/wiki/Quadratic_function">quadratic</a>
     */
    private static boolean quadratic(int[] arr) {
        int[] difs = new int[3];
        for (int i = 0; i < difs.length; i++) {
            difs[i] = arr[i + 1] - arr[i];
        }

        int difDif = difs[1] - difs[0];
        if (difDif == 0) return false;
        int arrLength = arr.length;

        return difDif == difs[2] - difs[1] && arr[4] == arr[3] + arr[3] - arr[2] + difDif && arr[arrLength - 1] == arr[arrLength - 2] + arr[arrLength - 2] - arr[arrLength - 3] + difDif;
    }

    /**
     * Checks if the array is exponential
     *
     * <p>O(2^n)</p>
     * <p>If the quotient of two consecutive elements is the same as the quotient of two other consecutive elements, then the sequence is exponential</p>
     *
     * <table border="1">
     * 		<tbody>
     * 			<tr>
     * 				<td>&nbsp;2</td>
     * 				<td>&nbsp;</td>
     * 				<td>&nbsp;6</td>
     * 				<td>&nbsp;</td>
     * 				<td>&nbsp;18</td>
     * 				<td>&nbsp;</td>
     * 				<td>&nbsp;54</td>
     * 			</tr>
     * 			<tr>
     * 				<td>&nbsp;</td>
     * 				<td>*3&nbsp;</td>
     * 				<td>&nbsp;</td>
     * 				<td>*3&nbsp;</td>
     * 				<td>&nbsp;</td>
     * 				<td>*3&nbsp;</td>
     * 				<td>&nbsp;</td>
     * 			</tr>
     * 		</tbody>
     * 	</table>
     *
     * @param arr array to check
     * @return true if the array is exponential
     * @see <a href="https://en.wikipedia.org/wiki/Exponential_function">Exponential function</a>
     */
    private static boolean exponential(int[] arr) {
        double quotient = (double) arr[1] / arr[0];
        int size = arr.length - 1;
        return quotient == (double) arr[2] / arr[1] && arr[0] * Math.pow(quotient, size) == arr[size] && arr[0] * Math.pow(quotient, 5) == arr[5];
    }
}
