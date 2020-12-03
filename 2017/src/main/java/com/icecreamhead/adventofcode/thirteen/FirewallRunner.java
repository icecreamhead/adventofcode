package com.icecreamhead.adventofcode.thirteen;

public class FirewallRunner {

  private Firewall firewall;

  private int severity = 0;

  public FirewallRunner(int delay) {
    firewall = Firewall.init(delay);
    System.out.println("\nNew run with delay " + delay);
  }

  public void run(String input) {
    for (String layer : input.split("\n")) {
      String[] vals = layer.split(": ");
      firewall.addLayer(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]));
      System.out.println("Added layer " + layer + " (" + Integer.parseInt(vals[0]) + "," + Integer.parseInt(vals[1]) + ")");
    }
    firewall.printLayers();
    while (!firewall.finished()) {
      int sev = firewall.severity();
      System.out.println("Current depth=" + firewall.depth() + " scannerPos=" + firewall.scannerPos() + " severity=" + sev);
      severity += sev;
      firewall = firewall.next();
    }
  }

  public int severity() {
    return severity;
  }
}
