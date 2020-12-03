package com.icecreamhead.adventofcode.thirteen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Firewall {

  private final Map<Integer, Layer> layers;
  private final int packetDepth;
  private final int delay;

  public static Firewall init(int delay) {
    return new Firewall(new HashMap<>(), delay, -1);
  }

  public Firewall(Map<Integer, Layer> layers, int delay, int packetDepth) {
    this.layers = layers;
    this.delay = delay;
    this.packetDepth = packetDepth;
  }

  public void addLayer(int depth, int range) {
    layers.put(depth, new Layer(depth, range));
  }

  public final Firewall next() {
    for (Integer layer : layers.keySet()) {
      layers.put(layer, layers.get(layer).next());
    }
    printLayers();
    return new Firewall(layers, delay > 0 ? delay - 1 : 0, delay <= 0 ? packetDepth + 1 : packetDepth);
  }

  public void printLayers() {
    int max = layers.keySet().stream().mapToInt(x -> x).max().getAsInt();
    System.out.println("\nLayers: " + Arrays.toString(IntStream.range(0, max + 1).mapToObj(this::getLayer).map(l -> l.scannerPos < 0 ? packetDepth == l.depth ? "(..)" : ".." : packetDepth == l.depth ? "(" + String.valueOf(l.scannerPos) + ")" : String.valueOf(l.scannerPos)).toArray(String[]::new)));
  }

  public final int severity() {
    return getLayer(packetDepth).severity(packetDepth);
  }

  public int depth() {
    return packetDepth;
  }

  public int scannerPos() {
    return getLayer(packetDepth).scannerPos;
  }

  private Layer getLayer(int depth) {
    return layers.getOrDefault(depth, new Layer(depth, 0, -1, false));
  }

  public final boolean finished() {
    return packetDepth > layers.keySet().stream().mapToInt(x -> x).max().getAsInt();
  }

  private class Layer {
    private final int depth;
    private final int range;
    private final int scannerPos;
    private final boolean forwards;

    public Layer(int depth, int range) {
      this.depth = depth;
      this.range = range;
      this.scannerPos = 0;
      this.forwards = true;
    }

    public Layer(int depth, int range, int scannerPos, boolean forwards) {
      this.depth = depth;
      this.range = range;
      this.scannerPos = scannerPos;
      this.forwards = forwards;
    }

    public Layer next() {
      if (forwards && scannerPos == range - 1) {
        return new Layer(depth, range, scannerPos - 1, false);
      } else if (!forwards && scannerPos == 0) {
        return new Layer(depth, range, scannerPos + 1, true);
      }
      return new Layer(depth, range, scannerPos + (forwards ? 1 : -1), forwards);
    }

    public int severity(int packetDepth) {
      if (packetDepth == depth && scannerPos == 0) {
        System.out.println(depth + "*" + range + "=" + (depth * range));
        return depth * range;
      }
      return 0;
    }
  }
}
