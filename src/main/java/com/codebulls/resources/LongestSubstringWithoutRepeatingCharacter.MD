### Longest Substring Without Repeating Characters
   
Hint

Given a string s, find the length of the longest substring without duplicate characters.

#### Example 1:

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

#### Example 2:

```shell
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

#### Example 3:

```shell
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
```

Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Substring = minimmun of 2 characters that are adjacent to each other in the string.

Constraints:

```shell
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
```

Complexity Summary

Sliding Window + Index Map	O(n)	O(k)

Where k is the character-set size (e.g. 128 for ASCII).