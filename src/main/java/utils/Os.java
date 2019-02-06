package utils;

public class Os {
	private static String oS = null;
	
	public static String getOsName() {
      if(oS == null) { oS = System.getProperty("os.name"); }
      return oS;
    }
	
   public static boolean isWindows()
   {
      return getOsName().startsWith("Windows");
   }
   
   public static boolean isMac()
   {
      return getOsName().startsWith("Mac");
   }
}
