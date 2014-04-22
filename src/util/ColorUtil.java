package util;

/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-22
 * Time: 下午7:51
 * <p/>
 * TODO
 */
public class ColorUtil {

    public static class RGBA {
        public int r;
        public int g;
        public int b;
        public int a; // alpha
    }

    /**
     * hex to RGBA color, support "RGB, RGBA".
     *
     * @param colorHexString
     * @return null if error.
     */
    public static RGBA hexToRGBA(String colorHexString) {

        String local = colorHexString;
        RGBA result = new RGBA();
        if (local.startsWith("#")) {
            local = local.substring(1, local.length());
        }
        int len = local.length();

        if (len > 8) {
            // log error.
            return null;
        } // end if

        String rgbSub;
        try {
            // Alpha
            if (8 == len) {
                int h = hexCharToInt(local.charAt(0));
                int l = hexCharToInt(local.charAt(1));
                result.a = h * 16 + l;
                rgbSub = local.substring(2, len);
            } else if (7 == len) {
                int h = 0xf;
                int l = hexCharToInt(local.charAt(0));
                result.a = h * 16 + l;
                rgbSub = local.substring(1, len);
            } else {
                result.a = 255;
                rgbSub = local;
            }
            // Red
            {
                int h = hexCharToInt(rgbSub.charAt(0));
                int l = hexCharToInt(rgbSub.charAt(1));
                result.r = h * 16 + l;
            }
            // Green
            {
                int h = hexCharToInt(rgbSub.charAt(2));
                int l = hexCharToInt(rgbSub.charAt(3));
                result.g = h * 16 + l;
            }
            // Blue
            {
                int h = hexCharToInt(rgbSub.charAt(4));
                int l = hexCharToInt(rgbSub.charAt(5));
                result.b = h * 16 + l;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    private static int hexCharToInt(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else if (ch >= 'a' && ch <= 'z') {
            return ch - 97 + 10;
        } else if (ch >= 'A' && ch <= 'Z') {
            return ch - 65 + 10;
        } else {
            throw new IllegalArgumentException("Char Not Hex");
        }
    }
}
