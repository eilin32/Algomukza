package kr.co.mlec.calendar.vo;

public class CalendarVO {
   private int cnum;
   private String id, start, end, title;
   
   public int getCnum() {
      return cnum;
   }
   public void setCnum(int cnum) {
      this.cnum = cnum;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getStart() {
      return start;
   }
   public void setStart(String start) {
      this.start = start;
   }
   public String getEnd() {
      return end;
   }
   public void setEnd(String end) {
      this.end = end;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   @Override
   public String toString() {
      return "CalendarVO [cnum=" + cnum + ", id=" + id + ", start=" + start + ", end=" + end + ", title=" + title
            + "]";
   }
   
   
}