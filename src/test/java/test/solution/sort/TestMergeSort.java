package test.solution.sort;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestMergeSolutionRecursiveArrayCopy.class, TestMergeSolutionRecursiveNLogNSpace.class,
		TestMergeSolutionRecursiveNLogNSpaceDivisionOnMerge.class, TestMergeSolutionRecursiveNSpace.class,
		TestMergeSolutionRecursiveOneSpace.class, TestMergeSolutionRecursiveSortedByInsertion.class,
		TestMergeSolutionNonRecursiveWhileLoop.class, TestMergeSolutionNonRecursiveForLoop.class,
		TestMergeSolutionNonRecursivePrinceton.class })
public class TestMergeSort {

}
