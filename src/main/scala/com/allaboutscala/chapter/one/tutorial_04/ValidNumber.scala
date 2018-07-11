package com.allaboutscala.chapter.one.tutorial_04
import scala.util.matching.Regex
/**
  * Created by lucas on 6/18/2018.
  */
object ValidNumber extends App {
  val pattern0 = raw"\d+".r;
  val pattern1 = raw"[aA-zZ]{1}".r;
  val pattern2: Regex = raw"[-, +]*\d+e[-, +]*\d+".r;
  val pattern3: Regex = raw"[-, +]*\d+\.\d*e[-, +]*\d+".r;
  val pattern4: Regex = raw"[-, +]*\d*\.\d+e[-, +]*\d+".r;
  val pattern5: Regex = raw"[-, +]*\d*\.\d+".r;
  val pattern6: Regex = raw"[-, +]*\d+\.\d*".r;
  val pattern7: Regex = raw".".r


  def decimalTest1(cleanString: String): Boolean = {
    //Test about the decimal numbers
    //if (cleanString.contains("..")) return false
    val tmp3 = pattern5.findAllIn(cleanString).toList;
    //println(tmp3)
    val tmp4 = pattern6.findAllIn(cleanString).toList;
    //println(tmp4)
    val tmp = { if (!tmp4.isEmpty) tmp4 else if (!tmp3.isEmpty) tmp3
    else return false}
    //println(tmp(0))
    if (tmp.length > 1 || tmp.head != cleanString) return false;
    //println("returning true")
    return true
  }
//  def decimalTest2(cleanString: String): Boolean = {
//    println(s"%s is being tested".format(cleanString))
//    val tmp = pattern4.findAllIn(cleanString).toList;
//    //println(tmp.length)
//    if (tmp.isEmpty) return false
//    if (tmp.length > 1 || tmp.head != cleanString) return false;
//    println("returning true")
//    return true
//  }
  def isNumber(s: String): Boolean = {

    val cleanString = s.replaceAll("""^\s+""", "").replaceAll("""\s+$""", "") //get rid of beginning and tailing whitespaces
    if (pattern0.findAllIn(cleanString).isEmpty) return false //if there are no numbers in a list. rule it out
    val characters = pattern1.findAllIn(cleanString).toList
    var result = false;
    //

    // println(characters)
    if (characters.isEmpty) //no alphabetical characters are found
     {
      if (cleanString.contains(".") ) {
        if (decimalTest1(cleanString)) return true
        else return false
      }
      else if (cleanString == ""){
        return false
      } else if (pattern0.findAllIn(cleanString).next() == cleanString){
        return true
      }
    }
    else if (characters.length > 1 || characters.head != "e")
      return false;
    try {
      val num = cleanString.toInt
    }  catch { case e: Exception =>
      //val tmp0 = pattern0.findAllIn(c)
      val tmp1 = pattern2.findAllIn(cleanString).toList;
      //println(tmp1)
      val tmp2 = pattern3.findAllIn(cleanString).toList;
      //println(tmp2)
      val tmp3 = pattern4.findAllIn(cleanString).toList;
      //println(tmp3)
      val tmp = {if (!tmp2.isEmpty) tmp2 else if (!tmp3.isEmpty) tmp3 else if (!tmp1.isEmpty) tmp1   else return false}
      //println(tmp.head)

      if (tmp.length > 1 || tmp.head != cleanString) return false;
      result = true
    } finally {
      result = true
    }

    return result
    // strip all spaces
    // if the statment contains a character other than e. false
    // if the statement has an e, then test if the statement matches the regex
    // else it is a number then its good, else go to next filter
    // if this
  }
  var index = 0
  println(isNumber("12345213124"))
  println(isNumber("-1."), index); index+=1 //0
  println(isNumber("2e0"), index); index+=1 //1
  println(isNumber("+2e0"), index); index+=1 //2
  println(isNumber("-0"), index); index+=1 // 3
  println(isNumber("46.e3"), index); index+=1//4
  println(isNumber(".2e28"), index); index+=1 //5
  println(isNumber("1.e1"), index); index+=1 //6
  println(isNumber("1.000"), index); index+=1//7
  println(isNumber("-0.0"), index); index+=1//8
  println(isNumber("-.1"), index); index+=1//9
  println(isNumber(".1"), index); index+=1//9
  println(isNumber("+.0"), index); index+=1//10
  println(isNumber("+1."), index); index+=1//11
  println(isNumber("-."), index); index+=1//12
  println(isNumber("."), index); index+=1
  println(isNumber("+."), index); index+=1
  println(isNumber("-.e"), index); index+=1
  println(isNumber("e"), index); index+=1
  println(isNumber("e3"), index); index+=1
  println(isNumber("1e"), index); index+=1
  println(isNumber("+e"), index); index+=1
  println(isNumber(".e3"), index); index+=1
  println(isNumber("-.e3"), index); index+=1
  println(isNumber("+.e3"), index); index+=1
  println(isNumber("-.e1"), index); index+=1
  println(isNumber("D+"), index); index+=1
  println(isNumber("+++D123D"), index); index+=1
  println(isNumber(".."), index); index+=1

  //println(pattern4.findAllIn(".20000").toList(0))
}