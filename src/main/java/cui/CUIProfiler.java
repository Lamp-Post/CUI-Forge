package cui;

import java.util.ArrayList;
import java.util.Stack;

public class CUIProfiler
{
  private Stack<ProfileData> workStack = new Stack();
  private ArrayList<ProfileData> stack = new ArrayList();
  private boolean enabled = false;

  private static CUIProfiler getInstance()
  {
    return CUIProfilerHolder.INSTANCE;
  }

  private void _in(String name) {
    if (this.enabled)
      this.workStack.push(new ProfileData(name, System.currentTimeMillis(), this.workStack.size()));
  }

  private void _out(String name)
  {
    if (this.enabled) {
      ProfileData data = (ProfileData)this.workStack.pop();

      if (data.name.equals(name)) {
        data.setEndTime(System.currentTimeMillis());
        this.stack.add(data);
      }
    }
  }

  public static void in(String name) {
    getInstance()._in(name);
  }

  public static void out(String name) {
    getInstance()._out(name);
  }

  public static ArrayList<String> debug() {
    ArrayList out = new ArrayList();
    for (ProfileData d : getInstance().stack) {
      out.add(d.toString());
    }
    return out;
  }

  public static void setEnabled(boolean b) {
    getInstance().enabled = b;
  }

  public static void reset() {
    getInstance().stack.clear();
    getInstance().workStack.clear();
  }

  private static class ProfileData
  {
    public String name;
    public long time;
    public int size;
    public long end_time = -1L;

    public ProfileData(String name, long time, int size) {
      this.name = name;
      this.time = time;
      this.size = size;
    }

    public void setEndTime(long end_time) {
      this.end_time = end_time;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder().append("{").append(this.name).append(": ");
      if (this.end_time != -1L)
        sb.append("Total ").append(this.end_time - this.time).append(" ms}");
      else {
        sb.append("Still running, for ").append(System.currentTimeMillis() - this.time).append(" ms}");
      }
      return sb.toString();
    }
  }

  private static class CUIProfilerHolder
  {
    private static final CUIProfiler INSTANCE = new CUIProfiler();
  }
}