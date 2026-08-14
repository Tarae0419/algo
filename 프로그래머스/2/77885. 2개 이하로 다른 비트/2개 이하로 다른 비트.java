class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];

            if (number % 2 == 0) {
                answer[i] = number + 1;
            } else {
                String binary = "0" + Long.toBinaryString(number);
                StringBuilder sb = new StringBuilder(binary);

                int zeroIndex = sb.lastIndexOf("0");

                sb.setCharAt(zeroIndex, '1');
                sb.setCharAt(zeroIndex + 1, '0');

                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }

        return answer;
    }
}