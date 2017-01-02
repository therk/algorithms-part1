import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by therk on 1/1/17.
 */
public class PercolationStats {
  // perform trials independent experiments on an n-by-n grid

  private double[] experiments;
  private int trials;

  public PercolationStats(int n, int t) {
    if (n <= 0 || t <= 0) {
      throw new java.lang.IllegalArgumentException("n and trials must both be greater then 0");
    }

    experiments = new double[t];

    this.trials = t;

    runExperiments(n, t);
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      StdOut.println("Invalid number of arguments. Must have two arguments: \n"
          + "\tGrid Size (n-by-n) \n\tNumber of Independent computational Experiments");
      return;
    }

    int n = Integer.parseInt(args[0]);
    int t = Integer.parseInt(args[1]);
    PercolationStats ps = new PercolationStats(n, t);
    StdOut.println("mean                    = " + ps.mean());
    StdOut.println("stddev                  = " + ps.stddev());
    StdOut.println("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());

  }

  private void runExperiments(int n, int t) {
    for (int i = 0; i < t; i++) {
      int sitesOpen = runExperiment(n);
      experiments[i] = (double) sitesOpen / (n * n);
    }
  }

  private int runExperiment(int n) {
    Percolation p = new Percolation(n);
    int sitesOpen = 0;
    while (!p.percolates()) {
      int x = StdRandom.uniform(1, n + 1);
      int y = StdRandom.uniform(1, n + 1);
      if (!p.isOpen(x, y)) {
        p.open(x, y);
        sitesOpen++;
      }
    }
    return sitesOpen;
  }

  // sample mean of percolation threshold
  public double mean() {
    return StdStats.mean(experiments);
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return StdStats.stddev(experiments);
  }

  // low  endpoint of 95% confidence interval
  public double confidenceLo() {
    return mean() - confidence();
  }

  private double confidence() {
    return (1.96 * stddev()) / Math.sqrt(trials);
  }

  // high endpoint of 95% confidence interval
  public double confidenceHi() {
    return mean() + confidence();
  }
}
