/*
  43. Multiply Strings - Medium

  Given two non-negative integers num1 and num2 represented as strings, 
  return the product of num1 and num2.

  Note:
  
  The length of both num1 and num2 is < 110.
  Both num1 and num2 contains only digits 0-9.
  Both num1 and num2 does not contain any leading zero.
  You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
#include <iostream>
#include <string>
using namespace std;

string multiply(string num1, string num2) {
  int s1 = num1.size(), s2 = num2.size();
  string* items = new string[s2];
  const char* cnums1 = num1.c_str();
  int* nums1 = new int[s1];
  for (int i = 0; i < s1; i++) {
    nums1[i] = num1[i] - '0';
  }
  int carry = 0;
  for (int i = s2 - 1; i >= 0; i--) {
    int n2 = num2[i] - '0';
    string item = "";
    carry = 0;
    for (int j = s1 - 1; j >= 0; j--) {
      int product = nums1[j] * n2 + carry;
      if (product < 10) {
        item = (char)(product + '0') + item;
        carry = 0;
      }
      else {
        carry = product / 10;
        item = (char)(product % 10 + '0') + item;
      }
    }
    if (carry != 0) {
      item = (char)(carry + '0') + item;
    }
    int zeroNum = s2 - i - 1;
    for (int j = 0; j < zeroNum; j++) {
      item += "0";
    }
    items[i] = item;
  }
  string result = "";
  bool keepLoop = true;
  carry = 0;
  for (int i = 0; keepLoop; i++) {
    int sum = 0;
    keepLoop = false;
    for (int j = 0; j < s2; j++) {
      int itemsJSize = items[j].size();
      if (itemsJSize > i) {
        sum += items[j][itemsJSize - i - 1] - '0';
        keepLoop = true;
      }
    }
    if (!keepLoop) break;
    sum += carry;
    if (sum < 10) {
      result = (char)(sum + '0') + result;
      carry = 0;
    }
    else {
      carry = sum / 10;
      result = (char)(sum % 10 + '0') + result;
    }
  }
  if (carry != 0) {
    result = (char)(carry + '0') + result;
  }
  if (result[0] == '0') return "0";
  return result;
};

int main() {
  cout << multiply("0", "1234") << endl;
}