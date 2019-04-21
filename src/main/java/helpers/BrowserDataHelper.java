package helpers;

import java.util.HashMap;
import java.util.Map;

public class BrowserDataHelper {

  private BrowserDataHelper(){
    throw new UnsupportedOperationException();
  }

  public static Map<String, Object> browserData = new HashMap<>();
}
