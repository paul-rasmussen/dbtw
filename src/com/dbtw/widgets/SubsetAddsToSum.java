package com.dbtw.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class SubsetAddsToSum {
  //Constants
  //Public variables
  //Protected variables
  //Private variables
  private Integer[] dataset;
  private Integer target;
  private Integer subsetSize;
  private Vector<Integer[]> matches = new Vector<Integer[]>();

  //Constructors
  public SubsetAddsToSum(Integer[] dataSet, Integer targetSum, Integer subsetSize) {
    init(dataSet, targetSum, subsetSize);
  }

  //Static methods
  //Public methods
  public void setDataSet(Integer[] dataSet) {
    dataset = dataSet;
  }
  
  public Integer[] getDataSet() {
    return dataset;
  }
  
  public void setTargetSum(Integer targetSum) {
    target = targetSum;
  }
  
  public Integer getTargetSum() {
    return target;
  }
  
  public void evaluate() {
    recursive_sum(dataset, subsetSize, 0, new Integer[subsetSize]);
  }

  public int getMatchSetSize() {
    return matches.size();
  }
  
  public ArrayList<Integer> getMatchSet(int index) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    System.out.println("Arrays currently in matchs:");
    for (int i = 0; i < matches.size(); i++) {
      System.out.println(Arrays.toString(matches.elementAt(i)));
    }
    Integer[] match = matches.elementAt(index);
    System.out.println("Array at position " + index + ": " + Arrays.toString(match));
    for (int i = 0; i < match.length; i++) {
      list.add(match[i]);
    }
    System.out.println("Array extracted from matches: " + list.toString());
    return list;
  }
  
  public Integer getSetSum() {
    return setSum(dataset);
  }
  
  public Integer getPossibleCombinations() {
    return combinations(dataset.length, subsetSize);
  }

  //Protected methods
  //Private methods
  private void init(Integer[] dataSet, Integer targetSum, Integer subsetSize) {
    dataset = dataSet;
    target = targetSum;
    this.subsetSize = subsetSize; 
    if (subsetSize > dataSet.length) {
      JOptionPane.showMessageDialog(new JFrame(), "Invalid subset size.", "ERROR", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    if ((subsetSize < (dataSet.length/10)) || (targetSum > (setSum(dataSet)/10)))  {
      if (JOptionPane.showConfirmDialog(new JFrame(), "Subset size will result in a very large result set.", "WARNING", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.CANCEL_OPTION) {
        System.exit(0);
      }
    }
  }
  
  private void recursive_sum(Integer[] numbers, int target, Integer start, Integer[] partial) {
    if (target == 0) {
      if (setSum(partial) == this.target) {
        System.out.println("Adding: " + Arrays.toString(partial));
        matches.addElement(partial);
      }
      return;
    }
    for (int i = start; i <= numbers.length-target; i++) {
      partial[partial.length-target] = numbers[i];
      recursive_sum(numbers, target-1, i+1, partial);
    }
  }
  
  private Integer setSum(Integer[] dataset) {
    Integer sum = 0;
    if (dataset.length > 0) {
      for (int i = 0; i < dataset.length; i++) {
        sum += dataset[i];
      }
    }
    return sum;
  }
  
  private Integer factorial(Integer size) {
    if (size > 0) {
      return size *= factorial(size-1);
    }
    return 1;
  }
  
  private Integer limitedFactorial(Integer start, Integer size) {
    if (size > 0) {
      return start *= limitedFactorial(start-1, size-1);
    }
    return 1;
  }
  
  private Integer combinations(Integer n, Integer r) {
    Integer numerator = limitedFactorial(n, r);
    Integer denominator = factorial(r);
    return numerator/denominator;
  }
  
}
