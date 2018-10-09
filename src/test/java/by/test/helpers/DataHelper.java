package by.test.helpers;

import java.util.ResourceBundle;

public class DataHelper {

  private static ResourceBundle resource = ResourceBundle.getBundle("test_data");

  public static String get(String data_name){
    return resource.getString(data_name);
  }

}
