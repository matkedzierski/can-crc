package can;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class CRC {

    public int calculate(int[] data) {
        short crc = 0;
        for (int current : data) {
            crc ^= (short) (current << 7);
            for (int i = 0; i < 8; i++) {
                crc <<= 1;
                if ((crc & 0x8000) != 0) {
                    crc ^= 0x4599;
                }
            }
            crc &= 0x7fff;
        }
        return crc;
    }

    public static int[] bitStringToByteArray(String input) {
        List<Integer> byteList = new ArrayList<>();
        for (int i = input.length() - 1; i >= 0; i -= 8) {
            String byteString = "";
            for (int j = 0; (i - j) >= 0 && j < 8; j++) {
                byteString = input.charAt(i - j) + byteString;
            }
            if (byteString != "") {
                byteList.add(Integer.parseInt(byteString, 2));
            }
        }
        Collections.reverse(byteList);
        int[] bytesOut = new int[byteList.size()];
        for(int i = 0; i < byteList.size(); i++){
            bytesOut[i] = byteList.get(i);
        }
        return bytesOut;
    }

    public static String bytesToHex(int bytee) {
        return Integer.toString(bytee, 16);
    }
}
