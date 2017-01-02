import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by therk on 1/1/17.
 */
public class Percolation {
  private final int topGroup = 0;
  private boolean[][] grid;
  private int size;
  private int bottomGroup;
  private WeightedQuickUnionUF qu;
  private int openSites = 0;

  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IndexOutOfBoundsException("The size should be greater then 0");
    }

    size = n;
    bottomGroup = size ^ 2 + 1;

    qu = new WeightedQuickUnionUF(size * size + 2);
    grid = new boolean[size][size];

  }

  // open site (row, col) if it is not open already
  public void open(int row, int col) {
    if (row <= 0 || row > size || col <= 0 || col > size) {
      throw new IndexOutOfBoundsException("Invalid row and/or column values. They should be greater then 0 and less then or equal to size of " + size);
    }
    if (isOpen(row, col)) {
      return;
    }

    openSites = openSites + 1;

    grid[row - 1][col - 1] = true;
    if (row == 1) {
      qu.union(coordinateToIndex(row, col), topGroup);
    }
    if (row == size) {
      qu.union(coordinateToIndex(row, col), bottomGroup);
    }

    if (col > 1 && isOpen(row, col - 1)) {
      qu.union(coordinateToIndex(row, col), coordinateToIndex(row, col - 1));
    }
    if (col < size && isOpen(row, col + 1)) {
      qu.union(coordinateToIndex(row, col), coordinateToIndex(row, col + 1));
    }
    if (row > 1 && isOpen(row - 1, col)) {
      qu.union(coordinateToIndex(row, col), coordinateToIndex(row - 1, col));
    }
    if (row < size && isOpen(row + 1, col)) {
      qu.union(coordinateToIndex(row, col), coordinateToIndex(row + 1, col));
    }
  }

  // is site (row, col) open?
  public boolean isOpen(int row, int col) {
    if (row <= 0 || row > size || col <= 0 || col > size) {
      throw new IndexOutOfBoundsException("Invalid row and/or column values. They should be greater then 0 and less then or equal to size of " + size);
    }

    return grid[row - 1][col - 1];
  }

  // is site (row, col) full?
  public boolean isFull(int row, int col) {
    if (row <= 0 || row > size || col <= 0 || col > size) {
      throw new IndexOutOfBoundsException("Invalid row and/or column values. They should be greater then 0 and less then or equal to size of " + size);
    }
    return qu.connected(topGroup, coordinateToIndex(row, col));
  }

  // number of open sites
  public int numberOfOpenSites() {
    return openSites;

  }

  private int coordinateToIndex(int row, int col) {
    return size * (row - 1) + col;
  }

  // does the system percolate?
  public boolean percolates() {
    return qu.connected(topGroup, bottomGroup);
  }
}
