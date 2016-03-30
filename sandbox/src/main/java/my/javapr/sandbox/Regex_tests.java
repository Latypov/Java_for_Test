package my.javapr.sandbox;

/**
 * Created by Nurulla on 3/27/2016.
 */
public class Regex_tests {

  public static final String TEST = "Peter Sidoroff\\n108108 Moscow, ul. Petrovka, d.38\\n\\nH: +7(111)\\nW: 33 33 33\\n\\npeter.sidoroff@mail.com (www.mail.com)";

  public static void main(String[] args) {
    System.out.println(TEST.replaceFirst("\\s", "\\\\n").replaceAll("\\\\n\\\\n", "\\\\n").replaceAll("(H: )", "")
            .replaceAll("(M: )", "").replaceAll("(W: )", "").replaceAll("\\(www.mail.com\\)", ""));
    System.out.println("Peter\\nSidoroff\\n108108 Moscow, ul. Petrovka, d.38\\n+7(111)\\n33 33 33\\npeter.sidoroff@mail.com");
    }
//"Peter\nSidoroff\n108108 Moscow, ul. Petrovka, d.38\n+7(111)\n33 33 33\npeter.sidoroff@mail.com"
  //replaceFirst("\\s", "\\\\n").  replaceAll("\\\\n\\\\n", "\\\\n").  \\(www(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$\\)
//replaceFirst("\\s", "\\\\n").replaceAll("\\\\n\\\\n", "\\\\n").replaceAll("\(www.mail.com\)
}