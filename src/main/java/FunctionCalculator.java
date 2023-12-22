public final class FunctionCalculator {
    private FunctionCalculator() {
    }

    public static int findFunctionType(int[] arr) {
        if (arr.length < 10) {
            throw new RuntimeException("Array is too small");
        }

        if (constant(arr)) return 0;

        if (linear(arr)) return 1;

        if (quadratic(arr)) return 2;

        return -1;
    }

    /**
     * Checks if the array is constant
     * <p></p>
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
     * Checks if the array is arithmetic
     * <p></p>
     * <p>If the difference between two consecutive elements is the same, then it is an arithmetic sequence.</p>
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
     * @return true if the array is arithmetic
     * @see <a href="https://en.wikipedia.org/wiki/Arithmetic_function">Arithmetic function</a>
     */
    private static boolean linear(int[] arr) {
        int dif = arr[1] - arr[0];
        return dif * 10 == arr[9] && arr[5] + dif == arr[6];
    }

    /**
     * Checks if the array is quadratic
     *
     * <p></p>
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
        int arrLength = arr.length;

        return difDif == difs[2] - difs[1] && arr[4] == arr[3] + arr[3] - arr[2] + difDif && arr[arrLength - 1] == arr[arrLength - 2] - arr[arrLength - 3] + difDif;
    }


    private static boolean logarithmic(int[] arr){

    }
}
