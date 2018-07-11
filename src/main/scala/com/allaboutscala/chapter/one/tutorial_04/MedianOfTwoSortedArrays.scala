package com.allaboutscala.chapter.one.tutorial_04

import scala.collection.mutable.ListBuffer

/**
  * Created by lucas on 6/17/2018.
  */
object MedianOfTwoSortedArrays extends App {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    if (nums1.length == 0 ) {
      val median_index = nums2.length / 2
      if (nums2.length % 2 == 0 ) { return  (nums2(median_index) + nums2(median_index - 1)) / 2.0}
      else {return  nums2(median_index).toDouble}
    } else if (nums2.length == 0 ) {
      val median_index = nums1.length / 2
      if (nums1.length % 2 == 0 ) { return  (nums1(median_index) + nums1(median_index - 1)) / 2.0}
      else {return  nums1(median_index).toDouble}
    }

    val parity = (nums1.length + nums2.length) % 2
    val median_index = (nums1.length + nums2.length) / 2

    var numList = new ListBuffer[Int]()
    var (min1, min1Index, operator1) = {
      if (nums1.head >= nums1.last) (nums1.last, nums1.length - 1, -1) else (nums1.head, 0, 1)
    }
    var (min2, min2Index, operator2) = {
      if (nums2.head >= nums2.last) (nums2.last, nums2.length - 1, -1) else (nums2.head, 0, 1)
    }

    var continue = true
    while (continue) {
      println(numList)
        if (min1Index < nums1.length && min1Index >= 0) {
          val a = nums1(min1Index)
          println(a)
          if (min2Index < nums2.length && min2Index >= 0) {
            val b = nums2(min2Index)
            println(b)
            numList += {
              if (a < b) {
                min1Index += operator1;
                a
              } else {
                min2Index += operator2;
                b
              }
            };
            println(numList);


          } else {
            numList += a;
            min1Index += operator1;

          }
        } else if (min2Index < nums2.length && min2Index >= 0) {
          val b = nums2(min2Index)
          numList += b;
          min2Index += operator2;

        } else
    {
      continue = false
    }
    }

    if (parity == 0) (numList(median_index) + numList(median_index - 1)) / 2.0
    else {
      numList(median_index).toDouble
    }
  }

  val arr1 = Array[Int](3)
  val arr2 = Array[Int]()
  println(findMedianSortedArrays(arr1, arr2))

}

