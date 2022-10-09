public class HmacSHA1 {

  private static final String MAC_NAME = "HmacSHA1";
  private static final String ENCODING = "UTF-8";

  public static byte[] sign(String data2Sign, String key) throws Exception {
    byte[] keyBytes=key.getBytes(ENCODING);
    SecretKey secretKey = new SecretKeySpec(keyBytes, MAC_NAME);
    Mac mac = Mac.getInstance(MAC_NAME);
    mac.init(secretKey);

    byte[] text = data2Sign.getBytes(ENCODING);
    return mac.doFinal(text);
  }
}
