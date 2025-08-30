package linkedListVersion;

public class Description {
  String description;
  String color;
  String detail;

  public Description(String description) {
    this.description = description;
    String[] spDescription = description.split("\\(");
    this.color = spDescription[0].trim();
    this.detail = spDescription[1].substring(0, spDescription[1].length() - 1).trim();
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return String.format("\tColor: %-15s Detail: %-10s", color, detail);
  }
}
