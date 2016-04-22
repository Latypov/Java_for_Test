package my.javapr.mantis.model;

/**
 * Created by Nurulla on 4/19/2016.
 */
public class MailMessage {

  public String to;
  public String text;

  public MailMessage(String to, String text) {
    this.to = to;
    this.text = text;
  }
}
